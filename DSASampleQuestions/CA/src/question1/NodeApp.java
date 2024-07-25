package question1;

public class NodeApp {
    public static void main(String[] args) {
        // project instantaition
        Project project1 = new Project("PTDUH1", "Elmer Fud", "Port Tunnel", 1123, "Well off track");
        Project project2 = new Project("PTDUGB2", "Jane Doe", "Airport", 9988, "Steaming Along!");
        Project project3 = new Project("PTDFB3", "Damo Delaney", "Sherrif Street", 6543, "The GOAT of them all");

        // node instantation
        Node<Project> node3 = new Node<>(project3);
        Node<Project> node2 = new Node<>(project2, node3);
        Node<Project> node1 = new Node<>(project1, node2);

        // sout
        System.out.println("Linked List:\n");
        System.out.println(node1);
    }
}
