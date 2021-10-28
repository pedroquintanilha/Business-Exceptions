package application;

import java.util.Locale;
import java.util.Scanner;

import model.exceptions.BusinessException;
import model.entities.Account;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner s = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = s.nextInt();
			s.nextLine();
			System.out.print("Holder: ");
			String holder = s.nextLine();
			System.out.print("Initial balance: ");
			double balance = s.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = s.nextDouble();
			Account ac = new Account(number, holder, balance, withdrawLimit);
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			ac.withdraw(s.nextDouble());
			System.out.print("New balance: " + String.format("%.2f",ac.getBalance()));
		}
		catch(BusinessException e) {
			System.out.print("Withdraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.print("Unexpected error");
		}
		
		s.close();
	}
}
