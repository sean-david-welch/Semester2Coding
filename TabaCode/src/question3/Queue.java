package question3;

public interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    String toString();
}

