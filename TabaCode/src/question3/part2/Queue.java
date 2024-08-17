package question3.part2;

// queue interface
public interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    String toString();
}

