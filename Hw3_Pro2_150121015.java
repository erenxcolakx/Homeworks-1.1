import java.util.*;
public class Hw3_Pro2_150121015 {
 /*The first two numbers in the sequence 
	are 0 and 1, and each subsequent number is 4 times the previous number minus the one 
	before  that.
	
	This program calculates the x-th number in the sequence.
	 */
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	long a0=0;
	long a1=1;
	long a2;
	System.out.print("Please enter an integer number: ");
	int inputNumber=input.nextInt();
	if (inputNumber==1)
		System.out.printf("In position %d , the value is %d",inputNumber,a0);
	else if(inputNumber==2)
		System.out.printf("In position %d , the value is %d",inputNumber,a1);
	else if(inputNumber<1)
		System.out.println("Input number can't be negative or zero");
	else {
		for (int i = 2; i <= inputNumber; i++) {
			a2= (4*a1)-a0;
			a0=a1;				//updating values while for have been executing
			a1=a2;
			if (i==inputNumber-1)
					System.out.printf("In position %d , the value is %d",inputNumber,a2);
			}
	}input.close();
	}
}

// Eren Çolak - 150121015
