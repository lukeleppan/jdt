package jdt.data;

public class Project {

  private int ProjectID;
  private int UserID;
  private String ProjectTitle;
  private String ProjectDescription;

  public Project(int ProjectID, int UserID, String ProjectTitle, String ProjectDescription) {
    this.ProjectID = ProjectID;
    this.UserID = UserID;
    this.ProjectTitle = ProjectTitle;
    this.ProjectDescription = ProjectDescription;
  }

  public int getProjectID() {
    return ProjectID;
  }

  public int getUserID() {
    return UserID;
  }

  public String getProjectTitle() {
    return ProjectTitle;
  }

  public String getProjectDescription() {
    return ProjectDescription;
  }

  public void setProjectID(int ProjectID) {
    this.ProjectID = ProjectID;
  }

  public void setUserID(int UserID) {
    this.UserID = UserID;
  }

  public void setProjectTitle(String ProjectTitle) {
    this.ProjectTitle = ProjectTitle;
  }

  public void setProjectDescription(String ProjectDescription) {
    this.ProjectDescription = ProjectDescription;
  }

}
