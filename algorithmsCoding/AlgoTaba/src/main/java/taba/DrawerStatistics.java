package taba;

public class DrawerStatistics {
    private final int sum;
    private final double average;
    private final int max;
    private final int min;

    public DrawerStatistics(int sum, double average, int max, int min) {
        this.sum = sum;
        this.average = average;
        this.max = max;
        this.min = min;
    }

    @Override
    public String toString() {
        return "Sum: " + sum + ", Average: " + average + ", Max: " + max + ", Min: " + min;
    }
}