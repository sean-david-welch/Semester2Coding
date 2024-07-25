package question1;

public class Node<T> {
    public Project project;
    public Node<T> next;

    public Node() {
    }

    public Node(Project project) {
        this.project = project;
    }

    public Node(Project project, Node<T> next) {
        this.project = project;
        this.next = next;
    }

    @Override
    public String toString() {
        if (next != null) {
            return "Node{" +
                    "project=" + project +
                    ", next=" + next +
                    '}' + '\n';
        } else {
              return "Node{" + "project=" + project + '}' + '\n';
        }
    }
}
