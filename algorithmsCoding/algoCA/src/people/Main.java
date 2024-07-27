package people;

public class Main {
    public static void main(String[] args) {
        try {
            PeopleReader peopleReader = new PeopleReader("./resources/people.csv");

            PeopleSorter peopleSorter = new PeopleSorter();
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }
}