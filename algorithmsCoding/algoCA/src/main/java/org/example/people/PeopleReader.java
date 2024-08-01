package org.example.people;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Peeople reader utility class to read people into memory from csv
public class PeopleReader {
    // file path property
    private final String filePath;

    // constructor
    public PeopleReader(String filePath) {
        this.filePath = filePath;
    }

    // method to read csv
    public People[] readPeople() {
        // init properties of file path and file name
        File directory = new File(filePath);
        String name = directory.getAbsolutePath();
        // init new array of people of length 10000
        People[] people = new People[10000];

        // use buffer reader instead of scanner as it is more efficient
        try (BufferedReader buffer = new BufferedReader(new FileReader(name))) {
            buffer.readLine(); // Skip csv header

            // init pointerz
            String line;
            int i = 0;

            // while buffer is inbounds
            while ((line = buffer.readLine()) != null && i < people.length) {
                try {
                    // split each data point on comma, given the file is a csv
                    String[] data = line.split(",");
                    // read people into memory
                    people[i++] = new People(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            data[3],
                            Integer.parseInt(data[4]),
                            Long.parseLong(data[5])
                    );
                // catch exceptions
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Error parsing line: " + line);
                    System.err.println("Error details: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }

        // return people array
        return people;
    }
}