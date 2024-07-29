package org.example.people;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            PeopleSorter peopleSorter = new PeopleSorter(people);

            People[] sortedPeople = peopleSorter.BubbleSort();
            System.out.println(Arrays.toString(sortedPeople));
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }
}