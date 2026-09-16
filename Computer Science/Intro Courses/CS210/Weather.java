import java.util.*;
public class Weather {
	
	public static void main(String[] args) {
		//Get the number of days
		Scanner console = new Scanner(System.in);
		System.out.print("How many days' temperatures? ");
		int days = console.nextInt();
		
		// Create array to store temperatures and find average
		int[] temp = new int[days];
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
			System.out.print("Day " + (i + 1) + "'s high temp: ");
			temp[i] = console.nextInt();
			sum = sum + temp[i];
		}
		double average = sum / days; 
		System.out.println("Average temp = " + average);
		
		int count = 0;
		
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] > average) {
			count++;
			}
		} 
		
		System.out.println(count + " days were above average");	
		System.out.println();
		System.out.print();
	}
}
