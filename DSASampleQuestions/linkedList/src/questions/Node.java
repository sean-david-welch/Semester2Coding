package questions;

public class Node<T> {
    public Subject subject;
    public Node<T> next;

    public Node(){}

    public Node(Subject subject) {
        this.subject = subject;
    }

    public Node(Subject subject, Node<T> next) {
        this.subject = subject;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.format("Node: {Subject: %s", subject);
    }
}