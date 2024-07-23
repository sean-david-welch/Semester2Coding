public class Node<T> {
    public Subject subject;
    public Node<T> next;
    public Node<T> prev;

    public Node() {};

    public Node(Subject subject) {
        this.subject = subject;
    }

    public Node(Subject subject, Node<T> next, Node<T> prev) {
        this.subject = subject;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return String.format("Node: {Subjetct: %s}", subject);
    }
}
