/** 
* Bank Class contain an array ]
* that account information are stored in 
* and perform banking activities
* @author Paul Hoang
*/

import java.util.Random; 

public class Bank {
	//Field
	private int numCustomer;
	private Account[] account;
	
	//Constructor
	public Bank() {
		this.account = new Account[1000]; //small bank, 1000 customer growth goal	
		numCustomer = 0;
	}
		
	/** * Open a new account, then store a new ID 
	* @param first The first name
	* @param last The last name
	* @param address The address of the customer
	* @return void
	* the method will generate random ID and store the customer
	* into an database of customers in an array
	*/
	public void openAccount(String first, String last, String address) {
		Random random = new Random();
		int id = random.nextInt(1000000) + 1000000;
		Account newAccount = new Account(first, last, address, id);
		account[numCustomer] = newAccount;
		numCustomer++;
	}
	
	/** * Checking customer firstName and lastName, then deposit the money
	* @param first The first name
	* @param last The last name
	* @param depositAmount The amount of money to deposit
	* @return boolean the method will add the money into the customer account if account and
	* return true, else it would return false if no matching customer
	*/
	public boolean depositMoney(String first, String last, double depositAmount ) {
		for(int i = 0; i < numCustomer; i++) {			
			if (account[i].getFirstName().trim().equalsIgnoreCase(first.trim()) 
			    && account[i].getLastName().trim().equalsIgnoreCase(last.trim())) 
			{
				account[i].deposit(depositAmount);
				return true;
			}	
		} return false; // if a customer is found, add deposit, return true, else return false if not found.
	}
	
	/** * Checking customer firstName and lastName, then withdraw the money
	* @param first The first name
	* @param last The last name
	* @param withdrawAmount Amount The amount of money to withdraw
	* @return boolean The method will withdraw the customer money the customer account
	* and return true, if there are enough money then return false. 
	*/
	//withdrawalMoney
	public boolean withdrawalMoney(String first, String last, double withdrawAmount ) {
		for(int i = 0; i < numCustomer; i++) {	
			if (account[i].getFirstName().trim().equalsIgnoreCase(first.trim()) 
			 && account[i].getLastName().trim().equalsIgnoreCase(last.trim())) 
				{
				if (withdrawAmount > account[i].getBalance()) {
				return false;
				} else {
					account[i].withdrawal(withdrawAmount);
					return true;
				}
			}
		} return false;
	}
	
	/** * Checking customer firstName and lastName, then print the account balance
	* @param first The first name
	* @param last The last name
	* @return double The method will return the amount of the account balance
	*/
	//getBalance
	public double getBalance(String first, String last) {
		for(int i = 0; i < numCustomer; i++) {
			if (account[i].getFirstName().trim().equalsIgnoreCase(first.trim()) 
			 && account[i].getLastName().trim().equalsIgnoreCase(last.trim()))  
			{
				return account[i].getBalance();
			}
		} return -1;   // if there are no customer match, provide java -1 to make sure the method got return value
	}
	
	/** * Checking customer firstName and lastName, then print ID number
	* @param first The first name
	* @param last The last name
	* @return void
	* the method will print the customer ID number
	*/
	//accountID
	public int accountId(String first, String last) {
		for(int i = 0; i < numCustomer; i++) {
			if (account[i].getFirstName().trim().equalsIgnoreCase(first.trim()) 
			 && account[i].getLastName().trim().equalsIgnoreCase(last.trim()))  
			{
				return account[i].showId();
			}
		} return -1;
	}
	
	/** * Return a list of all customer name and their address
	* @return void
	* the method will print the customer name and their address
	*/
	//accountID
	//listACcount
	public void listAccount() {
		for(int i = 0; i < numCustomer; i++) {
			System.out.println("First : " + account[i].getFirstName()
						   + ", Last : " + account[i].getLastName()
					       + ", Address: " + account[i].getAddress());
		}

	}
	
	
	
}
