/** 
* Account class object that create
* the user information to store
* @author Paul Hoang 
*/

public class Account {
	//field
	private String firstName;
	private String lastName;
	private String address;
	private double balance;
	private int customerId;
	
	//constructor
	public Account(String firstName, String lastName, String address, int customerId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		balance = 0.0;
		this.customerId = customerId; 
	}
	
	
	
	/** * Deposit
	* @param amount The amount to add to the balance  
	* @return the updated balance after deposit
	*/
	public double deposit(double amount) {
		balance += amount;
		return balance;
	}
	
	/** * Withdrawal 
	* @param amount The amount to withdraw to the balance  
	* @return the update balance after withdraw
	*/ 
	public double withdrawal(double amount) {
		balance -= amount;
		return balance;
	}
	
	//Get the Balance  
	public double getBalance() {
		return  balance;
	}
	
	//Get the firstName
	public String getFirstName() {
		return firstName;
	}
	
	//Get the lastName
	public String getLastName() {
		return lastName;
	}
	
	//Get the address
	public String getAddress() {
		return address;
	}
	
	
	//custom method to update ID for sercurity
	public int showId() {
		return customerId;
	}
	
}
