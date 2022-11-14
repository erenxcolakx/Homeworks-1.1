import java.util.Scanner;
// This program calculate the gross, dozen and rest of inputed eggs
public class Pro2_150121015 {
	public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);
	System.out.print("Please enter your total number of eggs: ");
	int eggs = input.nextInt();  // input eggs number
	int gross = eggs / 144 ;   // to find gross we do eggs / 144
	int grossRemain = eggs % 144 ;  //and remaining gross
	int dozen = grossRemain / 12 ; // to find dozen we divide remainder by 12
	int dozenRemain = grossRemain % 12 ;  // and remainder of this process is the rest of eggs
	System.out.print("Your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + dozenRemain);
	input.close();
	}
  /* Eren Çolak
      150121015 */
}
 