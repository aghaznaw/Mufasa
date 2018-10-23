import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class BankTest {

	@Test
	public void testGetBalance() {
		
		BankServices balanceMock = EasyMock.createMock(BankServices.class);
		EasyMock.expect(balanceMock.getBalance("5541 8874 0002 1245"))
		.andReturn(8500.00);
		EasyMock.replay(balanceMock);
		
		Bank bank = new Bank("5541 8874 0002 1245");
		double balance = bank.getAccountBalance(balanceMock);
		
		assertEquals("accountbalanc", 8500.00, balance, 00);
	}
	
	@Test 
	public void testCredit() {
		
		BankServices balanceMock = EasyMock.createMock(BankServices.class);
		EasyMock.expect(balanceMock.getBalance("8733 9584 4001 8844"))
		.andReturn(8500.00);
		EasyMock.replay(balanceMock);
	
		BankTransaction bt = new BankTransaction("8733 9584 4001 8844");
		double balance = bt.credit(2000.00, "8733 9584 4001 8844", balanceMock);
		
		// the current balance is 8500.00 
		// credit 2000.00
		//expected = 10500.00
		assertEquals("Test Credit", 10500.00, balance, 00);
		
	}
	
	@Test 
	public void testDebit() {
		
		BankServices balanceMock = EasyMock.createMock(BankServices.class);
		EasyMock.expect(balanceMock.getBalance("8733 9584 4001 8844"))
		.andReturn(40000.00);
		EasyMock.replay(balanceMock);
	
		BankTransaction bt = new BankTransaction("8733 9584 4001 8844");
		double balance = bt.debit(20000.00, "8733 9584 4001 8844", balanceMock);
		
		// the current balance is 8500.00 
		// credit 2000.00
		//expected = 10500.00
		assertEquals("Test debit", 20000.00, balance, 00);
		
	}
	
	@Test 
	public void testGetCountry() {
		
		String countryId = "8844";
		
		BankServices countryMock = EasyMock.createMock(BankServices.class);
		EasyMock.expect(countryMock.country(countryId)).andReturn("Finland");
		EasyMock.replay(countryMock);
	
		Bank bank = new Bank("");
		String actual = bank.getCountryById(countryId, countryMock);
		
		assertEquals("Finland", actual);
		
	}
	
	@Test 
	public void AuthontecationTest() {
		
		String username = "ahmad.ghaznawi";
		String password = "HYENFTkd2";
		
		BankServices authMock = EasyMock.createMock(BankServices.class);
		EasyMock.expect(authMock.authontecation(username, password))
		.andReturn(true);
		EasyMock.replay(authMock);
	
		Bank bank = new Bank("");
		boolean actual = bank.authontecation(username, password, authMock);
		
		assertEquals(true, actual);
		
	}
	
	
	@Test 
	public void AuthontecationWrongPassUsernameTest() {
		
		String username = "ahmad.ghazna";
		String password = "HYENFTk";
		
		BankServices authMock = EasyMock.createMock(BankServices.class);
		EasyMock.expect(authMock.authontecation(username, password))
		.andReturn(false);
		EasyMock.replay(authMock);
	
		Bank bank = new Bank("");
		boolean actual = bank.authontecation(username, password, authMock);
		
		assertEquals(false, actual);
		
	}
	
	@Test 
	public void accountDetailsTest() {
		
		String username = "ahmad.ghazna";
		String password = "HYENFTk";
		
		BankServices detailsMock = EasyMock.createMock(BankServices.class);
		EasyMock.expect(detailsMock.accountDetails(username, password))
		.andReturn(new String[] {
				 "Ahamd", 
				 "Shah", 
				 "00358558899", 
				 "ahamd.h@gmail.com", 
				 "8733 9584 4001 8844", 
				 "Torikatu 19 A 12", 
				 "Filand", 
				 "25/4/1988"
				 });
		
		EasyMock.replay(detailsMock);
	
		Bank bank = new Bank("");
		String[] actual = bank.accountDetails(username, password, detailsMock);
		
		String array[] = {
				 "Ahamd", 
				 "Shah", 
				 "00358558899", 
				 "ahamd.h@gmail.com", 
				 "8733 9584 4001 8844", 
				 "Torikatu 19 A 12", 
				 "Filand", 
				 "25/4/1988"
			 };
		
		assertArrayEquals(array, actual);
		
	}

}
