package org.example.main;

import org.example.people.People;
import org.example.people.PeopleReader;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;


// Question 4 method implementation and example
public class BinarySearch<T> {
    // generic property
    private final T[] data;

    public BinarySearch(T[] data) {
        this.data = data;
    }

    public <U extends Comparable<U>> int binarySearch(Function<T, U> func, U target) {
        Comparator<T> comparator = Comparator.comparing(func);
        Arrays.sort(data, comparator);

        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            T midVal = data[mid];
            int cmp = func.apply(midVal).compareTo(target);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Scanner could be used to take user input of course
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();


            BinarySearch<People> bs = new BinarySearch<>(people);

            String columnToSearch = "name";
            String targetValue = "Joe";

            int result = switch (columnToSearch.toLowerCase()) {
                case "name" -> bs.binarySearch(People::getName, targetValue);
                case "surname" -> bs.binarySearch(People::getSurname, targetValue);
                case "job" -> bs.binarySearch(People::getJob, targetValue);
                case "age" -> bs.binarySearch(People::getAge, Integer.parseInt(targetValue));
                default -> throw new IllegalArgumentException("Invalid column: " + columnToSearch);
            };

            if (result != -1) {
                System.out.println(targetValue + " was found in the " + columnToSearch + " list");
                System.out.println("Record details: " + people[result]);
            } else {
                System.out.println(targetValue + " was not found in the " + columnToSearch + " list!");
            }
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }
}
