package Atm;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
public class OptionMenu {

	
		
		Scanner menuInput=new Scanner(System.in);
		DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
		HashMap<Integer,Account> data=new HashMap<Integer,Account>();
		public void getLogin() throws IOException{
			boolean end=false;
			int customerNumber=0;
			int pinNumber=0;
			while(!end) {
				try {
					System.out.println("\nEnter your customer number:");
					customerNumber =menuInput.nextInt();
					System.out.println("\nEnter pin number:");
					pinNumber=menuInput.nextInt();
					Iterator it=data.entrySet().iterator();
					while(it.hasNext()) {
						Map.Entry pair=(Map.Entry) it.next();
						Account acc=(Account) pair.getValue();
						if(data.containsKey(customerNumber)&&pinNumber==acc.getpinNumber())
						{
							getAccountType(acc);
							end=true;
							break;
							
						}
					}
					if(!end) {
						System.out.println("\nWrong Customer Number or Pin Number");
					}
					
				}catch(InputMismatchException e) {
					System.out.println("\n Invalid character(s),Only numbers");
				}
				
			}
		}
		public void getAccountType(Account acc) {
			boolean end=false;
			while(!end) {
				try {
					System.out.println("\nSelect the account you want to access:");
					System.out.println("\nType 1 - Checkings Account");
					System.out.println("\nType 2 - Savings Account");
					System.out.println("\nType 3 - Exit ");
					System.out.println("\nChoice");
					int selection=menuInput.nextInt();
					switch(selection) {
					case 1:
						getChecking(acc);
						break;
					case 2:
						getSaving(acc);
						break;
					case 3:
						end =true;
						break;
					default:
						System.out.println("\nInvalid choice.");
					}
				}catch(InputMismatchException e) {
					System.out.println("\nInvalid choice");
					menuInput.next();
				}
			}
		}
		public void getChecking(Account acc) {
			boolean end=false;
			while(!end) {
				try {
					System.out.println("\ncheckings Account:");
					System.out.println("Type 1 - View Balance");
					System.out.println("Type 2 - Withdraw funds");
					System.out.println("Type 3 - Deposit funds");
					System.out.println("Type 4 - Transfer funds");
					System.out.println("Type 5 - Exit");
					System.out.println("\nChoice:");
					int selection =menuInput.nextInt();
					switch(selection) {
					case 1:
						System.out.println("\nCheckings acount Balance:"+moneyFormat.format(acc.getCheckingBalance()));
						break;
					case 2:
						acc.getCheckingWithdrawInput();
						break;
					case 3:
						acc.getCheckingDepositInput();
						break;
					case 4:
						acc.getTransferInput("Checkings");
						break;
					case 5:
						end=true;
						break;
					default:
						System.out.println("\nInvalid choice. ");
					}
				}catch(InputMismatchException e) {
					System.out.println("\nInvalid choice");
					menuInput.next();
				}
			}
		}
		public void getSaving(Account acc) {
			boolean end =false;
			while(!end) {
				try {
					System.out.println("\nSavings Account: ");
					System.out.println("Type 1 - View Balance");
					System.out.println("Type 2 - Withdraw funds");
					System.out.println("Type 3 - Deposit Funds");
					System.out.println("Type 4 - Transfer Funds");
					System.out.println("Type 5 - Exit");
					System.out.println("Choice:");
					int selection=menuInput.nextInt();
					switch(selection) {
					case 1:
						System.out.println("\nSavings Account Balance:"+ moneyFormat.format(acc.getSavingBalance()));
						break;
					case 2:
						acc.getsavingWithdrawInput();
						break;
					case 3:
						acc.getSavingDepositInput();
						break;
					case 4:
						acc.getTransferInput("savings");
						break;
					case 5:
						end=true;
					default:
						System.out.println("\nInvalid choice. ");
						
					}
				}catch(InputMismatchException e) {
					System.out.println("\nInvalid choice. ");
					menuInput.next();
				}
			}
		}
		public void createAccount() throws IOException{
			int cst_no = 0;
			boolean end=false;
			while(!end) {
				try {
					System.out.println("\nEneter your customer number:");
					cst_no=menuInput.nextInt();
					Iterator it=data.entrySet().iterator();
					while(it.hasNext()) {
						Map.Entry pair=(Map.Entry) it.next();
						if(!data.containsKey(cst_no)) {
							end=true;
							
						}
					}
					if(!end) {
						System.out.println("\nThis customer number is already registered");
					}
				
				}catch(InputMismatchException e) {
					System.out.println("\nInvalid choice");
					menuInput.next();
				}
			}
			System.out.println("\nEnter PIN to be registered");
			int pin=menuInput.nextInt();
			data.put(cst_no,new Account(cst_no,pin));
			System.out.println("\nYour new account has been successsfuly registered!");
			System.out.println("\nRedirecting to login.........");
			getLogin();
		}
//		public void mainMenu () throws IOException{
//			data.put(952141, new Account(952141, 191904, 1000, 5000));
//			data.put(123, new Account(123, 123, 20000, 50000));
//			boolean end=false;
//			while(!end) {
//				try {
//					System.out.println("\nType 1 - Login");
//					System.out.println(" Type 2 - Create Account");
//					System.out.println("\nchoice");
//					int choice=menuInput.nextInt();
//					switch(choice) {
//					case 1:
//						getLogin();
//						end=true;
//						break;
//					case 2:
//						createAccount();
//						end=true;
//						break;
//					default:
//						System.out.println("\nInvalid choice");
//					}
//				}catch(InputMismatchException e) {
//					System.out.println("\nInvalid choice.");
//					menuInput.next();
//				}
//			}
//			System.out.println("\nThannk you for using this ATM.\n");
//			menuInput.close();
//			System.exit(0);
//		}
		public void mainMenu() throws IOException {
			// TODO Auto-generated method stub
			data.put(952141, new Account(952141, 191904, 1000, 5000));
			data.put(123, new Account(123, 123, 20000, 50000));
			boolean end=false;
			while(!end) {
				try {
					System.out.println("\nType 1 - Login");
					System.out.println(" Type 2 - Create Account");
					System.out.println("\nchoice");
					int choice=menuInput.nextInt();
					switch(choice) {
					case 1:
						getLogin();
						end=true;
						break;
					case 2:
						createAccount();
						end=true;
						break;
					default:
						System.out.println("\nInvalid choice");
					}
				}catch(InputMismatchException e) {
					System.out.println("\nInvalid choice.");
					menuInput.next();
				}
			}
			System.out.println("\nThannk you for using this ATM.\n");
			menuInput.close();
			System.exit(0);
		}
	}


