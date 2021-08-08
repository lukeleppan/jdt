package jdt.manager;

import jdt.data.DBConnection;
import jdt.data.Subtask;
import jdt.data.Task;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubtaskManager {

    private DBConnection DBCon = new DBConnection();

    public boolean CreateSubtask(int taskID, String title) {
        boolean success = false;

        try {
            if (DBCon.update(
                    "INSERT INTO tblSubtasks (taskID, subtaskTitle, subtaskCompleted) "
                    + "VALUES ("
                    + taskID + ", '"
                    + title + "', false);"
            ) == 1) {
                success = true;
            }
        } catch (SQLException ex) {
            System.out.println("Something Went Wrong!");
            Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return success;
    }

    public List<Subtask> GetTaskSubtasks(Task currentTask) {
        List<Subtask> projectTaskList = new ArrayList();

        try (ResultSet rs = DBCon.query("SELECT * FROM tblTasks WHERE projectID = " + currentTask.getProjectID())) {

            while (rs.next()) {
                Subtask subtask = new Subtask(
                        rs.getInt("subtaskID"),
                        rs.getInt("taskID"),
                        rs.getString("subtaskTitle"),
                        rs.getBoolean("subtaskCompleted")
                );
                projectTaskList.add(subtask);
            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Something Went Wrong!");
            Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return projectTaskList;
    }
}
