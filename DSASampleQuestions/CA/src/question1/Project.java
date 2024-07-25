package question1;

public class Project {
    // Properties
    public String projectCode;
    public String managerName;
    public String projectDescription;
    public int projectDuration;
    public String projectStatus;

    // Constructors
    public Project() {
    }

    public Project(String projectCode) {
        this.projectCode = projectCode;
    }

    public Project(String projectCode, String managerName) {
        this.projectCode = projectCode;
        this.managerName = managerName;
    }

    public Project(String projectCode, String managerName, String projectDescription) {
        this.projectCode = projectCode;
        this.managerName = managerName;
        this.projectDescription = projectDescription;
    }

    public Project(String projectCode, String managerName, String projectDescription, int projectDuration) {
        this.projectCode = projectCode;
        this.managerName = managerName;
        this.projectDescription = projectDescription;
        this.projectDuration = projectDuration;
    }

    public Project(String projectCode, String managerName, String projectDescription, int projectDuration, String projectStatus) {
        this.projectCode = projectCode;
        this.managerName = managerName;
        this.projectDescription = projectDescription;
        this.projectDuration = projectDuration;
        this.projectStatus = projectStatus;
    }

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
