package jdt.manager;

import jdt.data.DBConnection;
import jdt.data.Project;
import jdt.data.Task;
import jdt.data.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskManager {

    private DBConnection DBCon = new DBConnection();

    public boolean CreateTask(int projectID, String title, String description) {
        boolean success = false;

        try {
            if (DBCon.update(
                    "INSERT INTO tblTasks (projectID, taskTitle, taskDescription, taskState) "
                    + "VALUES ("
                    + projectID + ", '"
                    + title + "', '"
                    + description
                    + "', 'TODO');"
            ) == 1) {
                success = true;
            }
        } catch (SQLException ex) {
            System.out.println("Something Went Wrong!");
            Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return success;
    }

    public List<Task> GetProjectTask(Project currentProject, String taskState) {
        List<Task> projectTaskList = new ArrayList();

        try (ResultSet rs = DBCon.query("SELECT * FROM tblTasks WHERE projectID = " + currentProject.getProjectID())) {

            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("taskID"),
                        rs.getInt("projectID"),
                        rs.getString("taskTitle"),
                        rs.getString("taskDescription"),
                        rs.getString("taskState")
                );
                projectTaskList.add(task);
            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Something Went Wrong!");
            Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return projectTaskList;
    }
}
