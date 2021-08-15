package jdt.data;

/**
 * UserCreds object to store UserCreds data.
 *
 * @author Luke Leppan
 */
public class UserCreds {

	private int UserCredID;
	private String username;
	private String password;

	/**
	 * Create UserCreds
	 *
	 * @param UserCredID
	 * @param username
	 * @param password
	 */
	public UserCreds(int UserCredID, String username, String password) {
		this.UserCredID = UserCredID;
		this.username = username;
		this.password = password;
	}

	// Getters
	public int getUserCredID() {
		return UserCredID;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	// Setters
	public void setUserCredID(int UserCredID) {
		this.UserCredID = UserCredID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
