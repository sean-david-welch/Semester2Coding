package org.example.main;

import org.example.people.People;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    private final People[] people;

    public BinarySearch(People[] people) {
        this.people = people;
    }

    public int binarySearch(String column, String target) {
        Comparator<People> comparator = switch (column.toLowerCase()) {
            case "name" -> Comparator.comparing(People::getName);
            case "surname" -> Comparator.comparing(People::getSurname);
            case "job" -> Comparator.comparing(People::getJob);
            case "age" -> Comparator.comparingInt(People::getAge);
            default -> throw new IllegalArgumentException("Invalid column: " + column);
        };

        Arrays.sort(people, comparator);

        int low = 0;
        int high = people.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            People midVal = people[mid];

            int cmp = switch (column.toLowerCase()) {
                case "name" -> midVal.getName().compareTo(target);
                case "surname" -> midVal.getSurname().compareTo(target);
                case "job" -> midVal.getJob().compareTo(target);
                case "age" -> Integer.compare(midVal.getAge(), Integer.parseInt(target));
                default -> throw new IllegalArgumentException("Invalid column: " + column);
            };

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
