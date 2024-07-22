package questions;

public class LinkedList<T> {

    public Node<T> first;
    public Node<T> last;

    public LinkedList() {}

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

    public double average() {
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
        if (isEmpty()) {
            first = new Node<>(subject, null);
            last = first;
        }

        Node<T> current = new Node<>(subject, null);
        last.next = current;
        last = current;
    }

    public boolean remove(String subjectName) {
        if (isEmpty()) return false;

        Node<T> current = first;
        Node<T> prev = null;

        while (current != null && current.subject.getModule().equalsIgnoreCase(subjectName)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (prev == null) {
            first = first.next;
            if (first == null) last = null;
        } else {
            prev.next = current.next;
            if (current.next == null) {
                last = prev;
            }
        }

        return true;
    }

//    @Override
//    public String toString() {
//        StringBuilder string = new StringBuilder("List: \n");
//        Node<T> current = first;
//
//        if (isEmpty()) {
//            return "The list is Empty";
//        } else {
//            for (int i = 1; i <= size(); i++) {
//                string.append(String.format("%s) %s\n", i, current.toString()));
//                current = current.next;
//            }
//            return string.toString();
//        }
//    }
}
