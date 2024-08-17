package question4;

// BinaryTree class implementing BinaryTreeInterface with generic type T
public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTree<T> {
    public BTNode<T> root;
    public int size;

    public BinaryTreeImpl() {
        root = null;
        size = 0;
    }

    // Check if the tree is empty
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    // Add a node to the tree
    @Override
    public void add(T item) {
        root = add(root, item);
        size++;
    }

    // Count the number of nodes in the tree
    @Override
    public int countNodes() {
        return size;
    }

    // Find the best food product (the node with the lowest index)
    @Override
    public T findBest() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMin(root).data;
    }

    // Find the worst food product (the node with the highest index)
    @Override
    public T findWorst() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMax(root).data;
    }

    private BTNode<T> add(BTNode<T> node, T item) {
        if (node == null) {
            return new BTNode<>(item);
        }

        if (item.compareTo(node.data) < 0) {
            node.left = add(node.left, item);
        } else {
            node.right = add(node.right, item);
        }
        return node;
    }

    private BTNode<T> findMin(BTNode<T> node) {
        return node.left == null ? node : findMin(node.left);
    }

    private BTNode<T> findMax(BTNode<T> node) {
        return node.right == null ? node : findMax(node.right);
    }
}

