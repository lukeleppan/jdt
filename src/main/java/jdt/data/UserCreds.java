package jdt.data;

public class UserCreds {

  private int UserCredID;
  private String username;
  private String password;

  public UserCreds(int UserCredID, String username, String password) {
    this.UserCredID = UserCredID;
    this.username = username;
    this.password = password;
  }

  public int getUserCredID() {
    return UserCredID;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

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
