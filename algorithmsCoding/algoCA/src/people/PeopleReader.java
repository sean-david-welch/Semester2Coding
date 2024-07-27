package people;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PeopleReader {
    private final String filePath;

    public PeopleReader(String filePath) {
        this.filePath = filePath;
    }

    public People[] readPeople() {
        File directory = new File(filePath);
        String name = directory.getAbsolutePath();
        People[] people = new People[10000];

        try (BufferedReader buffer = new BufferedReader(new FileReader(name))) {
            buffer.readLine(); // Skip csv header

            String line;
            int i = 0;

            while ((line = buffer.readLine()) != null && i < people.length) {
                try {
                    String[] data = line.split(",");
                    people[i++] = new People(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            data[3],
                            Integer.parseInt(data[4]),
                            Long.parseLong(data[5])
                    );
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Error parsing line: " + line);
                    System.err.println("Error details: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }

        return people;
    }
}