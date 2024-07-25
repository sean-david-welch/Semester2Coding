package question1;

public class Node<T> {
    // Properties
    public Project project;
    public Node<T> next;

    // constructors
    public Node() {
    }

    public Node(Project project) {
        this.project = project;
    }

    public Node(Project project, Node<T> next) {
        this.project = project;
        this.next = next;
    }

    // override method for string representation
    @Override
    public String toString() {
        if (next != null) {
            return "Node{" +
                    "project=" + project +
                    "},\n" + next.toString();
        } else {
            return "Node{" + "project=" + project + "}\n";
        }
    }

}
