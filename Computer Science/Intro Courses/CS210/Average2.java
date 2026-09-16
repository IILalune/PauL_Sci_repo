/**
 * Institution: Bellevue College
 * Course: Fundamentals of Computer Science I
 * Quarter: Spring 2026
 * Student name: Paul Hoang
 * Program description: This program take number 
 * inputs and calculate the average
 */

import java.util.Scanner;
import java.util.ArrayList;


/** 
* This class take input from user and calculate the average.
* This class also implement a prototype program for a banking future. 
* @author Paul Hoang
*/
public class Average2 {
	public static void main(String[] args) {
		
		//declare 
		java.util.Scanner console = new Scanner(System.in);
		ArrayList<Double> index = new ArrayList<>();
		int count = 0;
		double totAverage = 0.0;
		
		// Hello, welcome, instructions
		System.out.println("----------------------------------------------------------------");
		System.out.println("Welcome and thank you for choosing <|> banking.");
		System.out.println("This program will let you calculate the average of your money");
		System.out.println("with each deposit or withdrawal, to better track your finance!!!");
		System.out.println("Enter the amount of each deposit. type \"q\" to quit!");
		System.out.println("----------------------------------------------------------------");
		
		
		
		
		//Start loop to calculate the average
		while (true) {
			System.out.print("Please enter [< deposit(s) || witdrawal(s) >] amount: $");
			String input = console.nextLine();
			
			//if type q, exit loop/
			if (input.equalsIgnoreCase("q")) {
					break;
			}
			
			//Store double input into Arraylist, print error if input != double			
			try {
				double number = Double.parseDouble(input);
				index.add(number);
				count++;
			
				//Calculate average
				totAverage = calculateAverage(index, count);
				System.out.println("The current average: $" + String.format("%.2f", totAverage));
			
				//print error if not double	
			} catch (NumberFormatException e) {
				System.out.println("Illegal input, please enter a number!");
				}
		}	
		
		
	
		//Print a list of number and the average.
		System.out.println("----------------------------------------------------------------");
		System.out.println("Program excuted!");
		
		for (int i = 1; i <= index.size(); i++) {
			System.out.println("Entry: " + i + "; Amount: $" + String.format("%.2f", index.get(i - 1)));			
		}
		
		System.out.println("The average of " + count + " [< deposit(s) || witdrawal(s) >] is: $" + String.format("%.2f", totAverage));
		
		//If there are no count, print message
		if ((totAverage * count) < 0) {
			System.out.println("Your balance is negative. Please contact to a local");
			System.out.println("<|> bank as soon as possible!");
		}
		if (count == 0) {
			System.out.println("There were no [< deposit(s) || witdrawal(s) >] made. Goodbye!");
		}
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("Thank you for banking at <|> and using our new software.");
		System.out.println("-- Your finance, is in, your hand -- ");
		
		
}
	
	
/**
* Computes the average of numbers in arrayList
* @param num the array of numbers
* @param count how many numbers were entered
* @return the average value
*/
public static double calculateAverage(ArrayList<Double> array, int count) {
	double sum = 0;
	for (int i = 0; i < array.size(); i++) {
		sum += array.get(i);
	}
		return sum / count;
	}

}
