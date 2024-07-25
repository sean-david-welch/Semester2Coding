package question1;

public class LinkedList<T> {
    public Node<T> first;
    public Node<T> last;

    public boolean isEmpty() {
        return first == null;
    }

    public String getProject(int projectIndex) {
        for (int i = 0; i < projectIndex; i++) {
            System.out.println("hi");
        }
        return "";
    }

    public void add(Project project) {
        if (isEmpty()) {
            first = new Node<>(project, null);
            last = first;
        }

        Node<T> current = new Node<>(project, null);
        last.next = current;
        last = current;
    }
}
