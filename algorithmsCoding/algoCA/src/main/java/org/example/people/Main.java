package org.example.people;

public class Main {
    public static void main(String[] args) {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            PeopleSorter peopleSorter = new PeopleSorter(people);

            peopleSorter.BubbleSort();
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }
}