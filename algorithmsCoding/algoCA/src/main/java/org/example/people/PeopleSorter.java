package org.example.people;

import java.util.Arrays;
import java.util.Comparator;

public class PeopleSorter {
    private final People[] people;

    public PeopleSorter(People[] people) {
        this.people = people;
    }

    public People[] QuickSort(int low, int high) {
        if (low < high) {
            int partition = partition(low, high);

            QuickSort(low, partition - 1);
            QuickSort(partition + 1, high);
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

    public int BinarySearch(int targetAge) {
        Arrays.sort(people, Comparator.comparingInt(People::getAge));

        int low = 0;
        int high = people.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            People midVal = people[mid];
            int cmp = Integer.compare(midVal.getAge(), targetAge);


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
}
