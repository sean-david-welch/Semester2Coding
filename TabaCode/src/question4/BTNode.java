package question4;

// simple node class for binary tree
public class BTNode<T> {
    T data;
    BTNode<T> left, right;

    public BTNode(T data) {
        this.data = data;
        left = right = null;
    }
}
