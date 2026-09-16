/**
 * Institution: Bellevue College 
 * Course: Fundamentals of Computer Science I
 * Quarter: Spring 2026
 * Student name: Paul Hoang
 * Program description: Banking with Map implement.
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//string, scanner and Bank
		Scanner console = new Scanner(System.in);
		
		
		BankInterface bank = new Bank();
		//BankInterface bank = new BankMap();
		
		// Looping options
		// Set true to enter loop, if option 6 (quit), return false to exit
		boolean answer = true; 
		while (answer) {

			 clearConsole(); // Call it here!
		
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
			int input = -1;
			
			//Avoid all letter input cases
			try { 
				System.out.print("Your answer (in number) : ");
				input = console.nextInt();
				console.nextLine();	
			} catch (Exception e) {
				System.out.println("Illegal response, please enter a number");
				System.out.println();
				console.nextLine();
				continue; //continue the loop
			}		
			//only taking option 1-6
			
			if (input < 1 || input > 6 ) {
				System.out.println("Invaid option. Please select option 1 through 6");
				System.out.println();
				continue; 
			}
			
					
			
			// Create account 1
			if (input == 1) {
				System.out.println("You had choosen option 1, Creating new account.");
				//store Name and address
				System.out.print("Please enter your First Name: ");
				String first = console.nextLine().trim();     //Use trim for sanitizing input
				
				System.out.print("Please enter your Last Name: ");
				String last = console.nextLine().trim();
				System.out.print("Please enter your address: ");
				
				String address = console.nextLine().trim();
				bank.openAccount(first, last, address);
				System.out.println();
				System.out.println("Hello " + first + ", Welcome to <|> banking, thank you for choosing us!");	
			}
			
			//List Account 2
			if (input == 2) { 
				System.out.println("You had choosen option 2. Please enter Admin authentication passcode to proceed.");
				System.out.println("Adminstration code: ");
				String passcode = console.nextLine().trim();
				
				//check passcode
				if (passcode.equals("Adminlogin")) {
					System.out.println("------------------------------------------");
					System.out.println("Authorized. Here is the list of all accounts");
					bank.listAccount();
				} else {
					System.out.println("Access denied! Incorrect Passcode");
				}
				
				
				
				System.out.println("Press Enter to continue...");
			    console.nextLine();
			    System.out.println("------------------------------------------");
			}
			
			//Make deposit 3
			if (input == 3) {
				System.out.println("You had choosen option 3, deposit money. ");
				System.out.print("Please enter your First Name: ");
				String first = console.nextLine().trim();
				
				System.out.print("Please enter your Last Name: ");
				String last = console.nextLine().trim();
				
				
				//Only letting double input, 
				double amount = 0.0;
				try {
					System.out.print("Please enter deposit amount: ");
					amount = console.nextDouble();
					console.nextLine();
				} catch (Exception e) {
					System.out.println("Invalid input. Please enter a number amount, rounded to the nearest cent.");
					System.out.println();
					console.nextLine();
					continue;
				}
				
				//Round to the nearest cent
				amount = Math.round(amount * 100.0) / 100.0;
				
				if (bank.depositMoney(first, last, amount)) {
					System.out.println("Information correct, Deposit Successful!");
					System.out.println("Thank you for banking with us at <|>");
					System.out.println();

					} else {
						System.out.println("Verify failed, Incorrect personal information entered.");
						System.out.println();

					}	
			}
			//Make withdrawal 4 
			if (input == 4) {
				System.out.println("You had choosen option 4, withdrawal money.");
				System.out.print("Please enter your First Name: ");
				String first = console.nextLine().trim();
				
				System.out.print("Please enter your Last Name: ");
				String last = console.nextLine().trim();
				
				//Only letting double input, 
				double amount = 0.0;
				try {
					System.out.print("Please enter withdrawal amount: ");
					amount = console.nextDouble();
					console.nextLine();
				} catch (Exception e) {
					System.out.println("Invalid input. Please enter a number amount, rounded to the nearest cent.");
					System.out.println();
					console.nextLine();
					continue;
				}
				
				//Round to the nearest cent
				amount = Math.round(amount * 100.0) / 100.0;
			
				
				
				
				if (bank.withdrawalMoney(first, last, amount)) {
					System.out.println("Information correct, Withdrawal Successful!");
					System.out.println("Thank you for banking with us at <|>");
					} else {
						System.out.println("Insufficient Fund for withdrawal!");
						System.out.println();

					
					}						
			}
			
			//Get Balance 5
			if (input == 5) {
				System.out.println("You had choosen option 5, fetching balance.");
				System.out.print("Please enter your First Name: ");
				String first = console.nextLine().trim();
				
				System.out.print("Please enter your Last Name: ");
				String last = console.nextLine().trim();
				
				double balance = bank.getBalance(first, last);
				
				if (balance == -1) {
					System.out.println("Incorrect information!");
				} else {
					System.out.printf("Your current balance is $%.2f%n", balance);
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

	public static void clearConsole() {
    	System.out.print("\033[H\033[2J");
    	System.out.flush();
	}
}