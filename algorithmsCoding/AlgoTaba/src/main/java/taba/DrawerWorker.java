package taba;

import java.util.List;
import java.util.concurrent.Callable;

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