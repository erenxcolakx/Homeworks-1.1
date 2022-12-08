import java.util.Scanner;
public class Hw3_Pro1_150121015 {
/* The ‘b’s in the sequence are for printing a blank character, ‘s’s 
	for printing ‘*’ and ‘n’s for newline. A digit before any of these characters 
	shows how many times the character are printed, if the digit is missing, 
	the character are printed only once.  */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Please enter your sequence: ");
		String sequence=input.nextLine();
		for(int i =0;i<sequence.length() ;i++) {
			if(i==0) 
			{  // Checked whether the first character is digit or not
				if(Character.isDigit(sequence.charAt(0))) {
				}
				else {
					switch (sequence.charAt(0)) {
				case 'b':
					blank();
					break;
				case 's':
					star();
					break;
				case 'n':
					nLine();
					break;
				default:
					break;
					}	
				}
			}
			else if(Character.isDigit(sequence.charAt(i-1))) {
				char charAfterNumber=sequence.charAt(i);
				for(int times=0;times<(int)(sequence.charAt(i-1)-'0');times++) {  //for loop until the number which comes before character
					switch (charAfterNumber) {
					case 'b':
						blank();
						break;
					case 's':
						star();
						break;
					case 'n':
						nLine();
						break;
					default:
						break;
					}
				}
			}
			else { 
				char charAfterNumber=sequence.charAt(i); //if there is no digit before the character else block will be executed
				switch (charAfterNumber) {
				case 'b':
					blank();
					break;
				case 's':
					star();
					break;
				case 'n':
					nLine();
					break;
				default:
					break;
				}		
			}
		}
		input.close();
	} 
	// Methods for the characters
	public static void blank() {
		System.out.print(" ");
	}
	public static void star() {
		System.out.print("*");
	}
	public static void nLine() {
		System.out.println();
	}
}

// Eren Çolak - 150121015
