package taba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    public static void main(String[] args) {
        // Generate data for 10 drawers
        List<List<Integer>> drawers = generateData();


        // Create an ExecutorService to manage 10 threads, use try-with-resources to ensure proper shutdown
        try (ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_DRAWERS)) {
            // Submit tasks to compute statistics for each drawer
            List<Future<DrawerStatistics>> futures = new ArrayList<>(NUMBER_OF_DRAWERS);
            for (int i = 0; i < NUMBER_OF_DRAWERS; i++) {
                futures.add(executorService.submit(new DrawerWorker(drawers.get(i))));
            }

            // Retrieve the results and print them
            for (int i = 0; i < NUMBER_OF_DRAWERS; i++) {
                try {
                    DrawerStatistics stats = futures.get(i).get();
                    System.out.println("Drawer " + (char) ('A' + i) + ": " + stats);
                } catch (InterruptedException | ExecutionException e) {
                    System.err.println("Error processing drawer " + (char) ('A' + i));
                    logger.log(System.Logger.Level.ERROR, "An error occurred!", e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}

