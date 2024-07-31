package org.example.main;

import org.example.people.People;
import org.example.people.PeopleReader;

import java.util.Arrays;
import java.util.Comparator;

// Question 4 method implementation and example
public class BinarySearch {
    public static void main(String[] args) {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            BinarySearch binarySearch = new BinarySearch(people);

            String columnToSearch = "name";
            String targetValue = "Joe";

            int result = binarySearch.binarySearch(columnToSearch, targetValue);

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
