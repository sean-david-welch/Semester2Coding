package question1;

public class LinkedList<T> {
    // class properties of generic node T
    public Node<T> first;
    public Node<T> last;

    // is empty method
    public boolean isEmpty() {
        // if first node is null then list is empty
        return first == null;
    }

    public String getProject(int projectIndex) {
        // gaurd class
        if (isEmpty()) return "List is empty, no projects";

        // instantiate pointer and index
        Node<T> current = first;
        int currentIndex = 0;

        // loop in increment pointer and index
        while (current != null && currentIndex < projectIndex) {
            current = current.next;
            currentIndex++;
        }

        // if current is null weve gone off the end without finding the project index
        if (current == null) {
            return "Nothing here pal!";
        }

        return current.project.toString();
    }

    // helper method for printing out projects
    public int size() {
        if (isEmpty()) return 0;

        int count = 0;
        Node<T> current = first;

        // increment pointer and count in loop
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // add method - instantiate project and set as last node
    public void add(Project project) {
        if (isEmpty()) {
            first = new Node<>(project, null);
            last = first;
        } else {
            Node<T> current = new Node<>(project, null);
            // correct pointers
            last.next = current;
            last = current;
        }
    }

    // remove method
    public boolean remove(String projectCode) {
        if (isEmpty()) return false;

        // two pointer approach
        Node<T> current = first;
        Node<T> previous = null;

        // while were in bounds and we have not found the project code
        while (current != null && current.project.getProjectCode().equalsIgnoreCase(projectCode)) {
            // increment pointers
            previous = current;
            current = current.next;
        }

        // out of bounds
        if (current == null) return false;


        if (previous != null) {
            // break link between nodes
            previous.next = current.next;
        } else {
            // if here were at size 1 list as the previous is null
            first = current.next;
        }
        return true;
    }

    // trivial
    @Override
    public String toString() {
        if (isEmpty()) return "The List is empty";

        StringBuilder string = new StringBuilder();
        Node<T> current = first;
        // for each index add some nice formatting of the current index and then the current nodes project in string representation
        for (int i = 0; i < size(); i++) {
            string.append(String.format("%s: %s\n", i + 1, current.project.toString()));
            current = current.next;
        }
        return string.toString();
    }
}
