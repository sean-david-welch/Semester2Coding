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

    public int size() {
        if (isEmpty()) return 0;

        int count = 0;
        Node<T> current = first;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
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

    @Override
    public String toString() {
        if (isEmpty()) return "The List is empty";

        StringBuilder string = new StringBuilder();
        Node<T> current = first;
        for (int i = 0; i < size(); i++) {
            string.append(String.format("%s: %s\n", i + 1, current.toString()));
            current = current.next;
        }
        return string.toString();
    }
}