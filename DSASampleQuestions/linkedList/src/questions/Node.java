package questions;

public class Node<T> {

    // Properties
    public Subject subject;
    public Node<T> next;


    // Constructors
    public Node() {}

    public Node(Subject subject) {
        this.subject = subject;
    }

    public Node(Subject subject, Node<T> next) {
        this.subject = subject;
        this.next = next;
    }

    // methods
    @Override
    public String toString() {
        return String.format("Node: {Subject: %s}", subject);
    }
}
