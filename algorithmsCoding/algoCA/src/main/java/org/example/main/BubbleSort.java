package org.example.main;
import java.io.FileWriter;


import org.example.people.People;
import org.example.people.PeopleReader;

// Question 1 method implementation and example
public class BubbleSort {
    public static void main(String[] args) {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            BubbleSort bubbleSort = new BubbleSort(people);

            People[] sortedPeople = bubbleSort.bubbleSort();
            String homeDirectory = System.getProperty("user.home");

            try (FileWriter writer = new FileWriter(homeDirectory + "/bubbleSortedPeople.csv")) {
                writer.write("ID,Name,Surname,Jon,Age,Credit\n");

                for (People person : sortedPeople) {
                    writer.write(person.toString() + "\n");
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }

    private final People[] people;

    public BubbleSort(People[] people) {
        this.people = people;
    }

    public People[] bubbleSort() {
        int n = this.people.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                int compareResult = this.people[j].compareTo(this.people[j + 1]);
                boolean needsSwap = compareResult > 0 ||
                        (compareResult == 0 && this.people[j].getID() > this.people[j + 1].getID());

                if (needsSwap) {
                    // Swap elements
                    People temp = this.people[j];
                    this.people[j] = this.people[j + 1];
                    this.people[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swapping occurred, array is sorted
            if (!swapped) {
                break;
            }
        }

        return people;
    }
}
