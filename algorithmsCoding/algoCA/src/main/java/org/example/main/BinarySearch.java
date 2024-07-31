package org.example.main;

import org.example.people.People;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {
    private final People[] people;

    public BinarySearch(People[] people) {
        this.people = people;
    }

    public int binarySearch(int targetAge) {
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
