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

    public boolean remove(String projectCode) {
        if (isEmpty()) return false;

        Node<T> current = first;
        Node<T> previous = null;

        while (current != null && current.project.getProjectCode().equalsIgnoreCase(projectCode)) {
            previous = current;
            current = current.next;
        }

        if (current == null) return false;

        if (previous != null) {
            previous.next = current.next;
        } else {
            first = current.next;
        }
        return true;
    }
}
