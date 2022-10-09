package banking;

import java.util.LinkedHashMap;
import java.util.UUID;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		// complete the function
		accounts = new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		// Generate new account number
//		long accountNumber = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		long accountNumber = accounts.size() + 1;
		Account acc = new CommercialAccount(company, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, acc);
        return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
//		long accountNumber = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		long accountNumber = accounts.size() + 1;
		Account acc = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, acc);
        return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
        return accounts.get(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		accounts.get(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		return accounts.get(accountNumber).debitAccount(amount);
	}
}
