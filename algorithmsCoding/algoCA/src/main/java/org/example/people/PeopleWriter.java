package org.example.people;

// Question 5 Method Implementation - See AddPerson class for executable example
public class PeopleWriter {
    private People[] people;

    public PeopleWriter(People[] people) {
        this.people = people;
    }

    public People[] addPerson(People person) {
        PeopleExceptionHandler.validatePerson(person);

        int id = (people.length > 0) ? people[people.length - 1].getID() + 1 : 0;
        person.setID(id);

        People[] newPeople = new People[people.length + 1];
        System.arraycopy(people, 0, newPeople, 0, people.length);

        newPeople[people.length] = person;
        this.people = newPeople;

        return newPeople;
    }

    public People[] getPeople() {
        return people;
    }
}
