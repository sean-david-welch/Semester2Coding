package question4;

// BTNode class with generic type T
class BTNode<T> {
    T data;
    BTNode<T> left;
    BTNode<T> right;

    public BTNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

