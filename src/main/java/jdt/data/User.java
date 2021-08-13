package jdt.data;

import java.time.LocalDate;

public class User {

	private int userID;
	private String userEmail;
	private LocalDate userDOB;
	private String userFirstName;
	private String userSurname;

	public User(int userID, String userEmail, LocalDate userDOB, String userFirstName, String userSurname) {
		this.userID = userID;
		this.userEmail = userEmail;
		this.userDOB = userDOB;
		this.userFirstName = userFirstName;
		this.userSurname = userSurname;
	}

	public int getUserID() {
		return userID;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public LocalDate getUserDOB() {
		return userDOB;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserDOB(LocalDate userDOB) {
		this.userDOB = userDOB;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
}
