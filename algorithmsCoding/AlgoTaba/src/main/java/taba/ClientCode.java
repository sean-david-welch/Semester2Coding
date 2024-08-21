package taba;

import java.util.List;

public class ClientCode {
    public static void main(String[] args) {
        // Use this code to generate the data in the List of drawers
        List<List<Integer>> drawers = Taba2024.generateData();

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
