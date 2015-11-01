package singleThreaded.bankTransaction;

public class TransactionBO {
	
	private TransactionVO transactionVO;
	private int ATMNumber, tempPIN;
	private TransactionDAO transactionDAO;
	
	public TransactionBO(TransactionVO vo) {
		this.transactionVO = vo;
	}
	
	public boolean verifyPIN(int ATMNumber){
		this.ATMNumber = ATMNumber;
		transactionDAO = new TransactionDAO();
		tempPIN = transactionDAO.getPIN(ATMNumber);
		//compare PIN
		if(tempPIN == transactionVO.getPIN()){
			return true;
		}
		else{
			return false;
		}
	}

	public int doTransactionAction(TransactionVO transactionVO) throws Exception {
		this.transactionVO = transactionVO;
		if(transactionVO.getTransactionType().equals("credit")){
			return credit();
		}
		else if(transactionVO.getTransactionType().equals("debit")){
			return debit();
		}
		else if(transactionVO.getTransactionType().equals("balance")){
			return balance();
		}
		else{
			throw new Exception("Invalid Transaction Type");
		}
	}
	
	private int credit(){
		int newBalance = transactionDAO.getBalance() + transactionVO.getAmount();
		transactionDAO.setBalance(newBalance);
		return transactionDAO.getBalance();
	}
	private int debit() throws Exception{
		if(transactionDAO.getBalance()>=transactionVO.getAmount()){
		int newBalance = transactionDAO.getBalance() - transactionVO.getAmount();
		transactionDAO.setBalance(newBalance);
		return transactionDAO.getBalance();
		}
		else{
			throw new Exception("ERROR: Not enough balance in the Account!!");
		}
	}
	private int balance(){
		return transactionDAO.getBalance();
	}

}
