package org.example.main;

import org.example.people.People;
import org.example.people.PeopleExceptionHandler;
import org.example.people.PeopleReader;

import java.io.FileWriter;

// Question 5 Example
public class PeopleWriter {
    private People[] people;

    public PeopleWriter(People[] people) {
        this.people = people;
    }

    public People[] addPerson(String name, String surname, String job, int age, long credit) {
        // Create a new Person object
        People person = new People();

        // Use setter methods to set all fields
        person.setName(name);
        person.setSurname(surname);
        person.setJob(job);
        person.setAge(age);
        person.setCredit(credit);

        // Example use case of question 6 exception handler
        PeopleExceptionHandler.validatePerson(person);

        // Generate a new ID
        int id = (people.length > 0) ? people[people.length - 1].getID() + 1 : 0;
        person.setID(id);

        // Add the new person to the array
        People[] newPeople = new People[people.length + 1];
        System.arraycopy(people, 0, newPeople, 0, people.length);
        newPeople[people.length] = person;
        this.people = newPeople;

        return newPeople;
    }

    public static void main(String[] args) {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");

            People[] people = peopleReader.readPeople();
            PeopleWriter peopleWriter = new PeopleWriter(people);

            People[] newPeople = peopleWriter.addPerson("Mark", "Grant", "Manager", 33, 472132554L);

            String homeDirectory = System.getProperty("user.home");
            try (FileWriter writer = new FileWriter(homeDirectory + "/newPeople.csv")) {
                writer.write("ID,Name,Surname,Job,Age,Credit\n");

                for (People person : newPeople) {
                    writer.write(person.toString() + "\n");
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to read people: " + e.getMessage());
        }
    }
}
