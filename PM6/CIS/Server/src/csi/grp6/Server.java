package csi.grp6;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.sun.istack.internal.NotNull;


import bean.Account;
import bean.AccountInfo;
import bean.ChatMessage;
import bean.ChatRequest;
import bean.ChatResult;
import bean.RegisterInfo;
import csi.grp6.Worker.OnAuthenticatedListener;
import csi.grp6.Worker.OnRequestReceivedListener;
import utils.Log;
import utils.Security;
import utils.StreamUtilities;
import utils.Task;

public final class Server implements Closeable, OnAuthenticatedListener{
	private ServerSocket serverSocket;
	private List<Worker> workers = new LinkedList<Worker>();
	private Object lock = new Object();
	private RequestHandler requestHandler = new RequestHandler();
	/***************************************************/
	public static List<Object> list = new ArrayList<Object>();
	public static List<Object> rfcLists = Collections.synchronizedList(list);
	public static List<Object> peerLists = Collections.synchronizedList(new ArrayList<Object>());
	public ServerSocket sock;

	public Server(int port, String address, int maxConnection) throws IOException {
		Log.i("Demarrage du serveur...");
		serverSocket = new ServerSocket(port, maxConnection, InetAddress.getByName(address));
		Log.i("Demarrage du serveur...");
	}
	
	public void waitForConnection() throws IOException {
		Log.i("Att...");
		Socket socket = null;
		while ((socket = serverSocket.accept()) != null) {
			Log.i("Yes!! " + socket.getRemoteSocketAddress().toString());
			talkWithClient(socket);
		}
	}

	private Worker createWorker(Socket socket) {
		Worker worker = null;
		try {
			Log.i("Creation d'un Client...");
			worker = new Worker(socket);
		} catch (IOException | SecurityException e) {
			Log.i("Error");
		}

		if (worker != null) {
			synchronized (lock) {
				workers.add(worker);
			}
		} else {
			StreamUtilities.tryCloseStream(socket);
		}
		return worker;
	}

	private void notifyAllWorker(Worker broadcastWorker) {
		synchronized (lock) {
			ChatResult result = new ChatResult();
			result.setCode(ChatResult.CODE_OK);
			result.setRequestCode(ChatRequest.CODE_FRIEND_STATE);
			result.setExtra(broadcastWorker.getAccount());
			for (int i = 0; i < workers.size(); i++) {
				Worker friendWorker = workers.get(i);
				if (!broadcastWorker.equals(friendWorker)) {
					try {
						friendWorker.response(result);
					} catch (IOException e) {
						killWorker(friendWorker);
					}
				}
			}
		}
	}

	private void killWorker(Worker worker) {
		worker.release();
		worker.setOnReceivedDataListener(null);
		worker.setOnAuthenticatedListener(null);
		synchronized (lock) {
			workers.remove(worker);
		}
		if (worker.getAccount() != null) {
			Log.i("By By " + worker.getAccount().getAccountId());
			worker.getAccount().setState(AccountInfo.STATE_OFFLINE);
			notifyAllWorker(worker);
		} else {
			Log.i("By By incon");
		}
	}

	private void talkWithClient(final Socket socket) {
		Task.run(new Runnable() {
			@Override
			public void run() {
				Worker worker = createWorker(socket);
				if (worker != null) {
					try {
						Log.i("Start Conversation!");
						worker.setOnAuthenticatedListener(Server.this);
						worker.setOnReceivedDataListener(requestHandler);
						worker.startBridge();
					} catch (IOException e) {
					}
					killWorker(worker);
				} else {
					Log.i("Conversation Erreur");
				}
			}
		});
	}

	@Override
	public void close() throws IOException {
		serverSocket.close();
		while (!workers.isEmpty()) {
			Worker worker = workers.get(0);
			killWorker(worker);
		}
	}

	@Override
	public void onAuthenticated(Worker worker) {
		Log.i("new Conversation!");
		notifyAllWorker(worker);
	}

	private class RequestHandler implements OnRequestReceivedListener {

		@Override
		public ChatResult onRequestReceived(Worker sender, ChatRequest request) {
			ChatResult responseObject = null;
			switch (request.getCode()) {
			case ChatRequest.CODE_FRIENDS_LIST:
				responseObject = responseFriendsList(sender);
				break;
			case ChatRequest.CODE_MY_ACCOUNT_INFO:
				responseObject = responseAccountInfo(sender);
				break;
			case ChatRequest.CODE_CHAT_MESSAGE:
				responseObject = forwardChatMessage(sender,
						request.getExtra() instanceof ChatMessage ? (ChatMessage) request.getExtra() : null);
				break;
			case ChatRequest.CODE_LOGIN:
				responseObject = responseLoginResult(sender,
						request.getExtra() instanceof Account ? (Account) request.getExtra() : null);
				break;
			case ChatRequest.CODE_CHANGE_DISPNAME:
				responseObject = responseChangeDisplayName(sender.getAccount(),
						request.getExtra() != null ? request.getExtra().toString() : null);
				notifyAllWorker(sender);
				break;
			case ChatRequest.CODE_CHANGE_PASSWORD:
				responseObject = responseChangePassword(sender.getAccount().getAccountId(),
						request.getExtra() != null ? request.getExtra().toString() : null);
				break;
			case ChatRequest.CODE_CHANGE_STATUS:
				responseObject = responseChangeStatus(sender.getAccount(),
						request.getExtra() != null ? request.getExtra().toString() : null);
				notifyAllWorker(sender);
				break;
			case ChatRequest.CODE_REGISTER:
				if (request.getExtra() instanceof RegisterInfo) {
					RegisterInfo registerInfo = (RegisterInfo) request.getExtra();
					responseObject = responseRegister(registerInfo.getUsername(), registerInfo.getPassword(),
							registerInfo.getDisplayName());
				}
				break;
			}
			responseObject.setRequestCode(request.getCode());
			return responseObject;
		}

		private boolean isLogged(AccountInfo accountInfo) {
			if (accountInfo == null)
				return false;
			synchronized (lock) {
				for (Worker worker : workers) {
					AccountInfo existsAccountInfo = worker.getAccount();
					if (existsAccountInfo != null && existsAccountInfo.getAccountId() == accountInfo.getAccountId()) {
						return true;
					}
				}
				return false;
			}
		}

		private ChatResult responseLoginResult(Worker sender, Account account) {
			if (account == null)
				return null;
			AccountInfo accountInfo = AccountManager.getInstance().getAccountInfo(account.getUsername(),
					Security.getPasswordHash(account.getPassword()));
			ChatResult result = new ChatResult();
			boolean logged = isLogged(accountInfo);
			result.setCode(ChatResult.CODE_FAIL);
			if (accountInfo != null) {
				if (logged) {
					result.setExtra("Deja conx");
					Log.i("Deja conx");
				} else {
					if(accountInfo.getIsAdmin()) {
						result.setCode(ChatResult.CODE_ADMIN);
						Log.i("Response login: ADMIN");
					}
					else {
						result.setCode(ChatResult.CODE_OK);
						Log.i("Response login: OK");
					}
					sender.setAccount(accountInfo);
					
				}
			} else {
				result.setExtra("Wrong username or password!");
				Log.i("Erreur Password username");
			}
			return result;
		}

		private ChatResult responseAccountInfo(Worker sender) {
			Log.i("Requet pour  " + sender.getAccount().getAccountId());
			ChatResult result = new ChatResult();
			result.setCode(ChatResult.CODE_OK);
			result.setExtra(sender.getAccount());
			return result;
		}

		private ChatResult responseFriendsList(Worker sender) {
			Log.i("Requet pour tout le monde " + sender.getAccount().getAccountId());
			List<AccountInfo> allFriends = AccountManager.getInstance().getAllAccountInfos();
			int exceptId = sender.getAccount().getAccountId();
			AccountInfo exceptAccount = null;
			for (AccountInfo friend : allFriends) {
				if (friend.getAccountId() == exceptId) {
					exceptAccount = friend;
					continue;
				}
				for (Worker worker : workers) {
					if (worker.getAccount().equals(friend)) {
						friend.setState(AccountInfo.STATE_ONLINE);
					}
				}
			}
			allFriends.remove(exceptAccount);
			ChatResult result = new ChatResult();
			result.setCode(ChatResult.CODE_OK);
			result.setExtra(allFriends);
			return result;
		}

		private ChatResult forwardChatMessage(Worker sender, ChatMessage chatMessage) {
			if (chatMessage == null)
				return null;
			Log.l(String.format("%d > %d: %s", sender.getAccount().getAccountId(), chatMessage.getWhoId(),
					chatMessage.getContent()));

			int whoReceiverId = chatMessage.getWhoId();
			Worker whoReceiver = null;

			chatMessage.setWhoId(sender.getAccount().getAccountId());

			synchronized (lock) {
				for (Worker _receiver : workers) {
					if (_receiver.getAccount().getAccountId() == whoReceiverId) {
						whoReceiver = _receiver;
						break;
					}
				}
			}

			ChatResult result = new ChatResult();
			result.setCode(ChatResult.CODE_FAIL);
			if (whoReceiver != null) {
				try {
					ChatResult forwardResult = new ChatResult();
					forwardResult.setCode(ChatResult.CODE_OK);
					forwardResult.setRequestCode(ChatRequest.CODE_CHAT_MESSAGE);
					forwardResult.setExtra(chatMessage);
					whoReceiver.response(forwardResult);
					result.setCode(ChatResult.CODE_OK);
				} catch (IOException e) {
					// e.printStackTrace();
					result.setExtra("Erreur connx ");
				}
			} else {
				result.setExtra("Client Hore Ligne!");
			}
			return result;
		}

		private ChatResult responseRegister(String username, String password, String dispname) {
			Log.i(String.format("Register: %s", username));
			ChatResult result = new ChatResult();
			result.setCode(ChatResult.CODE_FAIL);
			if (Security.checkValidUsername(username) && Security.checkValidPassword(password)
					&& Security.checkValidDisplayName(dispname)) {
				username = username.trim();
				String passhash = Security.getPasswordHash(password);
				dispname = dispname.trim();
				AccountManager.getInstance().addAccount(username, passhash, dispname);
				result.setCode(ChatResult.CODE_OK);
			}
			return result;
		}

		private ChatResult responseChangeDisplayName(AccountInfo account, String dispname) {
			Log.i(String.format("Changer le nom %d  %s", account.getAccountId(), dispname));
			ChatResult result = new ChatResult();
			result.setCode(ChatResult.CODE_FAIL);
			result.setExtra(account);
			if (Security.checkValidDisplayName(dispname)) {
				dispname = dispname.trim();
				account.setDisplayName(dispname);
				AccountManager.getInstance().changeDisplayName(account.getAccountId(), dispname);
				result.setCode(ChatResult.CODE_OK);
			}
			return result;
		}

		private ChatResult responseChangeStatus(AccountInfo account, String status) {
			Log.i(String.format("Changer le status %d  %s", account.getAccountId(), status));
			ChatResult result = new ChatResult();
			result.setCode(ChatResult.CODE_FAIL);
			result.setExtra(account);
			if (status != null && (status = status.trim()).length() > 0) {
				account.setStatus(status);
				AccountManager.getInstance().changeStatus(account.getAccountId(), status);
				result.setCode(ChatResult.CODE_OK);
			}
			return result;
		}

		private ChatResult responseChangePassword(int id, String password) {
			Log.i(String.format("Changer password %d", id));
			ChatResult result = new ChatResult();
			result.setCode(ChatResult.CODE_FAIL);
			if (Security.checkValidPassword(password)) {
				AccountManager.getInstance().changePasswordHash(id, Security.getPasswordHash(password));
				result.setCode(ChatResult.CODE_OK);
			}
			return result;
		}
	}	
}
