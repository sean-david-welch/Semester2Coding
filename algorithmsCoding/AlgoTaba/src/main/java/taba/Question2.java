package taba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Question2 {
    private static final int NUMBER_OF_DRAWERS = 10; // Constant for the number of drawers
    private static final int RECORDS_PER_DRAWER = 10000; // Constant for records per drawer
    private static final System.Logger logger = System.getLogger(Question2.class.getName());


    public static List<List<Integer>> generateData() {
        Random randomObject = new Random();
        List<List<Integer>> drawers = Collections.synchronizedList(new ArrayList<>(NUMBER_OF_DRAWERS));

        for (int iCount = 0; iCount < NUMBER_OF_DRAWERS; iCount++) {
            // Generates 10,000 random integer numbers between -10,000 and 10,000
            List<Integer> drawer = new ArrayList<>();
            randomObject.ints(RECORDS_PER_DRAWER, -10000, 10000).forEach(drawer::add);
            drawers.add(drawer);
        }
        return drawers;
    }

    public static List<DrawerStatistics> computeStatisticsSync(List<List<Integer>> drawers) {
        List<DrawerStatistics> drawerStatisticsList = new ArrayList<>();

        // Compute statistics for each drawer on the main thread (single-threaded)
        for (int i = 0; i < NUMBER_OF_DRAWERS; i++) {
            DrawerStatistics stats = new DrawerWorker(drawers.get(i)).call(); // Directly call the `call()` method
            System.out.println("Drawer " + (char) ('A' + i) + ": " + stats);
            drawerStatisticsList.add(stats);
        }

        return drawerStatisticsList;
    }

   // Method to compute statistics for each drawer in separate threads
    public static List<DrawerStatistics> computeStatisticsAsync(List<List<Integer>> drawers) {
        List<DrawerStatistics> drawerStatisticsList = new ArrayList<>();

        try (ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_DRAWERS)) {
            // Submit tasks to compute statistics for each drawer
            List<Future<DrawerStatistics>> futures = new ArrayList<>(NUMBER_OF_DRAWERS);
            for (int i = 0; i < NUMBER_OF_DRAWERS; i++) {
                futures.add(executorService.submit(new DrawerWorker(drawers.get(i))));
            }

            // Retrieve the results and add them to the list
            for (int i = 0; i < NUMBER_OF_DRAWERS; i++) {
                try {
                    DrawerStatistics stats = futures.get(i).get();
                    System.out.println("Drawer " + (char) ('A' + i) + ": " + stats);
                    drawerStatisticsList.add(stats);
                } catch (InterruptedException | ExecutionException e) {
                    System.err.println("Error processing drawer " + (char) ('A' + i));
                    logger.log(System.Logger.Level.ERROR, "An error occurred!", e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }

        return drawerStatisticsList;
    }

    public static void presentTotals(List<DrawerStatistics> drawerStatisticsList) {
        int grandTotalSum = 0;
        int grandMax = Integer.MIN_VALUE;
        int grandMin = Integer.MAX_VALUE;
        int totalRecordCount = 0;

        // Compute grand total, max, min
        for (DrawerStatistics stats : drawerStatisticsList) {
            grandTotalSum += stats.sum();
            grandMax = Math.max(grandMax, stats.max());
            grandMin = Math.min(grandMin, stats.min());
            totalRecordCount += RECORDS_PER_DRAWER; // Since each drawer has the same number of records
        }

        double grandAverage = grandTotalSum / (double) totalRecordCount;

        // Present the grand statistics
        System.out.println("\nGrand Statistics:");
        System.out.println("Total Sum: " + grandTotalSum);
        System.out.println("Average: " + grandAverage);
        System.out.println("Max: " + grandMax);
        System.out.println("Min: " + grandMin);
    }


    public static void main(String[] args) {
        // Generate data for 10 drawers
        List<List<Integer>> drawers = generateData();

        // Compute statistics for each drawer
        List<DrawerStatistics> drawerStatisticsList = computeStatisticsAsync(drawers);

        // Compute and present grand statistics
        presentTotals(drawerStatisticsList);
    }
}

