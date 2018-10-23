import java.util.*;

import javax.sound.midi.Track;

public class Bank {
	
	public ArrayList<Person> userList= new ArrayList<Person>();
	
	public ArrayList<BankTransaction> transactionList= new ArrayList<BankTransaction>();
	
	
	private String accountNumber;
	
	public Bank(String accountNumber ) {
		
		this.accountNumber = accountNumber;
		
	}

	public double getAccountBalance(BankServices bankServices ) {
		
		return bankServices.getBalance(this.accountNumber);
		
	}
	
	public void createStatement(String accountNumber) {
		
		for(BankTransaction t: transactionList) {
			if(t.accountNumber == accountNumber) {
				System.out.println(t.accountNumber);
				System.out.println(t.amount);
				System.out.println(t.transactionType);
				System.out.println(t.balance);
			}
		}
	}
	
	public void getUserList() {
		
		for(Person p: userList) {
			
			System.out.println(p.getName());
			System.out.println(p.getAccountNumber());
		}
		
	}
	
	public String getCountryById(String id, BankServices bs) {
		
		return bs.country(id);
	}
	
	public boolean authontecation(String username, String password, BankServices bs) {
		
		boolean auth;
		
		auth = bs.authontecation(username, password);
		
		return auth;
		
	}
	
	public String[] accountDetails(String username, String password, BankServices bs) {
		
		String[] auth = new String[2];
		
		auth = bs.accountDetails(username, password);
		
		return auth;
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		System.out.println("................................");
		
		
	}
	
}
