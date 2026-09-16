/** 
* BankMap Class contain a hashMap 
* that account information are stored in 
* and perform banking activities
* @author Paul Hoang
*/

import java.util.Random;
import java.util.Map;
import java.util.HashMap;


public class BankMap implements BankInterface { 
	
	//Field 
	private int numCustomer;
	private Map<Integer, Account> account;

	//Constructor
	public BankMap() {
		numCustomer = 0;
		this.account = new  HashMap<Integer, Account>();
	}
	
	/** * Open a new account, then store a new ID 
	* @param first The first name
	* @param last The last name
	* @param address The address of the customer
	* @return void
	* the method will generate random ID and store the customer
	* into an database of a HashMap that contain the randomized ID and 
	* account fields
	*/	
	public void openAccount(String first, String last, String address) {
		Random random = new Random(); 
		int id;  
		
		//generate random number starting 1000000 --> 9999999
		//check map, if id already created, generate a different one
		do {
			id = random.nextInt(9000000) + 1000000;
		} while (account.containsKey(id));
		
		//Create new account and store into HashMap
		Account newAccount = new Account(first, last, address, id);
		account.put(id, newAccount);
		numCustomer++;		
		
	}
	
	/** * Checking customer firstName and lastName, then deposit the money
	* @param first The first name
	* @param last The last name
	* @param depositAmount The amount of money to deposit
	* @return boolean the method will add the money into the customer account if account and
	* return true, else it would return false if no matching customer
	*/
	public boolean depositMoney(String first, String last, double depositAmount) {
		for (Account currentAcc : account.values()) {
			if (currentAcc.getFirstName().equalsIgnoreCase(first) 
				&& currentAcc.getLastName().equalsIgnoreCase(last)) 
			{
				currentAcc.deposit(depositAmount);
				return true;
			}
		}	return false;
	}
	
	/** * Checking customer firstName and lastName, then withdraw the money
	* @param first The first name
	* @param last The last name
	* @param withdrawAmount Amount The amount of money to withdraw
	* @return boolean The method will withdraw the customer money the customer account
	* and return true, if there are enough money then return false. 
	*/
	public boolean withdrawalMoney(String first, String last, double withdrawalAmount) {
		for (Account currentAcc : account.values()) {
			if (currentAcc.getFirstName().equalsIgnoreCase(first)
				&& currentAcc.getLastName().equalsIgnoreCase(last)) 
			{
				if (withdrawalAmount > currentAcc.getBalance()) {
					return false;
				} else { 
					currentAcc.withdrawal(withdrawalAmount);
					return true;
				}
			}
		} return false;
	}
	
	/** * Checking customer firstName and lastName, then print the account balance
	* @param first The first name
	* @param last The last name
	* @return double The method will return the amount of the account balance.
	* 		  if there are no account match, return -1.
	*/
	public double getBalance(String first, String last) {
		for (Account currentAcc : account.values()) {
			if (currentAcc.getFirstName().equalsIgnoreCase(first)
				&& currentAcc.getLastName().equalsIgnoreCase(last)) 
			{
				return currentAcc.getBalance();
			}
			
		} return -1;
	}
	
	/** * Checking customer firstName and lastName, then print ID number
	* @param first The first name
	* @param last The last name
	* @return void
	* the method will print the customer ID number
	*/
	public int accountId(String first, String last) {
		for (Account currentAcc : account.values()) {
			if (currentAcc.getFirstName().equalsIgnoreCase(first)
				&& currentAcc.getLastName().equalsIgnoreCase(last)) 
			{
				return currentAcc.showId();
			}
		} return -1;
	}
	
	/** * Return a list of all customer   name and their address
	* @return void
	* the method will print the customer name and their address
	*/public void listAccount() {
		for (Account currentAcc : account.values()) {
			System.out.println("First : " + currentAcc.getFirstName() +
							  ", Last : " + currentAcc.getLastName() +
							  ", Address:  " + currentAcc.getAddress());
		}
	}
	
	
	
	
	
}
