import java.util.Scanner;
/* This program gives binary result according to selected base and selected operation*/
public class Hw2_150121015 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("The base of number system (min:2 , max:10): ");
		int numberSystem = input.nextInt();
		System.out.println(
				"The type of the operation (‘a’ for addition, ‘s’ for subtraction, ‘m’ for multiplication, and ‘d’ for division) ");
		String operation = input.next();
		System.out.print("Enter the input for number 1: ");
		long number1 = input.nextInt();
		System.out.print("Enter the input for number 2: ");
		long number2 = input.nextInt();
		int decNumber1 = 0;
		int decNumber2 = 0;
		int remainder;
		int binary = 0;
		int multiplier = 1;
		int result = 0;
		int sayacAddition1 = 0;
		while (number1 != 0) {    // I change first binary to decimal in this block
			if (number1 % 10 != 0) {
				decNumber1 += number1 % 10 * Math.pow(numberSystem, sayacAddition1);
				number1 /= 10;
				sayacAddition1 += 1;
			} else {
				number1 /= 10;
				sayacAddition1 += 1;
			}
		}
		int sayacAddition2 = 0; 
		while (number2 != 0) {		// I change second binary to decimal in this block
			if (number2 % 10 != 0) {
				decNumber2 += number2 % 10 * Math.pow(numberSystem, sayacAddition2);
				number2 /= 10;
				sayacAddition2 += 1;
			} else {
				number2 /= 10;
				sayacAddition2 += 1;
			}
		}
		switch (operation) {   // I create switch case block to select operation and I assigned the result of operation to "result" variable
			case "a":
				result = decNumber1 + decNumber2;
				break;
			case "s":
				if (decNumber1 < decNumber2) {
					result = decNumber2 - decNumber1;
				} else {
					result = decNumber1 - decNumber2;
				}
				break;
			case "m":
				result = decNumber1 * decNumber2;
				break;
			case "d":
				if (decNumber1 < decNumber2) {
					result = decNumber2 / decNumber1;
				} else {
					result = decNumber1 / decNumber2;
				}
				break;
			default:
				System.out.println("Invalid operation");
				break;
		}
		while (result != 0) {    // This block convert the decimal which output of the selected operation to binary again
			remainder = result % numberSystem;
			binary += multiplier * remainder;
			result /= numberSystem;
			multiplier *= 10;
		}
		System.out.println(binary);
		input.close();
	}
}
// Eren Çolak -150121015