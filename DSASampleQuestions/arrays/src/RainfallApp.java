import java.util.Scanner;

public class RainfallApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] dailyRainfall = new double[4][7];
        double[] weeklyAverage = new double[4];

        System.out.println("Please enter the average rainfall for each day: \n");

        for (int week = 0; week < 4; week++) {
            System.out.println("Week " + (week + 1) + ":");
            double weeklySum = 0;
            for (int day = 0; day < 7; day++) {
                System.out.println("Data" + (day + 1) + ":");
                dailyRainfall[week][day] = scanner.nextDouble();
                weeklySum += dailyRainfall[week][day];
            }
            weeklyAverage[week] = weeklySum / 7;
        }

        System.out.println("The rainfall for each week is: \n");
        for (int week = 0; week < 4; week++) {
            System.out.println("Week:" + (week + 1) + ":" + weeklyAverage[week] + "mm");
        }
        scanner.close();
    }
}
