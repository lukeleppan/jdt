package jdt.data;

/**
 * Subtask object to store subtask data.
 *
 * @author Luke Leppan
 */
public class Subtask {

	private int SubtaskID;
	private int TaskID;
	private String subtaskTitle;
	private boolean subtaskCompleted;

	/**
	 * Create Subtask
	 *
	 * @param SubtaskID
	 * @param TaskID
	 * @param subtaskTitle
	 * @param subtaskCompleted
	 */
	public Subtask(int SubtaskID, int TaskID, String subtaskTitle, boolean subtaskCompleted) {
		this.SubtaskID = SubtaskID;
		this.TaskID = TaskID;
		this.subtaskTitle = subtaskTitle;
		this.subtaskCompleted = subtaskCompleted;
	}

	// Getters
	public int getSubtaskID() {
		return SubtaskID;
	}

	public int getTaskID() {
		return TaskID;
	}

	public String getSubtaskTitle() {
		return subtaskTitle;
	}

	public boolean isSubtaskCompleted() {
		return subtaskCompleted;
	}

	// Setters
	public void setSubtaskID(int SubtaskID) {
		this.SubtaskID = SubtaskID;
	}

	public void setTaskID(int TaskID) {
		this.TaskID = TaskID;
	}

	public void setSubtaskTitle(String subtaskTitle) {
		this.subtaskTitle = subtaskTitle;
	}

	public void setSubtaskCompleted(boolean subtaskCompleted) {
		this.subtaskCompleted = subtaskCompleted;
	}

}
