
package csi.grp6;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.sun.istack.internal.NotNull;

import bean.Account;
import bean.ChatRequest;
import bean.ChatResult;
import bo.ITransmission;
import bo.ObjectAdapter;
import bo.Protocol;
import bo.SocketTransmission;
import utils.Log;
import utils.StreamUtilities;
import utils.Task;

public final class Client {
	private static Client instance = null;
	private ITransmission transmission;
	private ObjectAdapter objectAdapter;
	private Protocol protocol;
	private Account myAccount = new Account();
	private List<OnDataReceivedListener> mOnDataReceivedListeners = new ArrayList<>();
	private OnConnectionHasProblemListener mOnConnectionHasProblemListener = null;
	private boolean pendingStop = false;

	public void addOnDataReceivedListener(OnDataReceivedListener listener) {
		mOnDataReceivedListeners.add(listener);
	}

	public void removeOnDataReceivedListener(OnDataReceivedListener listener) {
		mOnDataReceivedListeners.remove(listener);
	}

	public void setOnConnectionHasProblemListener(OnConnectionHasProblemListener listener) {
		mOnConnectionHasProblemListener = listener;
	}

	public static Client getInstance() {
		return instance;
	}

	public static void createInstance(String serverAddress, int serverPort) throws UnknownHostException, IOException {
		destroyInstance();
		instance = new Client(serverAddress, serverPort);
	}

	public static void destroyInstance() {
		if (instance != null) {
			instance.release();
			instance = null;
		}
	}

	private void release() {
		pendingStop = true;
		StreamUtilities.tryCloseStream(transmission);
	}
	
	public String getRemoteAddress() {
		if (transmission instanceof SocketTransmission)
			return ((SocketTransmission) transmission).getSocket().getRemoteSocketAddress().toString();
		return "somewhere";
	}

	public void startLooper() {
		Task.run(new Runnable() {
			@Override
			public void run() {
				boolean isCorruptData = false;
				do {
					try {
						Log.i("Att de recevoir les donnes...");
						Object receivedObject = protocol.receiveObject();
						Log.i("data Arriver!");
						if (receivedObject instanceof ChatResult) {
							for (int i = 0; i < mOnDataReceivedListeners.size(); i++) {
								OnDataReceivedListener listener = mOnDataReceivedListeners.get(i);
								if (!listener.onDataReceived(Client.this, (ChatResult) receivedObject)) {
									isCorruptData = true;
									break;
								}
							}
						} else {
							isCorruptData = true;
							Log.i("Donnees NULL");
						}
					} catch (IOException e) {
						if (!pendingStop && mOnConnectionHasProblemListener != null)
							mOnConnectionHasProblemListener.onConnectionHasProblem(e.getMessage());
					}
				} while (!isCorruptData && !pendingStop);
				if (isCorruptData)
					fireConnectionHasProblemEvent("Donnees Probleme !");
			}
		});
	}

	private void fireConnectionHasProblemEvent(String message) {
		if (mOnConnectionHasProblemListener != null)
			mOnConnectionHasProblemListener.onConnectionHasProblem(message);
	}

	public void request(ChatRequest request) {
		try {
			protocol.sendObject(request);
		} catch (IOException e) {
			fireConnectionHasProblemEvent(e.getMessage());
		}
	}

	Client(String serverAddress, int serverPort) throws UnknownHostException, IOException {
		Socket socket = new Socket(serverAddress, serverPort);
		transmission = new SocketTransmission(socket);
		objectAdapter = new ObjectAdapter();
		protocol = new Protocol(objectAdapter, transmission);
	}
	
	public int getMyId() {
		return myAccount.getId();
	}
	
	public void setMyId(int id) {
		myAccount.setId(id);
	}
	
	public String getMyUsername() {
		return myAccount.getUsername();
	}

	public void setMyUsername(String myUsername) {
		myAccount.setUsername(myUsername);
	}

	public interface OnDataReceivedListener {
		boolean onDataReceived(Client sender, ChatResult receivedObject);
	}

	public interface OnConnectionHasProblemListener {
		void onConnectionHasProblem(String message);
	}
}
