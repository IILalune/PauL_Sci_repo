
public interface BankInterface {
	
	void openAccount(String first, String last,String address );
	
	boolean depositMoney(String first, String last, double depositAmount);
	
	boolean withdrawalMoney(String first, String last, double withdrawalAmount);
	
	double getBalance(String first, String last);
	
	int accountId(String first, String last);
	
	void listAccount();
}
