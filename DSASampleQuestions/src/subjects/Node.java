package subjects;

public class Node<T> {

    Subject subject;
    Node<T> next;

    public Node() {};

    public Node(Subject subject, Node<T> next) {
        this.subject = subject;
        this.next = next;
    }

    public Node(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return String.format("Node {subject=%s, next=%s}", subject, next);
    }
}
