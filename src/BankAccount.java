
public class BankAccount {
	
	private int accountNumber;
	private double accountBalance;
	
	public BankAccount(int accountNumber, double accountBalance ) {
		
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		
	}
	
	public int getAccountNumber() {
		
		return this.accountNumber;
	}
	
	public double getAccountBalance() {
		
		return this.accountBalance;
	}
	
	public void setAccountNumber(int accountNumber) {
		
		this.accountNumber = accountNumber;
	}
	
	public void setAccountBalance(double accountBalance) {
		
		this.accountBalance = accountBalance;
	}
}
