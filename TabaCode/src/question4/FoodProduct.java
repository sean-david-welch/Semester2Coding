package question4;

public class FoodProduct implements Comparable<FoodProduct> {
    public final String name;
    public final double price;
    public final int healthyEatingIndex;

    public FoodProduct(String name, double price, int healthyEatingIndex) {
        this.name = name;
        this.price = price;
        this.healthyEatingIndex = healthyEatingIndex;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getHealthyEatingIndex() {
        return healthyEatingIndex;
    }

    @Override
    public int compareTo(FoodProduct other) {
        return Integer.compare(this.healthyEatingIndex, other.healthyEatingIndex);
    }

    @Override
    public String toString() {
        return String.format("%s (Price: $%.2f, Health Index: %d)", name, price, healthyEatingIndex);
    }
}

