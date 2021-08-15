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

/**
 * Manager for projects. Linking to the projects table in the database.
 */
public class ProjectManager {

	private final DBConnection dbCon = new DBConnection();

	/**
	 * Create a new project.
	 *
	 * @param title Title of the project.
	 * @param description Description of the project.
	 * @param currentUser current user.
	 *
	 * @return -1 if the subtask was not created, otherwise 1.
	 */
	public int createProject(String title, String description, User currentUser) {
		return dbCon.update(
				"INSERT INTO projects (userID, projectTitle, projectDescription) VALUES (?, ?, ?);",
				new Object[]{
					currentUser.getUserID(),
					title,
					description
				}
		);
	}

	/**
	 * Get a list of all projects for a user.
	 *
	 * @param currentUser current user.
	 * @param search searchTerm
	 * @param orderBy field to order by.
	 * @param orderByDirection direction.
	 *
	 * @return a list of all projects for a user.
	 */
	public List<Project> getUserProjects(User currentUser, String search, String orderBy, boolean orderByDirection) {
		List<Project> userProjectList = new ArrayList<>();

		try (ResultSet rs = dbCon.query(
				"SELECT * FROM projects WHERE userID = ? AND projectTitle LIKE '" + search + "' ORDER BY " + orderBy + " " + (orderByDirection ? "ASC" : "DESC") + ";",
				new Object[]{
					currentUser.getUserID()
				}
		)) {
			while (rs.next()) {
				Project project = new Project(rs.getInt("projectID"), rs.getInt("userID"), rs.getString("projectTitle"),
						rs.getString("projectDescription"));
				userProjectList.add(project);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		return userProjectList;
	}

	/**
	 * Update a project
	 *
	 * @param project The new project option
	 * @return -1 if project not updated.
	 */
	public int updateProject(Project project) {
		return dbCon.update(
				"UPDATE projects SET projectTitle = ?, projectDescription = ? WHERE projectID = ?;",
				new Object[]{
					project.getProjectTitle(),
					project.getProjectDescription(),
					project.getProjectID()
				}
		);
	}

	/**
	 * Delete a project.
	 *
	 * @param project Project to delete.
	 *
	 * @return -1 if the project was not deleted.
	 */
	public int deleteProject(Project project) {
		return dbCon.update(
				"DELETE FROM projects WHERE projectID = ?;",
				new Object[]{
					project.getProjectID()
				}
		);
	}
}
