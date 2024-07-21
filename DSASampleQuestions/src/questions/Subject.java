package questions;

public class Subject {
    // Properties
    private String module;
    private double grade;

    // Constructors
    public Subject() {
    }

    public Subject(String module, double grade) {
        this.module = module;
        this.grade = grade;
    }

    public Subject(String module) {
        this.module = module;
    }

    // Getters
    public String getModule() {
        return module;
    }

    public double getGrade() {
        return grade;
    }

    // Setters
    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setModule(String module) {
        this.module = module;
    }

    // Methods
    @Override
    public String toString() {
        return String.format("Subject {module=%s, grade=%s}", module, grade);
    }
}