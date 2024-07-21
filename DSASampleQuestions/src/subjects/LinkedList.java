package subjects;

public class LinkedList<T> {

    // Properties
    Node<T> first;
    Node<T> last;

    // Methods
    public boolean isEmpty() {
        return first == null;
    };

    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            Node<T> current = first;
            int count = 0;

            while (current != null) {
                count ++;
                current = current.next;
            }
            return count;
        }
    };

    public int getAverage() {
        return 0;
    };

    public void add(Subject module) {
        if (isEmpty()) {
            first = new Node<>(module, null);
            last = first;
        } else {
            Node<T> current = new Node<>(module, null);
            last.next = current;
            last = current;
        }
    };

    public String remove(String module) {
        Node<T> current = first;
        int counter = 0;
        boolean found = false;

        while (current.next != null) {
            if (!current.subject.getModule().equalsIgnoreCase(module)) {
                current = current.next;
            } else {
                found = true;
                break;
            }
        }

        if (!found) {
            return "Not Found";
        } else {
            current = first;
            counter = 1;
            if (first.subject.getModule().equalsIgnoreCase(module)) {
                first = first.next;
            } else {
                while (!current.subject.getModule().equalsIgnoreCase(module)) {
                    counter ++;
                    current = current.next;
                }
                if (counter == (size() -1)) {
                    this.last = current;
                    current.next = null;
                } else {
                    current.next = current.next.next;
                }
            }
        }
        return "Removed";
    };

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("List: \n");
        Node<T> current = first;

        if (isEmpty()) {
            return "The list is Empty";
        } else {
            for (int i = 1; i <= size(); i++) {
                string.append(String.format("%s) %s\n", i, current.toString()));
                current = current.next;
            }
            return string.toString();
        }
    }
}
