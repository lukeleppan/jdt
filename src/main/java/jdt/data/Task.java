package jdt.data;

public class Task {

    private int TaskID;
    private int ProjectID;
    private String TaskTitle;
    private String TaskDescription;
    private String TaskState;

    public Task(int TaskID, int ProjectID, String TaskTitle, String TaskDescription, String TaskState) {
        this.TaskID = TaskID;
        this.ProjectID = ProjectID;
        this.TaskTitle = TaskTitle;
        this.TaskDescription = TaskDescription;
        this.TaskState = TaskState;
    }

    public int getTaskID() {
        return TaskID;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public String getTaskTitle() {
        return TaskTitle;
    }

    public String getTaskDescription() {
        return TaskDescription;
    }

    public String getTaskState() {
        return TaskState;
    }

    public void setTaskState(String TaskState) {
        this.TaskState = TaskState;
    }

    public void setTaskID(int TaskID) {
        this.TaskID = TaskID;
    }

    public void setProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }

    public void setTaskTitle(String TaskTitle) {
        this.TaskTitle = TaskTitle;
    }

    public void setTaskDescription(String TaskDescription) {
        this.TaskDescription = TaskDescription;
    }

}
