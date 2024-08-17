package question4;

public record FoodProduct(String name, double price, int healthyEatingIndex) implements Comparable<FoodProduct> {

    @Override
    public int compareTo(FoodProduct other) {
        return Integer.compare(this.healthyEatingIndex, other.healthyEatingIndex);
    }

    @Override
    public String toString() {
        return String.format("%s (Price: $%.2f, Health Index: %d)", name, price, healthyEatingIndex);
    }
}

