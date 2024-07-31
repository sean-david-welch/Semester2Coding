package org.example.main;

import java.io.FileWriter;
import java.util.Comparator;

import org.example.people.People;
import org.example.people.PeopleReader;

// Question 1 method implementation and example
public class BubbleSort<T> {
    private final T[] data;
    private final Comparator<? super T> comparator;

    public BubbleSort(T[] data, Comparator<? super T> comparator) {
        this.data = data;
        this.comparator = comparator;
    }

    public T[] bubbleSort() {
        int n = this.data.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                int compareResult = comparator.compare(this.data[j], this.data[j + 1]);
                if (compareResult > 0) {
                    // Swap elements
                    T temp = this.data[j];
                    this.data[j] = this.data[j + 1];
                    this.data[j + 1] = temp;
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
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            Comparator<People> peopleComparator = Comparator
                .<People>naturalOrder()
                .thenComparing(People::getID);

            BubbleSort<People> bs = new BubbleSort<>(people, peopleComparator);
            People[] sortedPeople = bs.bubbleSort();

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
}
