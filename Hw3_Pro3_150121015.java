import java.util.*;
public class Hw3_Pro3_150121015 {
/* This program takes a string as input and prints pattern  */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print("Enter an input string : ");
			String string =input.nextLine();
			if (string.toUpperCase().equals("QUİT")) {  //Checked if the input is "quit"
				System.out.println("OK. Good bye :-) ");
				break;
			}
			else {
				for(int j=0;j<string.length();j++) {					// for loop for rows. As i increase it will go down next row
					for (int k = 0; k <string.length()-j; k++) {   
						System.out.print(string.charAt(k));				// top left pattern 
					}
					for (int i = string.length(); i > string.length()-j; i--) {
						System.out.print("  ");	                        // prints two blanks
					}
					for (int i = j; i < string.length(); i++) {
						System.out.print(string.charAt(i));             // top right pattern
					}
					System.out.println();								// next line
				}
				for (int i = 0; i < string.length(); i++) {				// for loop for rows . As i increase it will go down next row
					for (int j = 0; j < i+1 ; j++) {
						System.out.print(string.charAt(j)); 			// left bottom pattern
					}
					for (int s = string.length()-i-1; s > 0; s--) {		// prints two blanks
						System.out.print("  ");
					}
					for (int k = string.length()-i-1 ; k < string.length(); k++) {	
						System.out.print(string.charAt(k));				// right bottom pattern
					}	
					System.out.println();								//next line
				}
			}
		} input.close();
	}
}
//Eren Çolak - 150121015
		