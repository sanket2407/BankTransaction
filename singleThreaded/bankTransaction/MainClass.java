package singleThreaded.bankTransaction;

import java.util.Scanner;

public class MainClass {

	private static Scanner sc1;
	private static String transactionType;
	private static boolean isAuthorized = false;
	private static TransactionVO transactionVO;
	private static TransactionBO transactionBO;
	private static int balance;

	public static void main(String[] args) {

		// Initialize VO object
		transactionVO = new TransactionVO();

		System.out.println("Wel-come to Bank of America ATM");
		while (true) {
			while (true) {
				while (!(isAuthorized)) {

					// Enter ATM number.
					while (true) {
						System.out.println("Enter ATMNumber: ");
						sc1 = new Scanner(System.in);
						if (sc1.hasNext()) {
							try {
								transactionVO.setATMNumber(sc1.nextInt());
								break;
							} catch (Exception e) {
								System.out.println("Not valid input!");
							}
						}
					}

					// Enter PIN number.
					while (true) {
						System.out.println("Enter PIN: ");
						sc1 = new Scanner(System.in);
						if (sc1.hasNext()) {
							try {
								transactionVO.setPIN(sc1.nextInt());
								break;
							} catch (Exception e) {
								System.out.println("Not valid input!");
							}
						}
					}

					// Verify AMT number and PIN.
					System.out
							.println("Going to verify ATM card number with PIN.........");
					transactionBO = new TransactionBO(transactionVO);
					if (transactionBO.verifyPIN(transactionVO.getATMNumber())) {
						System.out.println("SUCCESS: Account verified!");
						isAuthorized = true;
					} else {
						System.out
								.println("ERROR: Acoount not verified! Try once again!");
						isAuthorized = false;
					}
				}

				// Enter transaction type.
				while (true) {
					System.out.println("Enter transaction type (credit / debit / balance): ");
					sc1 = new Scanner(System.in);

					if (sc1.hasNext()) {
						try {
							transactionType = sc1.nextLine();
							if (transactionType.equals("credit")
									|| transactionType.equals("debit")
									|| transactionType.equals("balance")) {
								transactionVO
										.setTransactionType(transactionType);
								break;
							} else {
								System.out
										.println("ERROR: Not valid transaction type! Please select from (credit / debit / balance)");
							}
						} catch (Exception e) {
							System.out.println("Not valid input!");
						}
					}
				}

				if (!transactionType.equals("balance")) {
					// Enter transaction amount.
					while (true) {
						System.out.println("Enter ammount: ");
						sc1 = new Scanner(System.in);
						if (sc1.hasNext()) {
							try {
								transactionVO.setAmount(sc1.nextInt());
								break;
							} catch (Exception e) {
								System.out.println("Not valid input!");
							}
						}
					}
				}

				// going to perform Transaction Action.
				try {
					balance = transactionBO.doTransactionAction(transactionVO);
					System.out.println("*****transaction sucessfull******");
					System.out.println("Your Balance is: " + balance);
					System.out.println("*********************************");
					break;
				} catch (Exception e) {
					System.out.println("ERROR: " + e + " Please try Again!!");
				}
			}// end while

			System.out.println("************summery************");
			System.out.println("ATM Number: " + transactionVO.getATMNumber());
			System.out.println("PIN Number: " + transactionVO.getPIN());
			System.out.println("Transaction type: "
					+ transactionVO.getTransactionType());
			System.out.println("Transaction amount: "
					+ transactionVO.getAmount());
			System.out.println("Balance: " + balance);
			System.out.println("*******************************");

		}// end while
		
	}// end main

}//end class
