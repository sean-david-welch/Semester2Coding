package question1;

public class Project {
    // Properties
    public String projectCode;
    public String managerName;
    public String projectDescription;
    public int projectDuration;
    public String projectStatus;

    // Getters
    public String getProjectCode() {
        return projectCode;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public int getProjectDuration() {
        return projectDuration;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    // setters
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public void setProjectDuration(int projectDuration) {
        this.projectDuration = projectDuration;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }
}
