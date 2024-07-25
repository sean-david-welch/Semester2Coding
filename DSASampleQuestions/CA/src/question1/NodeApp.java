package question1;

public class NodeApp {
    public static void main(String[] args) {
        Project project1 = new Project("PTDUH1", "Elmer Fud", "Port Tunnel", 1123, "Well off track");
        Project project2 = new Project("PTDUGB2", "Jane Doe", "Airport", 9988, "Steaming Along!");
        Project project3 = new Project("PTDFB3", "Damo Delaney", "Sherrif Street", 6543, "The GOAT of them all");
        System.out.println("New Project: " + project3);
    }
}
