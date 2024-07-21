package questions;

public class Subject {

    // properties
    private String module;
    private double grade;

    // constructors
    public Subject() {}

    public Subject(String module) {
        this.module = module;
    }

    public Subject(String module, double grade) {
        this.module = module;
        this.grade = grade;
    }

    // getters
    public String getModule() {
        return this.module;
    }

    public double getGrade() {
        return this.grade;
    }

    // setters
    public void setModule(String module) {
        this.module = module;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    // methods
    @Override
    public String toString() {
        return String.format("Module: {%s -- %s}", module, grade);
    }
}