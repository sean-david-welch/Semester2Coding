package org.example.people;

// Question 6 class implementation - example is instantiate in People Writer class

/**
 * Custom exception handler for validating People objects.
 * This class extends RuntimeException and provides methods to validate
 * various properties of People objects.
 */
public class PeopleExceptionHandler extends RuntimeException {
    // super method
    public PeopleExceptionHandler(String message) {
        super(message);
    }

    /**
     * Validates all properties of the given People object -- Controller method
     *
     * @param person The People object to validate.
     */
    public static void validatePerson(People person) {
        validateName(person.getName());
        validateSurname(person.getSurname());
        validateJob(person.getJob());
        validateAge(person.getAge());
        validateCredit(person.getCredit());
    }

    // validate name - must be not null, emtpy string or cant be a digit
    private static void validateName(String name) {
        if (name == null || name.trim().isEmpty() || name.matches("\\d+")) {
            throw new PeopleExceptionHandler("Person's name cannot be empty or only have digits!");
        }
    }

    // validate surname - must be not null, emtpy string or cant be a digit
    private static void validateSurname(String surname) {
        if (surname == null || surname.trim().isEmpty() || surname.matches("\\d+")) {
            throw new PeopleExceptionHandler("Person's surname cannot be empty or only have digits!");
        }
    }

    // validate job, can't be null or empty
    private static void validateJob(String job) {
        if (job == null || job.trim().isEmpty()) {
            throw new PeopleExceptionHandler("Person's job cannot be empty. Please provide a valid job title.");
        }
    }

    // validate age must be greater than zero
    private static void validateAge(int age) {
        if (age <= 0) {
            throw new PeopleExceptionHandler("Person's age must be greater than zero. Please provide a valid age.");
        }
    }

    // validate credit must be greater than zero
    private static void validateCredit(long credit) {
        if (credit < 0) {
            throw new PeopleExceptionHandler("Person's credit cannot be negative. Please provide a valid credit value.");
        }
    }
}
