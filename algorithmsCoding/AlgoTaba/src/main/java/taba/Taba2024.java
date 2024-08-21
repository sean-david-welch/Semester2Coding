package taba;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Taba2024 {
    static List<List<Integer>> drawers = new ArrayList<>(10);

    public static List<List<Integer>> generateData() {
        Random randomObject = new Random();
        for (int iCount = 0; iCount < 10; iCount++) {
            // Generates 10000 random integer numbers between -10,000 and 10,000
            List<Integer> drawer = new ArrayList<>();
            randomObject.ints(10000, -10000, 10000).forEach(drawer::add);
            drawers.add(drawer);
        }
        return drawers;
    }
}
