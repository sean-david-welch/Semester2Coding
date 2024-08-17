package question3.part2;

class Node<T> {
    T data;
    Node<T> next;

    public Node() {}

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
