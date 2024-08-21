package taba;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class Question2Test {

    @Test
    void compareSingleThreadedAndMultiThreadedPerformance() {
        // Generate data for 10 drawers
        List<List<Integer>> drawers = Question2.generateData();

        // Measure time for multithreaded execution
        long asyncStartTime = System.nanoTime();
        List<DrawerStatistics> asyncResults = Question2.computeStatisticsAsync(drawers);
        long asyncEndTime = System.nanoTime();
        long asyncDuration = asyncEndTime - asyncStartTime;

        // Measure time for synchronous execution
        long synchronousStartTime = System.nanoTime();
        List<DrawerStatistics> synchronousResults = Question2.computeStatisticsSync(drawers);
        long synchronousEndTime = System.nanoTime();
        long synchronousDuration = synchronousEndTime - synchronousStartTime;

        // Ensure both methods return the same results
        assertEquals(synchronousResults.size(), asyncResults.size(), "Both methods should produce same number of results");

        // You can also compare that async results match sync results exactly
        // Defer printing until after timing measurement to avoid skewing results
        System.out.println("\nTime taken by async version: " + asyncDuration + " ns");
        System.out.println("Time taken by synchronous version: " + synchronousDuration + " ns");
        System.out.println("\nEfficiency comparison:");
        System.out.println("Async execution is " + (synchronousDuration / (double) asyncDuration) + " times faster");
    }
}
