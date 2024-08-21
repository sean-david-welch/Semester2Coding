package taba;

import java.util.ArrayList;

/*
 * @author Hamilton1
 */
public class ClientCode {

    public static void main(String[] args) {
        // Use this code to generate the data in the ArrayList of drawers
        ArrayList[] drawers = Taba2024.generateData();

        // To access the individual drawers use the drawers[index]
        // The following code allows you to get the size of each drawer
       
        for (ArrayList drawer : drawers) {
            System.out.println(drawer.size());
        }

        // To access the elements of a drawer use drawers[0][index]
        for (int iCount = 0; iCount < drawers[0].size(); iCount++) {
            //This prints the individual elements of drawer 0
            System.out.println(drawers[0].get(iCount));
        }
    }
}
