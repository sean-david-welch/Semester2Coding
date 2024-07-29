package org.example.people;

public class PeopleExceptionHandler extends RuntimeException {
    public PeopleExceptionHandler(String message) {
        super(message);
    }

    public static void validatePerson(People person) {
        validateName(person.getName());
        validateSurname(person.getSurname());
        validateJob(person.getJob());
        validateAge(person.getAge());
        validateCredit(person.getCredit());
    }

    private static void validateName(String name) {
        if (name == null || name.trim().isEmpty() || name.matches("\\d+")) {
            throw new PeopleExceptionHandler("Person's name cannot be empty. It cannot have only digits! Please correct this!");
        }
    }

    private static void validateSurname(String surname) {
        if (surname == null || surname.trim().isEmpty() || surname.matches("\\d+")) {
            throw new PeopleExceptionHandler("Person's surname cannot be empty. It cannot have only digits! Please correct this!");
        }
    }

    private static void validateJob(String job) {
        if (job == null || job.trim().isEmpty()) {
            throw new PeopleExceptionHandler("Person's job cannot be empty. Please provide a valid job title.");
        }
    }

    private static void validateAge(int age) {
        if (age <= 0) {
            throw new PeopleExceptionHandler("Person's age must be greater than zero. Please provide a valid age.");
        }
    }

    private static void validateCredit(long credit) {
        if (credit < 0) {
            throw new PeopleExceptionHandler("Person's credit cannot be negative. Please provide a valid credit value.");
        }
    }
}
