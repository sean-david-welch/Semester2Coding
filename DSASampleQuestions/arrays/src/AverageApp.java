import java.util.Scanner;

public class AverageApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        int sum = 0;

        System.out.println("Please enter 5 integers: \n");

        for (int i = 0; i < nums.length; i++) {
            System.out.printf("Enter number: %s%n", i + 1);
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }

        double average = (double) sum / nums.length;

        System.out.printf("The average is: %s", average);
        scanner.close();
    }
}
