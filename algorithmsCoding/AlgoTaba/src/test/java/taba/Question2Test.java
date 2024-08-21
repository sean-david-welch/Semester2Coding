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

        // Display time taken for both executions
        System.out.println("\nTime taken by async version: " + asyncDuration + " ns");
        System.out.println("Time taken by synchronous version: " + synchronousDuration + " ns");

        // You can assert that the async results are equal to synchronous results
        assertEquals(synchronousResults.size(), asyncResults.size(), "Both methods should produce same number of results");

        // Compare performance efficiency
        System.out.println("\nEfficiency comparison:");
        System.out.println("Async execution is " + (synchronousDuration / (double) asyncDuration) + " times faster");

        // Optionally, you can fail the test if the async version is slower
        assertTrue(asyncDuration < synchronousDuration, "Async execution should be faster");
    }
}
