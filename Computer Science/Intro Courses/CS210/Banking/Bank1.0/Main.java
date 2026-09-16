/**
 * Institution: Bellevue College
 * Course: Fundamentals of Computer Science I
 * Quarter: Spring 2026
 * Student name: Paul Hoang
 * Program description: Banking
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//string, scanner and Bank
		Scanner console = new Scanner(System.in);
		Bank bank = new Bank();
				
		// Looping options
		// Set true to enter loop, if option 6 (quit), return false to exit
		boolean answer = true; 
		while (answer) {
		
		//9
			//Intro Options
			System.out.println("------------------------------------------");
			System.out.println("Hello, Welcome to <|> Banking! ");
			System.out.println("Please type option 1 to 6 to proceed: ");
			System.out.println("1. Create Account ");
			System.out.println("2. List Accounts ");
			System.out.println("3. Deposit ");
			System.out.println("4. Withdraw ");
			System.out.println("5. Get Balance ");
			System.out.println("6. Quit");	
			System.out.println("------------------------------------------");
			System.out.println();
			
			//Get input
			System.out.print("Your answer (in number) : ");
			int input = console.nextInt();
			console.nextLine();
			
			// Create account 1
			if (input == 1) {
				System.out.println("You had choosen option 1, Creating new account.");
				//store Name and address
				System.out.print("Please enter your First Name: ");
				String first = console.nextLine();
				
				System.out.print("Please enter your Last Name: ");
				String last = console.nextLine();
				System.out.print("Please enter your address: ");
				
				String address = console.nextLine();
				bank.openAccount(first, last, address);
				System.out.println();
				System.out.println("Hello " + first + ", Welcome to <|> banking, thank you for choosing us!");	
			}
			
			//List Account 2
			if (input == 2) { 
				System.out.println("You had choosen option 2, here is the list of accounts.");
				bank.listAccount();
				
				System.out.println("Press Enter to continue...");
			    console.nextLine();
			}
			
			//Make deposit 3
			if (input == 3) {
				System.out.println("You had choosen option 3, deposit money. ");
				System.out.print("Please enter your First Name: ");
				String first = console.nextLine();
				
				System.out.print("Please enter your Last Name: ");
				String last = console.nextLine();
				
				System.out.print("Please enter deposit amount: ");
				double amount = console.nextDouble();
				console.nextLine();
				
				if (bank.depositMoney(first, last, amount)) {
					System.out.println("Information correct, Deposit Successful!");
					System.out.println("Thank you for banking with us at <|>");
					} else {
						System.out.println("Verify failed, Incorrect information");
					
					}	
			}
			//Make withdrawal 4 
			if (input == 4) {
				System.out.println("You had choosen option 4, withdrawal money.");
				System.out.print("Please enter your First Name: ");
				String first = console.nextLine();
				
				System.out.print("Please enter your Last Name: ");
				String last = console.nextLine();
				
				System.out.print("Please enter d amount: ");
				double amount = console.nextDouble();
				console.nextLine();
				
				if (bank.withdrawalMoney(first, last, amount)) {
					System.out.println("Information correct, Withdrawal Successful!");
					System.out.println("Thank you for banking with us at <|>");
					} else {
						System.out.println("Insufficient Fund for withdrawal!");
					
					}						
			}
			
			//Get Balance 5
			if (input == 5) {
				System.out.println("You had choosen option 5, fetching balance.");
				System.out.print("Please enter your First Name: ");
				String first = console.nextLine();
				
				System.out.print("Please enter your Last Name: ");
				String last = console.nextLine();
				
				double balance = bank.getBalance(first, last);
				
				if (balance == -1) {
					System.out.println("Incorrect information!");
				} else {
					System.out.println("Your current balance is $" + balance);
					System.out.println("Thank you for banking with us at <|>");
				}
			
			}	
			//Quit 
			if (input == 6) {
				System.out.println("Thank you for banking with us at <|>");
				answer = false;
			}
		}
		
	}
}