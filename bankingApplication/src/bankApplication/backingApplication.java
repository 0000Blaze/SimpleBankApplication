package bankApplication;
import java.util.Scanner;

public class backingApplication {
	public static void main( String[] args )
	{
		String name,id;
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Enter your name :");
		name = scanner1.next();
		id ="AB123"; 
		BankAccount person = new BankAccount(name,id);
		person.displayMenu();
		scanner1.close();
	}

}

class BankAccount{
	
	int balance;
	String customerId;
	String customerName;
	int previousTransaction;
	
BankAccount(String cname,String cid){
	customerName = cname;
	customerId= cid;
	balance = 0;
	previousTransaction = 0;
}
	
void Deposit (int amount) {
	if (amount > 0) {
		balance += amount;
		previousTransaction = amount;
	}
	else {
		System.out.println("Amount zero transaction denied");
	}
}

void Withdraw(int amount) {
	if(amount > 0) {
		balance -= amount;
		previousTransaction = -amount;
	}
	else {
		System.out.println("Amount zero transaction denied");
	}
}
	
void PreviousTransactionDisplay() {
	if(previousTransaction > 0) {
		System.out.println("Deposit : " + previousTransaction);
	}
	else if(previousTransaction < 0) {
		System.out.println("Withdrew: " + Math.abs(previousTransaction) );
	}
	else {
		System.out.println("No Transaction to be displayed");
	}
}

void BalanceCheck() {
	System.out.println("Balance : "+ balance);
}

void displayMenu() {
	char option ='\0';
	int amount = 0;
	
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Welcome ! "+customerName + "\nYour id is "+ customerId+"\n");
	System.out.println("A. Balance Check");
	System.out.println("B. Deposite");
	System.out.println("C. Withdraw");
	System.out.println("D. Previous Transaction");
	System.out.println("E. Exit");
	
	do {
		System.out.println("******************************************************");
		System.out.println("Choose an option:");
		option = scanner.next().charAt(0);
		
		switch(option) {
		
		case 'A':
			BalanceCheck();
			break;
			
		case 'B':
			System.out.println("Enter amount to be deposited:");
			amount = scanner.nextInt();
			Deposit(amount);
			break;
			
		case 'C':
			System.out.println("Enter amount to be withdrawn:");
			amount = scanner.nextInt();
			Withdraw(amount);
			break;
			
		case 'D':
			System.out.println("The previous transaction is:\n");
			PreviousTransactionDisplay();
			break;
		
		case 'E':
			System.out.println("*********************************************");
			break;
			
		default:
			System.out.println("Invalid option entered!!");
			break;
		}
		
	
	}while(option != 'E');
	scanner.close();
	
	System.out.println(" THANK YOU!!!");
}

}

