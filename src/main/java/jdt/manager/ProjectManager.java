package jdt.manager;

import jdt.data.DBConnection;
import jdt.data.Project;
import jdt.data.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectManager {

  private DBConnection DBCon = new DBConnection();

  public boolean CreateProject(String title, String description, User currentUser) {
    boolean success = false;

    try {
      if (DBCon.update(
              "INSERT INTO tblProjects (userID, projectTitle, projectDescription) "
              + "VALUES ("
              + currentUser.getUserID() + ", '"
              + title + "', '"
              + description + "');"
      ) == 1) {
        success = true;
      }
    } catch (SQLException ex) {
      System.out.println("Something Went Wrong!");
      Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
    }

    return success;
  }

  public List<Project> GetUserProjects(User currentUser) {
    List<Project> userProjectList = new ArrayList();

    try (ResultSet rs = DBCon.query("SELECT * FROM tblProjects WHERE userID = " + currentUser.getUserID())) {

      while (rs.next()) {
        Project project = new Project(
                rs.getInt("ProjectID"),
                rs.getInt("userID"),
                rs.getString("projectTitle"),
                rs.getString("projectDescription")
        );
        userProjectList.add(project);
      }
      rs.close();

    } catch (SQLException ex) {
      System.out.println("Something Went Wrong!");
      Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
    }

    return userProjectList;
  }

  public boolean DeleteProject(Project project) {
    boolean success = false;

    try {
      if (DBCon.update(
              "DELETE FROM tblProjects "
              + "WHERE ProjectID = "
              + project.getProjectID()) == 1) {
        success = true;
      }
    } catch (SQLException ex) {
      System.out.println("Something Went Wrong!");
      Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
    }

    return success;
  }
}
