package org.example.main;

import org.example.people.People;
import org.example.people.PeopleReader;

import java.io.FileWriter;
import java.util.Comparator;

// Question 3 method implementation and example
public class QuickSort<T> {
    private final T[] data;
    private final Comparator<? super T> comparator;


    public QuickSort(T[] data, Comparator<? super T> comparator) {
        this.data = data;
        this.comparator = comparator;
    }

    public T[] quickSort(int low, int high) {
        if (low < high) {
            int partition = partition(low, high);

            quickSort(low, partition - 1);
            quickSort(partition + 1, high);
        }

        return data;
    }

    private int partition(int low, int high) {
        T pivot = data[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(data[j], pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            Comparator<People> peopleComparator = Comparator
                    .<People>naturalOrder()
                    .thenComparing(People::getID);

            QuickSort<People> qs = new QuickSort<>(people, peopleComparator);

            People[] sortedPeople = qs.quickSort(0, people.length - 1);
            String homeDirectory = System.getProperty("user.home");

            try (FileWriter writer = new FileWriter(homeDirectory + "/quickSortedPeople.csv")) {
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
