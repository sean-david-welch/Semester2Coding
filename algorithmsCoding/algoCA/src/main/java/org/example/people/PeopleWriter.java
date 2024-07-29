package org.example.people;

public class PeopleWriter {
    private People[] people;

    public People[] addPerson(People person) {
        int id = (people.length > 0) ? people[people.length - 1].getID() + 1 : 0;
        person.setID(id);

        People[] newPeople = new People[people.length + 1];
        System.arraycopy(people, 0, newPeople, 0, people.length);

        newPeople[people.length] = person;
        this.people = newPeople;

        return people;
    }

    public People[] getPeople() {
        return people;
    }
}
