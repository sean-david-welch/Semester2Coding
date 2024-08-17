package question4;

// BTNode class with generic type T
class BTNode<T> {
    public T data;
    public BTNode<T> left;
    public BTNode<T> right;

    public BTNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

