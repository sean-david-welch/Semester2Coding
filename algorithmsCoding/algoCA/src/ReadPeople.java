import java.io.File;
import java.util.*;

public class ReadPeople {

    public static void main(String[] args) throws Exception {
        //parsing and reading the CSV file data into the object array
        File directory = new File("./");
        String name = directory.getAbsolutePath() + "//people.csv";
        People[] people;
        try (Scanner scanner = new Scanner(new File(name))) {
            people = new People[10000];
            // this will just print the header in CSV file
            scanner.nextLine();
            int i = 0;
            String sGetData;
            while (scanner.hasNextLine()) {
                sGetData = scanner.nextLine();
                String[] data = sGetData.split(",");
                people[i++] = new People(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]), Long.parseLong(data[5]));
            }
            //closes the scanner
        }

        // we can print details due to overridden toString method in the class below
        System.out.println(people[0]);
        System.out.println(people[1]);

        // we can compare objects based on their ID due to overridden CompareTo method in the class below
        System.out.println(people[0] == people[0]);
        System.out.println(people[0] == people[1]);
    }

}