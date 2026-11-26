package j1.s.p0071;

public class Task {

    int id;
    String taskTypeId, requirementName, date, planFrom, planTo, assignee, reviewer;

    public Task() {

    }

    public Task(int id, String taskTypeId, String requirementName, String date, String planFrom, String planTo, String assignee, String reviewer) {
        this.id = id;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    public String getPlanTo() {
        return planTo;
    }

    public void setPlanTo(String planTo) {
        this.planTo = planTo;
    }

    public String getassignee() {
        return assignee;
    }

    public void setassignee(String assignee) {
        this.assignee = assignee;
    }

    public String getreviewer() {
        return reviewer;
    }

    public void setreviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}
