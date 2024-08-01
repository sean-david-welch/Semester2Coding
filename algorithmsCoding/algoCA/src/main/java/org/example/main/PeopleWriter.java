package org.example.main;

import org.example.people.People;
import org.example.people.PeopleExceptionHandler;
import org.example.people.PeopleReader;

import java.io.FileWriter;

// Question 5 Example

/**
 * A class for managing and writing people data.
 */
public class PeopleWriter {
    // init people
    private People[] people;

    // constructor
    public PeopleWriter(People[] people) {
        this.people = people;
    }

    /**
     * Adds a new person to the array with the provided details.
     *
     * @param name    The first name of the person.
     * @param surname The surname of the person.
     * @param job     The job title of the person.
     * @param age     The age of the person.
     * @param credit  The credit amount associated with the person.
     * @return The updated array of people including the new person.
     */
    public People[] addPerson(String name, String surname, String job, int age, long credit) {
        // Create a new Person object
        People person = new People();

        // Use setter methods to set all fields
        person.setName(name);
        person.setSurname(surname);
        person.setJob(job);
        person.setAge(age);
        person.setCredit(credit);

        // Example use case of question 6 exception handler - will validate each field in person
        PeopleExceptionHandler.validatePerson(person);

        // Generate a new ID
        int id = (people.length > 0) ? people[people.length - 1].getID() + 1 : 0;
        person.setID(id);

        // Add the new person to the array
        People[] newPeople = new People[people.length + 1];
        System.arraycopy(people, 0, newPeople, 0, people.length);
        newPeople[people.length] = person;
        this.people = newPeople;

        // return copied array with new person at the end with consecutive id
        return newPeople;
    }

    public static void main(String[] args) {
        try {
            // init people reader and read people into memory from csv
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");
            People[] people = peopleReader.readPeople();

            // init people writer clas and add new person with approptiate values
            // user input could be taken from scanner if necessary
            PeopleWriter peopleWriter = new PeopleWriter(people);
            People[] newPeople = peopleWriter.addPerson("Mark", "Grant", "Manager", 33, 472132554L);

            // write file to users home directory with new person
            String homeDirectory = System.getProperty("user.home");
            try (FileWriter writer = new FileWriter(homeDirectory + "/newPeople.csv")) {
                // write header
                writer.write("ID,Name,Surname,Job,Age,Credit\n");

                // loop through new people and write with a line break
                for (People person : newPeople) {
                    writer.write(person.toString() + "\n");
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }
}
