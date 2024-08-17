package question3.part1;

public class Stack {

    private final Object[] elements;
    private int top;
    private final int capacity;

    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        elements = new Object[capacity];
        top = -1;
    }

    public void push(Object element) {
        if (top == capacity) {
            throw new IllegalStateException("question3.part1.Stack is full");
        }
        elements[++top] = element;
    }

    public void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("question3.part1.Stack is empty");
        }
        elements[top--] = null;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("question3.part1.Stack is empty");
        }
        return elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
