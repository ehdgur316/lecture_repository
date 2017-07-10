package com.paran.chapter18;

public class Bank {
	public static void main(String[] args) {
		BankAccount guestAAA = new BankAccount("AAA", "999999");
		
		try {
			guestAAA.ownerAuthentication("AAA", "999999");
			
			guestAAA.deposite(10000000L);
			
			System.out.println("잔액 : " + guestAAA.withdraw(2500000L) + "원");
		} catch(BalanceNotEnoughException e) {
			e.printStackTrace();
		} catch(AccountAccessDenialException e) {
			e.printStackTrace();
		} finally {
			System.out.println("은행거래 종료");
		}
		
	}
}

class BankAccount {
	private AccountHolder owner;
	long balance;
	
	public BankAccount(String ownerName, String ownerID) {
		this.owner = new AccountHolder(ownerName, ownerID);
		this.balance = 0;
	}
	
	public void ownerAuthentication(String accessName, String accessID) throws AccountAccessDenialException {
		if (!(owner.ownerName.equals(accessName) && owner.ownerID.equals(accessID))) {
			throw new AccountAccessDenialException("잘못된 사용자 접근");
		}
		System.out.println("사용자 정보 확인 완료 - 계좌번호 : " + owner.accountNo);
	}
	
	public long withdraw(long amount) throws BalanceNotEnoughException{
		if (balance - amount < 0) {
			throw new BalanceNotEnoughException("잔액 부족");
		} 
		balance = balance - amount;
		return balance;
	}
	
	public void deposite(long amount) {
		balance = balance + amount;
	}
}

class AccountHolder {
	String ownerName;
	String ownerID;
	String accountNo;
	public AccountHolder(String ownerName, String ownerID) {
		this.ownerName = ownerName;
		this.ownerID = ownerID;
		this.accountNo = String.format("%04d", (int)(Math.random() * 1000))
				+ "-" + String.format("%03d", (int)(Math.random() * 1000))
				+ "-" + String.format("%06d", (int)(Math.random() * 1000000));
	}
}

class BalanceNotEnoughException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BalanceNotEnoughException() {
		super();
	}
	public BalanceNotEnoughException(String msg) {
		super(msg);
	}
}

class AccountAccessDenialException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AccountAccessDenialException() {
		super();
	}
	public AccountAccessDenialException(String msg) {
		super(msg);
	}
}