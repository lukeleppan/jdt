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

/**
 * Manager for subtasks. Linking to the subtask table in the database.
 * 
 * @author Luke Leppan
 */
public class SubtaskManager {

    private final DBConnection dbCon = new DBConnection();

    /**
     * Create a subtask.
     * 
     * @param taskID The task ID.
     * @param title  The subtask title.
     * @return -1 if the subtask was not created, otherwise 1.
     */
    public int createSubtask(int taskID, String title) {
        return dbCon.update("INSERT INTO subtasks (taskID, subtaskTitle, subtaskCompleted) VALUES (?, ?, false);",
                new String[] { String.valueOf(taskID), title });
    }

    /**
     * Get a list of subtasks for a task.
     * 
     * @param currentTask the task to get subtasks for.
     * @return a list of subtasks for the given task.
     */
    public List<Subtask> getTaskSubtasks(Task currentTask) {
        List<Subtask> subtaskList = new ArrayList<>();

        try (ResultSet rs = dbCon.query("SELECT * FROM subtasks WHERE taskID = ?;",
                new String[] { String.valueOf(currentTask.getTaskID()) })) {
            while (rs.next()) {
                Subtask subtask = new Subtask(rs.getInt("subtaskID"), rs.getInt("taskID"), rs.getString("subtaskTitle"),
                        rs.getBoolean("subtaskCompleted"));
                subtaskList.add(subtask);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubtaskManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return subtaskList;
    }
}
