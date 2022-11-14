import java.util.Scanner;
public class Pro3_150121015 {
		// This program calculates account values month by month and calculate profit by applying mathematical expressions of PPS
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// getting input
		System.out.print("Enter your monthly salary: ");
		double monthSalary = input.nextDouble();
		System.out.print("Enter the percent of your salary to save, for example 10%: % ");
		double percentSave = input.nextDouble();
		System.out.print("Enter the monthly interest rate, for example 8.25%: % ");
		double interestRate = input.nextDouble();
		System.out.print("Enter the monthly government support rate, for example 25%: % ");
		double supportRate = input.nextDouble();
		// deposited money is calculated
		double deposit = monthSalary * percentSave / 100;
		// I created result variable to equalize result of PPS's mathematical expression 
		double result = deposit * (1 + supportRate/100) * (1 + interestRate/100);
		// I calculated results by using addition assignment and  multiplication assignment without creating variables
		System.out.println("After the first month, the account value is:" + (int)(result * 100) / 100.0);
		result += (deposit * (1 + supportRate/100)); result*=(1 + interestRate/100);
		System.out.println("After the second month, the account value is: " + (int)(result * 100) / 100.0);
		result += (deposit * (1 + supportRate/100)); result*=(1 + interestRate/100);
		System.out.println("After the third month, the account value is: " + (int)(result * 100) / 100.0);
		result += (deposit * (1 + supportRate/100)); result*=(1 + interestRate/100);
		System.out.println("After the fourth month, the account value is: " + (int)(result * 100) / 100.0);
		result += (deposit * (1 + supportRate/100)); result*=(1 + interestRate/100);
		System.out.println("After the fifth month, the account value is: " + (int)(result * 100) / 100.0);
		result += (deposit * (1 + supportRate/100)); result*=(1 + interestRate/100);
		System.out.println("After the sixth month, the account value is: " + (int)(result * 100) / 100.0);
		// We calculated 6 times
		double saved = (6 * deposit);
		double profit = (result - saved);
		System.out.print("In total, you saved " + (int)(saved * 100) / 100.0 + " TLs and your total profit is " + (int)(profit * 100) / 100.0 + " TLs");
		input.close();
		// Eren Çolak - 150121015
	}

}
