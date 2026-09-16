/**
 * Institution: Bellevue College
 * Course: Fundamentals of Computer Science I
 * Quarter: Spring 2026
 * Student name: Paul Hoang
 * Program description: 
 */

import java.util.*;

public class Average {

    public static void main(String[] args) {

        // Scanner and initialize array
        Scanner console = new Scanner(System.in);

        double[] index = new double[250]; // max 250 numbers
        int count = 0;

        System.out.println("Hello There");
        System.out.println("Enter the number you want calculate");
        System.out.println("Else, enter q to quit");

        // Start the loop until user quits
        while (true) {

            System.out.println("Enter number you want to calculate: ");

            String input = console.nextLine();

            // Exit loop if q is entered
            if (input.equals("q")) {
                break;
            }

            // Convert input from String to double
            double number = Double.parseDouble(input);

            // Store number into array
            index[count] = number;
            count++;

            // Calculate average
            double average = averageCal(index, count);

            System.out.println("The average: " + average);
        }

        console.close();
    }

    /**
     * Computes the average of numbers in array
     * @param num the array of numbers
     * @param count how many numbers were entered
     * @return the average value
     */

    public static double averageCal(double[] num, int count) {

        double sum = 0;

        for (int i = 0; i < count; i++) {
            sum += num[i];
        }

        return sum / count;
    }
}