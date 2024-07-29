import org.example.people.People;
import org.example.people.PeopleReader;
import org.example.people.PeopleSorter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeopleSorterTest {
    @Test
    void TestBubbleSort() {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            PeopleSorter peopleSorter = new PeopleSorter(people);

            peopleSorter.BubbleSort();
            AssertArraySorted(people);
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }

    @Test
    void TestQuickSort() {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            PeopleSorter peopleSorter = new PeopleSorter(people);

            peopleSorter.QuickSort(0, people.length - 1);
            AssertArraySorted(people);
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }

    private void AssertArraySorted(People[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            assertTrue(people[i].compareTo(people[i + 1]) <= 0, "Array not sorted at index " + i);
        }
    }
}
