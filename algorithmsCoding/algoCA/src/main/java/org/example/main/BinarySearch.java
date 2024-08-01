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

    // constructor with generic
    public BinarySearch(T[] data) {
        this.data = data;
    }

    // binary search method
    // generic type U extends the comparable key which is taken from the data
    // we pass a generic callback function with T, U in order to implement our comparison on people
    // the target is of type U
    public <U extends Comparable<U>> int binarySearch(Function<T, U> func, U target) {
        // init comparator with callback function and sort array based on comparator
        Comparator<T> comparator = Comparator.comparing(func);
        Arrays.sort(data, comparator);

        // init low and high indices as start and end of array - two pointer approach
        int low = 0;
        int high = data.length - 1;

        // loop through until pointers meet
        while (low <= high) {
            // get mid point
            int mid = (low + high) / 2;
            // extract generic data from the index of midpoint
            T midVal = data[mid];
            // apply comparison of midval to target through callback function
            int cmp = func.apply(midVal).compareTo(target);

            // if difference less than 0 were too low
            if (cmp < 0) {
                low = mid + 1;
            // if greater than zero were too high
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
            // goldilocks zone were just right
                return mid;
            }
        }
        // target not found
        return -1;
    }

    public static void main(String[] args) {
        // Scanner could be used to take user input of course
        try {
            // init people reader and read people from csv into memory
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            // init binary search
            BinarySearch<People> bs = new BinarySearch<>(people);

            // select column and target, could we taken from user input if using scanner
            // if using age, pass age as a string and it will be parsed to an integer in switch statement
            String columnToSearch = "name";
            String targetValue = "Joe";

            // switch statement for columns 2 - 4 of people
            int result = switch (columnToSearch.toLowerCase()) {
                case "name" -> bs.binarySearch(People::getName, targetValue);
                case "surname" -> bs.binarySearch(People::getSurname, targetValue);
                case "job" -> bs.binarySearch(People::getJob, targetValue);
                case "age" -> bs.binarySearch(People::getAge, Integer.parseInt(targetValue));
                default -> throw new IllegalArgumentException("Invalid column: " + columnToSearch);
            };

            // if result found communicate to usrr else let them know its not found
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
