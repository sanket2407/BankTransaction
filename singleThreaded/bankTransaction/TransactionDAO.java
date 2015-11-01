package singleThreaded.bankTransaction;

import java.util.HashMap;
import java.util.Map;

public class TransactionDAO {

	private static int balance = 10000;
	private Map<Integer, Integer> credential;

	public TransactionDAO() {
		//TODO: set parameter values from database.
		credential = new HashMap<Integer, Integer>();
		credential.put(12345, 123);
	}

	public int getPIN(int ATMNumber){
		if(credential.containsKey(ATMNumber)){
			return credential.get(ATMNumber);
		}else{
			return -1;
		}
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
