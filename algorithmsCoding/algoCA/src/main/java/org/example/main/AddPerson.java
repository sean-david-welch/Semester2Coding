package org.example.main;

import org.example.people.People;
import org.example.people.PeopleReader;
import org.example.people.PeopleWriter;

import java.io.FileWriter;

// Question 5 Example
public class AddPerson {
    public static void main(String[] args) {
        try {
            PeopleReader peopleReader = new PeopleReader("resources/people.csv");

            People[] people = peopleReader.readPeople();
            PeopleWriter peopleWriter = new PeopleWriter(people);

            People newPerson = new People(1001, "Mark", "Grant", "Manager", 33, 472132554);
            People[] newPeople = peopleWriter.addPerson(newPerson);

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
