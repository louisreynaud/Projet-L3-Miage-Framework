package bean;

import java.io.Serializable;

public class AccountInfo implements Serializable {
	private static final long serialVersionUID = -4193811689167914857L;
	public static final int STATE_ONLINE = 0;
	public static final int STATE_OFFLINE = 1;
	private int accountId;
	private String displayName;
	private String status;
	private int state;
	private boolean isAdmin;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public static int getStateOnline() {
		return STATE_ONLINE;
	}

	public static int getStateOffline() {
		return STATE_OFFLINE;
	}

	public boolean isOnline() {
		return state == STATE_ONLINE;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof AccountInfo ? ((AccountInfo) obj).getAccountId() == accountId : false;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
