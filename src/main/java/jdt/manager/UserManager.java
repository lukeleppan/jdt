package jdt.manager;

import jdt.data.DBConnection;
import jdt.data.User;
import jdt.data.UserCreds;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manager for users table in the database.
 *
 * @author Luke Leppan
 */
public class UserManager {

	private final DBConnection DB_CON = new DBConnection();

	/**
	 * Checks for a user with a given username.
	 *
	 * @param username The username to check for.
	 *
	 * @return true if user exists, otherwise false.
	 */
	public boolean checkForUser(String username) {
		boolean exists = false;

		try (ResultSet rs = DB_CON.query("SELECT * FROM usercreds;", new String[]{})) {

			List<UserCreds> userCredsShareableList = new ArrayList<>();

			while (rs.next()) {
				UserCreds userCred = new UserCreds(rs.getInt("userCredID"), rs.getString("username"), rs.getString("password"));
				userCredsShareableList.add(userCred);
			}

			for (int i = 0; i < userCredsShareableList.size(); i++) {
				if (userCredsShareableList.get(i).getUsername().equals(username)) {
					exists = true;
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		return exists;
	}

	/**
	 * Registers a user with given User and UserCreds objects.
	 *
	 * @param user the user object to insert into the database.
	 * @param userCreds the usercreds object to insert into the database.
	 *
	 * @return true if the user was registered correctly.
	 */
	public boolean registerUser(User user, UserCreds userCreds) {
		boolean success = false;
		int userID = 0;

		PasswordAuth pwAuth = new PasswordAuth();

		DB_CON.update("INSERT INTO usercreds (username, password) VALUES (?, ?);",
				new Object[]{userCreds.getUsername(), pwAuth.hash(userCreds.getPassword().toCharArray())});

		List<UserCreds> userCredsShareableList = new ArrayList<>();

		try (ResultSet rs = DB_CON.query("SELECT * FROM usercreds;", new String[]{})) {
			while (rs.next()) {
				UserCreds userCred = new UserCreds(rs.getInt("userCredID"), rs.getString("username"), rs.getString("password"));
				userCredsShareableList.add(userCred);
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		for (int i = 0; i < userCredsShareableList.size(); i++) {
			if (userCredsShareableList.get(i).getUsername().equals(userCreds.getUsername())) {
				userID = userCredsShareableList.get(i).getUserCredID();
			}
		}

		int res = DB_CON.update("INSERT INTO users VALUES (?, ?, ?, ?, ?);", new Object[]{userID,
			user.getUserEmail(), user.getUserDOB(), user.getUserFirstName(), user.getUserSurname()});

		if (res != -1) {
			success = true;
		}

		return success;
	}

	/**
	 * Logs a user in given the correct username and password.
	 *
	 * @param username The username of the user to login
	 * @param password The password of the user to login
	 *
	 * @return true if the user is authenticated successfully, otherwise false.
	 */
	public boolean loginUser(String username, String password) {
		boolean success = false;
		PasswordAuth pwAuth = new PasswordAuth();

		List<UserCreds> userCredsShareableList = new ArrayList<>();
		try (ResultSet rs = DB_CON.query("SELECT * FROM usercreds;", new Object[]{})) {
			while (rs.next()) {
				UserCreds tempUserCred = new UserCreds(rs.getInt("userCredID"), rs.getString("username"),
						rs.getString("password"));
				userCredsShareableList.add(tempUserCred);
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		for (int i = 0; i < userCredsShareableList.size(); i++) {
			if (userCredsShareableList.get(i).getUsername().equals(username)
					&& pwAuth.authenticate(password.toCharArray(), userCredsShareableList.get(i).getPassword())) {
				success = true;
			}
		}

		return success;
	}

	/**
	 * Get a User object from a given username.
	 *
	 * @param username the username from which the User object will be gathered.
	 *
	 * @return A user object from the given username.
	 */
	public User getUser(String username) {
		User user = null;
		int userID = -1;
		List<UserCreds> userCredsShareableList = new ArrayList<>();
		try (ResultSet rs = DB_CON.query("SELECT * FROM usercreds;", new Object[]{})) {
			while (rs.next()) {
				UserCreds tempUserCred = new UserCreds(rs.getInt("userCredID"), rs.getString("username"),
						rs.getString("password"));
				userCredsShareableList.add(tempUserCred);
			}

			for (int i = 0; i < userCredsShareableList.size(); i++) {
				if (userCredsShareableList.get(i).getUsername().equals(username)) {
					userID = userCredsShareableList.get(i).getUserCredID();
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		List<User> userShareableList = new ArrayList<>();
		try (ResultSet rs = DB_CON.query("SELECT * FROM users;", new Object[]{})) {
			while (rs.next()) {
				User tempUser = new User(
						rs.getInt("userID"), rs.getString("email"),
						rs.getDate("dob").toLocalDate(),
						rs.getString("firstname"),
						rs.getString("surname")
				);
				userShareableList.add(tempUser);
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		for (int i = 0; i < userShareableList.size(); i++) {
			if (userShareableList.get(i).getUserID() == userID) {
				user = new User(userShareableList.get(i).getUserID(), userShareableList.get(i).getUserEmail(),
						userShareableList.get(i).getUserDOB(), userShareableList.get(i).getUserFirstName(),
						userShareableList.get(i).getUserSurname());
			}
		}

		return user;
	}

	/**
	 * Delete an Account given a username
	 *
	 * @param username The username of user to delete.
	 * @return -1 if failed to delete user.
	 */
	public int deleteAccount(String username) {
		return DB_CON.update("DELETE * FROM usercreds WHERE username = ?;", new Object[]{username});
	}
}
