package question4;

// Test class for BinaryTree and FoodProduct
public class Main {
    public static void main(String[] args) {
        // Create a binary tree to hold FoodProduct objects
        BinaryTree<FoodProduct> foodTree = new BinaryTreeImpl<>();

        // Add ten food product objects to the tree
        foodTree.add(new FoodProduct("Apple", 0.99, 1));
        foodTree.add(new FoodProduct("Broccoli", 1.50, 0));
        foodTree.add(new FoodProduct("Burger", 5.99, 9));
        foodTree.add(new FoodProduct("Pizza", 8.99, 8));
        foodTree.add(new FoodProduct("Salmon", 10.99, 2));
        foodTree.add(new FoodProduct("Fries", 2.99, 7));
        foodTree.add(new FoodProduct("Chicken", 7.99, 3));
        foodTree.add(new FoodProduct("Soda", 1.99, 10));
        foodTree.add(new FoodProduct("Pasta", 3.99, 6));
        foodTree.add(new FoodProduct("Yogurt", 1.49, 4));

        // Find the best and worst food products
        System.out.println("Best food product: " + foodTree.findBest());
        System.out.println("Worst food product: " + foodTree.findWorst());

        // Count the number of nodes
        System.out.println("Total number of food products: " + foodTree.countNodes());
    }
}

