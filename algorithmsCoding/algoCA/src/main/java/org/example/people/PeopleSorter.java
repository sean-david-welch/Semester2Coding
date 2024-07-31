package org.example.people;

import java.util.Arrays;
import java.util.Comparator;

public class PeopleSorter {
    private final People[] people;

    public PeopleSorter(People[] people) {
        this.people = people;
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
