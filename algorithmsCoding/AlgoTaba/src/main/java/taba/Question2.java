package taba;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Question2 {
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

    public static void main(String[] args) {
        // Use this code to generate the data in the List of drawers
        List<List<Integer>> drawers = generateData();

        // To access the individual drawers use the drawers.get(index)
        // The following code allows you to get the size of each drawer
        for (List<Integer> drawer : drawers) {
            System.out.println(drawer.size());
        }

        // To access the elements of a drawer use drawers.get(0).get(index)
        for (int iCount = 0; iCount < drawers.getFirst().size(); iCount++) {
            // This prints the individual elements of drawer 0
            System.out.println(drawers.getFirst().get(iCount));
        }
    }
}
