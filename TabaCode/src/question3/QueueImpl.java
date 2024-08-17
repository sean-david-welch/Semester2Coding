package question3;

public class QueueImpl<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public QueueImpl() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    @Override
    public T peek() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node<T> current = front;
        while (current != null) {
            string.append(current.data).append(" -> ");
            current = current.next;
        }
        return !string.isEmpty() ? string.substring(0, string.length() - 4) : "Empty Queue";
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        QueueImpl<String> tagQueue = new QueueImpl<>();

        tagQueue.enqueue("\\begin");
        tagQueue.enqueue("\\end");
        tagQueue.enqueue("\\begin");
        tagQueue.enqueue("\\end");

        System.out.println("Queue: " + tagQueue);

        System.out.println("Peek: " + tagQueue.peek());

        System.out.println("Dequeued: " + tagQueue.dequeue());
        System.out.println("Dequeued: " + tagQueue.dequeue());

        System.out.println("Queue: " + tagQueue);

        System.out.println("Queue size: " + tagQueue.size());
    }
}
