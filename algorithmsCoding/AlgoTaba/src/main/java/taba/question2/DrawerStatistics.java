package taba.question2;

import java.util.List;
import java.util.concurrent.Callable;

public record DrawerStatistics(int sum, double average, int max, int min) {
    @Override
    public String toString() {
        return "Sum: " + sum + ", Average: " + average + ", Max: " + max + ", Min: " + min;
    }
}

class DrawerWorker implements Callable<DrawerStatistics> {
    private final List<Integer> drawerData;

    public DrawerWorker(List<Integer> drawerData) {
        this.drawerData = drawerData;
    }

    @Override
    public DrawerStatistics call() {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : drawerData) {
            sum += num;
            if (num > max) max = num;
            if (num < min) min = num;
        }

        double average = sum / (double) drawerData.size();
        return new DrawerStatistics(sum, average, max, min);
    }
}