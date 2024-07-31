import org.example.main.BubbleSort;
import org.example.main.QuickSort;
import org.example.people.People;
import org.example.people.PeopleReader;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class SorterTest {
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
