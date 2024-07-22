package questions;

public class SubjectApp {
    public static void main(String[] args) {
        Subject ds = new Subject("Data Structures", 70.5);
        System.out.println("DS: " + ds);

        Subject caos = new Subject("CAOS", 90.6);
        System.out.println("CAOS: " + caos);
    }
}