package question3.part2;

public interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    String toString();
}

