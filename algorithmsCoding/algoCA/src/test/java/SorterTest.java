import org.example.main.BinarySearch;
import org.example.main.BubbleSort;
import org.example.main.QuickSort;
import org.example.people.People;
import org.example.people.PeopleReader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class SorterTest {

    // Question 2 Implementation using unit test
    @Test
    void TestBubbleSortTime() {
        try {
            // Set up of data and reader
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            // init comporator
            Comparator<People> peopleComparator = Comparator.<People>naturalOrder().thenComparing(People::getID);

            // init sizes array
            int[] sizes = {10, 100, 1000, 5000, 10000};
            // loop through sizes
            for (int size : sizes) {
                // init time variable
                long totalTime = 0;
                for (int i = 0; i < 10; i++) {
                    // copy array with current szr
                    People[] subset = Arrays.copyOf(people, size);

                    // init starttime in milliseconds
                    long startTime = System.currentTimeMillis();
                    BubbleSort<People> bs = new BubbleSort<>(subset, peopleComparator);
                    People[] sortedPeople = bs.bubbleSort();
                    long endTime = System.currentTimeMillis();

                    totalTime += (endTime - startTime);
                    AssertArraySorted(sortedPeople);
                }
                // get average time
                double averageTime = totalTime / 10.0;
                System.out.println("Bubble Sort - Average time for sorting " + size + " records: " + averageTime + " ms");
            }

        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }

    // Unit test for Bubble Sort Algorithm
    @Test
    void TestBubbleSort() {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            Comparator<People> peopleComparator = Comparator.<People>naturalOrder().thenComparing(People::getID);
            BubbleSort<People> bs = new BubbleSort<>(people, peopleComparator);
            People[] sortedPeople = bs.bubbleSort();
            AssertArraySorted(sortedPeople);
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }

    // Unit Test for Quick sort
    @Test
    void TestQuickSort() {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            Comparator<People> peopleComparator = Comparator.<People>naturalOrder().thenComparing(People::getID);
            QuickSort<People> qs = new QuickSort<>(people, peopleComparator);
            People[] sortedPeople = qs.quickSort(0, people.length - 1);
            AssertArraySorted(sortedPeople);
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }

    // Unit Test for Binary Search
    @Test
    void TestBinarySearchString() {
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

    // Unit Test for Binary search for age
    @Test
    void TestBinarySearchInt() {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            BinarySearch<People> bs = new BinarySearch<>(people);

            String columnToSearch = "age";
            // set age and string and parse in switch statement - if scanner was used for user input, then input could be parsed too
            String targetValue = "56";

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

    // Helper Method to check if Array is sorted by age and then also ID
    private void AssertArraySorted(People[] people) {
        for (int i = 0; i < people.length - 1; i++) {

            if (people[i].compareTo(people[i + 1]) <= 0) {
                assertTrue(people[i].compareTo(people[i + 1]) <= 0, "Array not sorted at index " + i);
                if (people[i].compareTo(people[i + 1]) == 0) {
                    assertTrue(people[i].getID() < people[i + 1].getID(), "Array not sorted at index " + i);
                }
            } else {
                int start = Math.max(0, i - 2);
                int end = Math.min(people.length - 1, i + 3);
                System.out.println("Surrounding elements:");
                for (int j = start; j <= end; j++) {
                    System.out.println("Index " + j + ": " + people[j]);
                }
                fail("Array not sorted at index " + i);
            }
        }
    }
}
