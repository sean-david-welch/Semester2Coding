package org.example.main;

import java.io.FileWriter;
import java.util.Comparator;

import org.example.people.People;
import org.example.people.PeopleReader;

// Question 1 method implementation and example
public class BubbleSort<T> {
    // init generic properties of data and comparator
    private final T[] data;
    private final Comparator<T> comparator;

    // constructor
    public BubbleSort(T[] data, Comparator<T> comparator) {
        this.data = data;
        this.comparator = comparator;
    }

    // bubble sort method
    public T[] bubbleSort() {
        // init length and swapped variables
        int n = this.data.length;
        boolean swapped;

        // outer loop
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // inner loop
            for (int j = 0; j < n - i - 1; j++) {
                // compare indices
                int compareResult = comparator.compare(this.data[j], this.data[j + 1]);
                // if differences is greater than 0, swap elements
                if (compareResult > 0) {
                    // Swap elements
                    T temp = this.data[j];
                    this.data[j] = this.data[j + 1];
                    this.data[j + 1] = temp;
                    // set swapped as true for current index to avoid corruption
                    swapped = true;
                }
            }

            // If no swapping occurred, array is sorted
            if (!swapped) {
                break;
            }
        }
        return data;
    }

    public static void main(String[] args) {
        try {
            // init reader and read people into memory from csv
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            // given we have set compareTo method in People class, the natural order of comparator
            // will compare based on our desired column, in this case age, and then next ID.
            Comparator<People> peopleComparator = Comparator
                .<People>naturalOrder()
                .thenComparing(People::getID);

            // init bubble sort and then sort the people returning new array
            BubbleSort<People> bs = new BubbleSort<>(people, peopleComparator);
            People[] sortedPeople = bs.bubbleSort();

            // get users home directory based on system
            String homeDirectory = System.getProperty("user.home");
            // init File writer and write file to home dir + /bubbleSortedPeople.csv
            try (FileWriter writer = new FileWriter(homeDirectory + "/bubbleSortedPeople.csv")) {
                // write header
                writer.write("ID,Name,Surname,Jon,Age,Credit\n");

                // for each person write it to csv file and add line break
                for (People person : sortedPeople) {
                    writer.write(person.toString() + "\n");
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }
}
