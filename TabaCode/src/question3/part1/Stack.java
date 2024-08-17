package question3.part1;

public class Stack {

    // init properties
    private final Object[] elements;
    private int top;
    private final int capacity;

    // init stack
    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        elements = new Object[capacity];
        top = -1;
    }

    // push element
    public void push(Object element) {
        if (top == capacity) {
            throw new IllegalStateException("Stack is full");
        }
        elements[++top] = element;
    }

    // pop element
    public void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("question3.part1.Stack is empty");
        }
        elements[top--] = null;
    }

    // peek at top
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("question3.part1.Stack is empty");
        }
        return elements[top];
    }

    // empty
    public boolean isEmpty() {
        return top == -1;
    }

    // size
    public int size() {
        return top + 1;
    }
}
