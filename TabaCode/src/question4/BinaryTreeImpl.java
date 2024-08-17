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
        root = addRecursive(root, item);
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
        return findMinRecursive(root).data;
    }

    // Find the worst food product (the node with the highest index)
    @Override
    public T findWorst() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMaxRecursive(root).data;
    }

    private BTNode<T> findMaxRecursive(BTNode<T> node) {
        return node.right == null ? node : findMaxRecursive(node.right);
    }

    // Utility Methods
    public void inOrderTraversal(BTNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    private BTNode<T> addRecursive(BTNode<T> node, T item) {
        if (node == null) {
            return new BTNode<>(item);
        }

        if (item.compareTo(node.data) < 0) {
            node.left = addRecursive(node.left, item);
        } else {
            node.right = addRecursive(node.right, item);
        }
        return node;
    }

    private BTNode<T> findMinRecursive(BTNode<T> node) {
        return node.left == null ? node : findMinRecursive(node.left);
    }
}

