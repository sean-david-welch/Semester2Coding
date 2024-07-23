public class Subject {
    public String name;
    public double grade;

    public Subject() {}

    public Subject(String name) {
        this.name = name;
    }

    public Subject(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("Subject: {name: %s, grade: %s}", name, grade);
    }
}
