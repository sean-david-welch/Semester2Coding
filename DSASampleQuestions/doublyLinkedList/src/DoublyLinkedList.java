public class DoublyLinkedList<T> {
    public Node<T> first;
    public Node<T> last;

    public DoublyLinkedList() {};

    public boolean isEmpty() {
        return first == null;
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

    public double getAverage() {
        if (isEmpty()) return 0;

        int count = 0;
        double sum = 0;
        Node<T> current = first;

        while (current != null) {
            count++;
            sum += current.subject.getGrade();
            current = current.next;
        }

        return count == 0 ? 0 : sum / count;
    }

    public void add(Subject subject) {
        Node<T> current = new Node<>(subject);
        if (isEmpty()) {
            first = current;
            last = first;
        }

        last.next = current;
        current.prev = last;
        last = current;
    }

    public boolean remove(String subject) {
        if (isEmpty()) return false;

        Node<T> current = first;
        while (current != null && !(current.subject.getName().equalsIgnoreCase(subject))) {
            current = current.next;
        }

        if (current == null) return false;

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            first = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            last = current.prev;
        }

        return true;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Empty";

        Node<T> current = first;
        StringBuilder string = new StringBuilder("List: \n");
        for (int i = 1; i <= size(); i++) {
            current = current.next;
            string.append(String.format("%s -- %s", i , current.toString()));
        }

        return string.toString();
    }
}
