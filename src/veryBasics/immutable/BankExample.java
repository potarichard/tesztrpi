package veryBasics.immutable;

final class BankAccount {
	
	private final long balance;
	
	public BankAccount(long balance) {			// mivel minden muveletnel uj BankAccount-ot returnolunk, csak uj referenciakapaskor adhatok erteket a balancnak
		validate(balance);						// no invalid object can be contructed, ha negativba menne at a balance, nem irja felul, hanem megmarad az eredeti
		this.balance = balance;					// nem kerulhet inconsistent statbe az object, mivel, meg az ertekadas elott exception, egyebkent meg uj copyt adunk az objectrol
	}
	
	public BankAccount withdraw(long amount) {
		long new_balance = newBalance(amount*-1);
		return new BankAccount(new_balance);
	}
	
	public BankAccount deposit(long amount) {
		long new_balance = newBalance(amount);
		return new BankAccount(new_balance);
	}
	
	private void validate(long balance) {
		if(balance < 0)
			throw new IllegalArgumentException("balance must be positive");
	}
	
	private long newBalance(long value) {
		// simulate exception here
		return this.balance + value;
	}
}

public class BankExample {

	public static void main(String[] args) {
		
		BankAccount bankaccount = new BankAccount(1500);
		
		// 1. case, no ovverride, just returned a new bankaccount
		bankaccount.deposit(500);												// mivel a bankaccount immutable, vagyis nem valtoztatjuk az erteket nem is lehet, igy ez egy uj objectet ad vissza
		
		// 2. case override with the new account, with the new blaance
		bankaccount = bankaccount.deposit(500);									// igy mar az uj accountunkal irjuk felul a regit
		
		// 3. withdraw so exception happens
		try {
			bankaccount = bankaccount.withdraw(2500);
		} catch (Exception e) {
			System.out.println("transaction didnot happened, bankaccount stayed the same");
		}
		
		System.out.println("vege");
	}

}
