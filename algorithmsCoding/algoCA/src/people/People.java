package people;

public class People implements Comparable<People> {
    private int ID;
    private String Name;
    private String Surname;
    private String Job;
    private int Age;
    private long Credit;

    // constructor
    public People(int ID, String Name, String Surname, String Job, int Age, long Credit) {
        this.ID = ID;
        this.Name = Name;
        this.Surname = Surname;
        this.Job = Job;
        this.Age = Age;
        this.Credit = Credit;
    }

    @Override
    public int compareTo(People person) {
        return Integer.compare(this.Age, person.Age);
    }

    @Override
    public String toString() {
        return (
        "Person [ID= " + ID + ", Name= " + Name + ", Surname= "
        + Surname + ", Job= " + Job + ", Age= "
        + Age + ", Credit= " + Credit + "]"
        );
    }

    // getters and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        this.Job = job;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public long getCredit() {
        return Credit;
    }

    public void setCredit(long credit) {
        this.Credit = credit;
    }

}
