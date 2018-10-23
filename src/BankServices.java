
public interface BankServices {
	
	public double createBankStatement();
	public double getBalance(String AccountNumber);
	public String country(String id);
	public boolean authontecation(String username, String password);
	public String[] accountDetails(String username, String password);
}
