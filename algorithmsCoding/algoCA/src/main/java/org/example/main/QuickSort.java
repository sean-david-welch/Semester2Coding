package org.example.main;

import org.example.people.People;
import org.example.people.PeopleReader;

import java.io.FileWriter;
import java.util.Comparator;

// Question 3 method implementation and example
/**
 * A generic class for sorting an array using the Quick Sort algorithm.
 *
 * @param <T> The type of objects to be sorted.
 */
public class QuickSort<T> {
    // same as bubble sort - init generic data and comparator properties
    private final T[] data;
    private final Comparator<T> comparator;

    // constructor with generics
    public QuickSort(T[] data, Comparator<T> comparator) {
        this.data = data;
        this.comparator = comparator;
    }

    /**
     * Sorts the array using the Quick Sort algorithm.
     *
     * @param low  The starting index of the portion of the array to be sorted.
     * @param high The ending index of the portion of the array to be sorted.
     * @return The sorted array.
     */
    public T[] quickSort(int low, int high) {
        if (low < high) {
            // init helper method
            int partition = partition(low, high);

            // recursive calls to quicksort
            quickSort(low, partition - 1);
            quickSort(partition + 1, high);
        }

        // return mutated array
        return data;
    }

    // helper method to find partition index based on low and high points
    private int partition(int low, int high) {
        // init pivot for quick sort and initial index
        T pivot = data[high];
        int i = low - 1;

        // loop through and compare age
        for (int j = low; j < high; j++) {
            // if different is lower than pivot, swap elements
            if (comparator.compare(data[j], pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    // helper method to swap indices
    private void swap(int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        try {
            // init reader and read csv into memory
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            // given we have set compareTo method in People class, the natural order of comparator
            // will compare based on our desired column, in this case age, and then next ID.
            Comparator<People> peopleComparator = Comparator
                    .<People>naturalOrder()
                    .thenComparing(People::getID);

            // init quick sort and pass data
            QuickSort<People> qs = new QuickSort<>(people, peopleComparator);
            People[] sortedPeople = qs.quickSort(0, people.length - 1);

            // init File writer and write file to home dir + /bubbleSortedPeople.csv
            String homeDirectory = System.getProperty("user.home");
            try (FileWriter writer = new FileWriter(homeDirectory + "/quickSortedPeople.csv")) {
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
