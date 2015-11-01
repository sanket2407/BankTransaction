package singleThreaded.bankTransaction;

public class TransactionVO {
	
	private int ATMNumber, PIN, amount;
	private String transactionType;
	
	public int getATMNumber() {
		return ATMNumber;
	}
	public void setATMNumber(int aTMNumber) {
		ATMNumber = aTMNumber;
	}
	public int getPIN() {
		return PIN;
	}
	public void setPIN(int pIN) {
		PIN = pIN;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	

}
