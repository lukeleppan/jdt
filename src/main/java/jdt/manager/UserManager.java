package jdt.manager;

import jdt.data.DBConnection;
import jdt.data.User;
import jdt.data.UserCreds;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserManager {

  private DBConnection DBCon = new DBConnection();

  public boolean CheckForUser(String username) {
    boolean exists = false;

    try (ResultSet rs = DBCon.query("SELECT * FROM tblUserCreds");) {
      List<UserCreds> userCredsShareableList = new ArrayList();

      while (rs.next()) {
        UserCreds userCred = new UserCreds(
                rs.getInt("UserCredID"),
                rs.getString("Username"),
                rs.getString("Password")
        );
        userCredsShareableList.add(userCred);
      }
      rs.close();

      for (int i = 0; i < userCredsShareableList.size(); i++) {
        if (userCredsShareableList.get(i).getUsername().equals(username)) {
          exists = true;
        }
      }
    } catch (SQLException ex) {
      System.out.println("Something Went Wrong!");
      Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
    }

    return exists;
  }

  public boolean RegisterUser(User user, UserCreds userCreds) {
    boolean success = false;
    int UserID = 0;
    try {
      DBCon.update(
              "INSERT INTO tblUserCreds (Username, Password) "
              + "VALUES ('" + userCreds.getUsername() + "', '" + userCreds.getPassword() + "');"
      );
    } catch (SQLException ex) {
      Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
    }

    List<UserCreds> userCredsShareableList = new ArrayList();
    try {
      ResultSet rs = DBCon.query("SELECT * FROM tblUserCreds");

      while (rs.next()) {
        UserCreds userCred = new UserCreds(
                rs.getInt("UserCredID"),
                rs.getString("Username"),
                rs.getString("Password")
        );
        userCredsShareableList.add(userCred);
      }

      rs.close();
    } catch (SQLException ex) {
      System.out.println("Something Went Wrong!");
      Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    for (int i = 0; i < userCredsShareableList.size(); i++) {
      if (userCredsShareableList.get(i).getUsername().equals(userCreds.getUsername())) {
        UserID = userCredsShareableList.get(i).getUserCredID();
      }
    }

    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
      String dateStr = simpleDateFormat.format(user.getUserDOB());
      String query = "INSERT INTO tblUsers "
              + "VALUES (" + UserID + ", '"
              + user.getUserEmail()
              + "', #" + dateStr + "#, '"
              + user.getUserFirstName() + "', '"
              + user.getUserSurname() + "');";

      if (DBCon.update(query) == 1) {
        success = true;
      }

    } catch (SQLException ex) {
      System.out.println("Something Went Wrong!");
      Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
    }

    return success;
  }

  public boolean LoginUser(String username, String password) {
    boolean success = false;

    List<UserCreds> userCredsShareableList = new ArrayList();
    try (ResultSet rs = DBCon.query("SELECT * FROM tblUserCreds")) {
      while (rs.next()) {
        UserCreds tempUserCred = new UserCreds(
                rs.getInt("UserCredID"),
                rs.getString("Username"),
                rs.getString("Password")
        );
        userCredsShareableList.add(tempUserCred);
      }
    } catch (SQLException ex) {
      System.out.println("Something Went Wrong!");
      Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
    }

    for (int i = 0; i < userCredsShareableList.size(); i++) {
      if (userCredsShareableList.get(i).getUsername().equals(username) && userCredsShareableList.get(i).getPassword().equals(password)) {
        success = true;
      }
    }

    return success;
  }

  public User getUser(String username) {
    User user = null;
    int UserID = -1;
    List<UserCreds> userCredsShareableList = new ArrayList();
    try (ResultSet rs = DBCon.query("SELECT * FROM tblUserCreds")) {
      while (rs.next()) {
        UserCreds tempUserCred = new UserCreds(
                rs.getInt("UserCredID"),
                rs.getString("Username"),
                rs.getString("Password")
        );
        userCredsShareableList.add(tempUserCred);
      }

      for (int i = 0; i < userCredsShareableList.size(); i++) {
        if (userCredsShareableList.get(i).getUsername().equals(username)) {
          UserID = userCredsShareableList.get(i).getUserCredID();
        }
      }
    } catch (SQLException ex) {
      System.out.println("Something Went Wrong!");
      Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
    }

    List<User> userShareableList = new ArrayList();
    try (ResultSet rs = DBCon.query("SELECT * FROM tblUsers")) {
      while (rs.next()) {
        User tempUser = new User(
                rs.getInt("UserID"),
                rs.getString("email"),
                rs.getDate("DOB"),
                rs.getString("firstname"),
                rs.getString("surname")
        );
        userShareableList.add(tempUser);
      }
    } catch (SQLException ex) {
      System.out.println("Something Went Wrong!");
      Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
    }

    for (int i = 0; i < userShareableList.size(); i++) {
      if (userShareableList.get(i).getUserID() == UserID) {
        user = new User(
                userShareableList.get(i).getUserID(),
                userShareableList.get(i).getUserEmail(),
                userShareableList.get(i).getUserDOB(),
                userShareableList.get(i).getUserFirstName(),
                userShareableList.get(i).getUserSurname()
        );
      }
    }

    return user;
  }

  public boolean deleteAccount(String username) {
    boolean success = true;
    int numCheck = 0;

    try {
      numCheck = DBCon.update("DELETE * FROM tblUserCreds WHERE Username = " + username);
    } catch (SQLException ex) {
      System.out.println("Something Went Wrong!");
      Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
    }

    if (numCheck == 1) {
      success = true;
    }

    return success;
  }

}
