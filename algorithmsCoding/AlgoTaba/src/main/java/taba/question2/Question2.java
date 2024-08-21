package taba.question2;

import java.util.*;
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
            DrawerStatistics stats = new DrawerWorker(drawers.get(i)).call();
            System.out.println("Drawer " + (char) ('A' + i) + ": " + stats);
            drawerStatisticsList.add(stats);
        }

        return drawerStatisticsList;
    }

    public static Map<Integer, DrawerStatistics> computeStatisticsAsync(List<List<Integer>> drawers) {
        // ConcurrentHashMap allows safe concurrent modifications
        Map<Integer, DrawerStatistics> drawerStatsMap = new ConcurrentHashMap<>();

        try (ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_DRAWERS)) {
            // Submit tasks to compute statistics for each drawer
            List<Future<Map.Entry<Integer, DrawerStatistics>>> futures = new ArrayList<>(NUMBER_OF_DRAWERS);
            for (int i = 0; i < NUMBER_OF_DRAWERS; i++) {
                int drawerIndex = i;
                futures.add(executor.submit(() -> {
                    DrawerStatistics stats = new DrawerWorker(drawers.get(drawerIndex)).call();
                    return Map.entry(drawerIndex, stats);  // Return the index and stats as an entry
                }));
            }

            // Retrieve the results and add them to the map
            for (Future<Map.Entry<Integer, DrawerStatistics>> future : futures) {
                try {
                    Map.Entry<Integer, DrawerStatistics> entry = future.get();
                    // Store by drawer index
                    drawerStatsMap.put(entry.getKey(), entry.getValue());
                } catch (InterruptedException | ExecutionException e) {
                    System.err.println("Error processing drawer " + e.getMessage());
                    logger.log(System.Logger.Level.ERROR, "An error occurred!", e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }

        return drawerStatsMap;
    }

    public static void presentTotals(Map<Integer, DrawerStatistics> drawerStatsMap) {
        int totalSum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int totalRecordCount = 0;

        // Compute  total, max, min using values from the Map
        for (DrawerStatistics stats : drawerStatsMap.values()) {
            totalSum += stats.sum();
            max = Math.max(max, stats.max());
            min = Math.min(min, stats.min());
            totalRecordCount += RECORDS_PER_DRAWER;
        }

        double Average = totalSum / (double) totalRecordCount;

        // Present the  statistics
        System.out.println("\nGrand Statistics:");
        System.out.println("Total Sum: " + totalSum);
        System.out.println("Average: " + Average);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    public static void main(String[] args) {
        // Generate data for 10 drawers
        List<List<Integer>> drawers = generateData();

        // Compute statistics for each drawer
        Map<Integer, DrawerStatistics> drawerStats = computeStatisticsAsync(drawers);

        // Compute and present total statistics
        presentTotals(drawerStats);
    }
}

