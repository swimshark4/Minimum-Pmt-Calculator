/*
	Author:		S.Craig
	Date:		14 October 2018
	Section:	CSC120, Section N01
	Desc:		Minimum Monthly Payment
				Write a program that calculates the minimum fixed monthly payment needed in order pay off a credit card balance within 12 months. By a fixed monthly payment, we mean a single number which does not change each month, but instead is a constant amount that will be paid each month.
				The following variables contain values as described below:
				balance - the outstanding balance on the credit card
				annualInterestRate - annual interest rate as a decimal
				The program should print out one line: the lowest monthly payment that will pay off all debt in under 1 year, for example:
				Lowest Payment: 180
				Assume that the interest is compounded monthly according to the balance at the end of the month (after the payment for that month is made). The monthly payment must be a multiple of $10 and is the same for all months. Notice that it is possible for the balance to become negative using this payment scheme, which is okay. A summary of the required math is found below:
				Monthly interest rate = (Annual interest rate) / 12.0
				Monthly unpaid balance = (Previous balance) - (Minimum monthly payment)
				Updated balance each month = (Monthly unpaid balance) + (Monthly interest rate x Monthly unpaid balance)
				Save your file as "MinPaymentLastNameFirstName.java" and upload it here. 
				=================================================
					Test Case 1:
						Enter your balance: 3329
						Enter your Annual Interest Rate: 0.2
						Lowest Payment: $310
					Test Case 2:
						Enter your balance: 4773
						Enter your Annual Interest Rate: 0.2
						Lowest Payment: $440
					Test Case 3:
						Enter your balance: 3926
						Enter your Annual Interest Rate: 0.2
						Lowest Payment: $360
				=================================================
				Note!!!!! If you are getting 450 or 370 for the 2nd and 3rd test case, you are calculating compound interest BEFORE making a payment. Break it up into two equations and make the payment before calculating compund interest.
*/
import java.util.Scanner;

public class MinPaymentCraigSamuel {
	public static void main(String[] args) {
		
		// User prompted for balance & annual interest rate
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your balance: ");
		double balance = input.nextDouble();
		System.out.print("Enter your Annual Interest Rate: ");
		double annualInterestRate = input.nextDouble();
		

		
		// Declarations here to keep them in scope for the do-while loop
		double monthlyPmt = 0;
		double monthlyIntRate = 0;
		double monthlyIntAmount = 0;
		double monthlyUnpdBal= 0;
		
		// Calculate lowest monthly payment to pay off balance in 12 months
		do {
			// This section calculates the first month of the loan before running a loop for the rest of the loan
			int i = 0;
			monthlyPmt += 10.00;
			monthlyIntRate = (annualInterestRate / 12.0);
			monthlyIntAmount = monthlyIntRate * balance;
			monthlyUnpdBal= balance - monthlyPmt + monthlyIntAmount;
			
			// This while loop section calculates the rest of the 11 months
			while (i < 11) {
				monthlyUnpdBal -= monthlyPmt;
				monthlyIntAmount = monthlyIntRate * monthlyUnpdBal;
				monthlyUnpdBal += (monthlyIntRate * monthlyUnpdBal);
				i++;
			}
			
		} while (monthlyUnpdBal > 0.0);
		
		// Output lowest payment amount
		System.out.printf("Lowest Payment: $%4.2f", monthlyPmt);
		
	}
}
