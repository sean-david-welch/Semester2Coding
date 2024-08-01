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
            Comparator<People> peopleComparator = Comparator
                    .<People>naturalOrder()
                    .thenComparing(People::getID);

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
                double averageTime = totalTime / 10.0;
                System.out.println("Bubble Sort - Average time for sorting " + size + " records: " + averageTime + " ms");
            }

        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }

    @Test
    void TestBubbleSort() {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            Comparator<People> peopleComparator = Comparator
                    .<People>naturalOrder()
                    .thenComparing(People::getID);
            BubbleSort<People> bs = new BubbleSort<>(people, peopleComparator);
            People[] sortedPeople = bs.bubbleSort();
            AssertArraySorted(sortedPeople);
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }

    @Test
    void TestQuickSort() {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            Comparator<People> peopleComparator = Comparator
                    .<People>naturalOrder()
                    .thenComparing(People::getID);
            QuickSort<People> qs = new QuickSort<>(people, peopleComparator);
            People[] sortedPeople = qs.quickSort(0, people.length - 1);
            AssertArraySorted(sortedPeople);
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }

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
