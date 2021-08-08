package jdt.data;

public class Subtask {

    private int SubtaskID;
    private int TaskID;
    private String subtaskTitle;
    private boolean subtaskCompleted;

    public Subtask(int SubtaskID, int TaskID, String subtaskTitle, boolean subtaskCompleted) {
        this.SubtaskID = SubtaskID;
        this.TaskID = TaskID;
        this.subtaskTitle = subtaskTitle;
        this.subtaskCompleted = subtaskCompleted;
    }

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
