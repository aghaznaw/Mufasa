
public class BankTransaction {
	
	double balance ;
	double amount;
	String accountNumber;
	String transactionType;
	
	public BankTransaction(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public double credit(double amount, String accountNumber, BankServices bs) {
		this.balance = bs.getBalance(this.accountNumber);
		this.balance += amount;
		this.transactionType = "credit";
		
		this.amount = amount;
		
		return this.balance;
		
	}
	
	public double debit(double amount, String accountNumber, BankServices bs) {
		
		this.balance = bs.getBalance(this.accountNumber);
		this.balance = this.balance - amount;
		this.transactionType = "debit";
		
		this.amount = amount;
		
		return this.balance;
		
	}
}
