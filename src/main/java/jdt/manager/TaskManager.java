package jdt.manager;

import jdt.data.DBConnection;
import jdt.data.Project;
import jdt.data.Task;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manager for tasks. Linking to the tasks table in the database.
 */
public class TaskManager {

	private final DBConnection dbCon = new DBConnection();

	/**
	 * Create a new task.
	 *
	 * @param projectID ID of the project to which the new task will be added.
	 * @param title Title of the task.
	 * @param description Description of the task.
	 *
	 * @return -1 if the task could not be created, otherwise 1.
	 */
	public int createTask(int projectID, String title, String description) {
		return dbCon.update(
				"INSERT INTO tasks (projectID, taskTitle, taskDescription, taskState) VALUES (?, ?, ?, 'TODO');",
				new Object[]{projectID, title, description}
		);
	}

	/**
	 * Get a list of all tasks in a project with a specify state.
	 *
	 * @param currentProject The project for which the tasks should be returned.
	 * @param taskState The state of the tasks.
	 *
	 * @return A list of all tasks in the project.
	 */
	public List<Task> getProjectTask(Project currentProject, String taskState) {
		List<Task> projectTaskList = new ArrayList<>();

		try (ResultSet rs = dbCon.query("SELECT * FROM tasks WHERE projectID = ? AND taskState = ?;",
				new Object[]{currentProject.getProjectID(), taskState})) {
			while (rs.next()) {
				Task task = new Task(rs.getInt("taskID"), rs.getInt("projectID"), rs.getString("taskTitle"),
						rs.getString("taskDescription"), rs.getString("taskState"));
				projectTaskList.add(task);
			}
		} catch (SQLException ex) {
			Logger.getLogger(TaskManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		return projectTaskList;
	}

	public int updateTask(Task updatedTask) {
		return dbCon.update(
				"UPDATE tasks SET taskTitle = ?, taskDescription = ?, taskState = ? WHERE taskID = ?;",
				new Object[]{
					updatedTask.getTaskTitle(),
					updatedTask.getTaskDescription(),
					updatedTask.getTaskState(),
					updatedTask.getTaskID()
				}
		);
	}
}
