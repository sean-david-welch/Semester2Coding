package question1;

public class LinkedListApp {
    public static void main(String[] args) {
        // list instantiation
        LinkedList<Project> projectList = new LinkedList<>();

        // project instatiation
        Project project1 = new Project("PTDUH1", "Elmer Fud", "Port Tunnel", 1123, "Well off track");
        Project project2 = new Project("PTDUGB2", "Jane Doe", "Airport", 9988, "Steaming Along!");
        Project project3 = new Project("PTDFB3", "Damo Delaney", "Sherrif Street", 6543, "The GOAT of them all");
        Project project4 = new Project("PTDFDV4", "Ivor O'Mahoney", "Private School", 7420, "Bosh");
        Project project5 = new Project("PTDJA%", "Damo Delaney", "Sports Centre", 6543, "Run of the mill");

        // check for empty list
        System.out.println("Is the list empty? " + projectList.isEmpty());
        System.out.println("------------------------------------");

        // add projects to list in order
        projectList.add(project1);
        projectList.add(project2);
        projectList.add(project3);
        projectList.add(project4);
        projectList.add(project5);

        // check size and empty
        System.out.println("Number of projects in the list: " + projectList.size());
        System.out.println("------------------------------------");
        System.out.println("Is the list empty now? " + projectList.isEmpty());
        System.out.println("------------------------------------");

        // get project at indeces
        System.out.println("Project at index 2: " + projectList.getProject(2));
        System.out.println("Project at index 6 (out of bounds): " + projectList.getProject(6));
        System.out.println("------------------------------------");

        // all projects
        System.out.println("All projects in the list:");
        System.out.println(projectList);
        System.out.println("------------------------------------");

        // remove nodes
        System.out.println("Removing project with code PTDFB3: " + projectList.remove("PTDUGB2"));
        System.out.println("Removing non-existent project: " + projectList.remove("cantfindthisone"));
        System.out.println("------------------------------------");

        // update projects after removal
        System.out.println("Updated list of projects:");
        System.out.println(projectList);
        System.out.println("------------------------------------");
    }
}
