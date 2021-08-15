package jdt.manager;

import jdt.data.DBConnection;
import jdt.data.User;
import jdt.data.UserCreds;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserManager {

	private final DBConnection dbCon = new DBConnection();

	public boolean checkForUser(String username) {
		boolean exists = false;

		try (ResultSet rs = dbCon.query("SELECT * FROM usercreds;", new String[]{})) {

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

	public boolean registerUser(User user, UserCreds userCreds) {
		boolean success = false;
		int userID = 0;

		PasswordAuth pwAuth = new PasswordAuth();

		dbCon.update("INSERT INTO usercreds (username, password) VALUES (?, ?);",
				new Object[]{userCreds.getUsername(), pwAuth.hash(userCreds.getPassword().toCharArray())});

		List<UserCreds> userCredsShareableList = new ArrayList<>();

		try (ResultSet rs = dbCon.query("SELECT * FROM usercreds;", new String[]{})) {
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

		int res = dbCon.update("INSERT INTO users VALUES (?, ?, ?, ?, ?);", new Object[]{userID,
			user.getUserEmail(), user.getUserDOB(), user.getUserFirstName(), user.getUserSurname()});

		if (res != -1) {
			success = true;
		}

		return success;
	}

	public boolean loginUser(String username, String password) {
		boolean success = false;
		PasswordAuth pwAuth = new PasswordAuth();

		List<UserCreds> userCredsShareableList = new ArrayList<>();
		try (ResultSet rs = dbCon.query("SELECT * FROM usercreds;", new Object[]{})) {
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

	public User getUser(String username) {
		User user = null;
		int userID = -1;
		List<UserCreds> userCredsShareableList = new ArrayList<>();
		try (ResultSet rs = dbCon.query("SELECT * FROM usercreds;", new Object[]{})) {
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
		try (ResultSet rs = dbCon.query("SELECT * FROM users;", new Object[]{})) {
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

	public int deleteAccount(String username) {
		return dbCon.update("DELETE * FROM usercreds WHERE username = ?;", new Object[]{username});
	}
}
