package question4;

public interface BinaryTree<T extends Comparable<T>> {
    boolean isEmpty();               // Check if the tree is empty
    void add(T item);                // Add a node to the tree
    int countNodes();                // Count the number of nodes
    T findBest();                    // Find the best food product (lowest index)
    T findWorst();                   // Find the worst food product (highest index)
}
