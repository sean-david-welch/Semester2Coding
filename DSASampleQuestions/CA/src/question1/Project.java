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

        // override method for string representation
        @Override
        public String toString() {
            return "Project{" +
                    "projectCode='" + projectCode + '\'' +
                    ", managerName='" + managerName + '\'' +
                    ", projectDescription='" + projectDescription + '\'' +
                    ", projectDuration=" + projectDuration +
                    ", projectStatus='" + projectStatus + '\'' +
                    '}' + '\n';
        }
    }
