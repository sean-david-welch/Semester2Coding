package org.example.main;

import org.example.people.People;
import org.example.people.PeopleReader;

import java.io.FileWriter;

// Question 3 method implementation and example
public class QuickSort {
    private final People[] people;

    public QuickSort(People[] people) {
        this.people = people;
    }

    public People[] quickSort(int low, int high) {
        if (low < high) {
            int partition = partition(low, high);

            quickSort(low, partition - 1);
            quickSort(partition + 1, high);
        }

        return people;
    }

    private int partition(int low, int high) {
        People pivot = people[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (people[j].compareTo(pivot) <= 0) {
                i++;
                People temp = people[i];
                people[i] = people[j];
                people[j] = temp;
            }
        }

        People temp = people[i + 1];
        people[i + 1] = people[high];
        people[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            QuickSort qs = new QuickSort(people);

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
