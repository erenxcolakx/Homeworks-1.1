import java.util.Scanner;

public class Hw4_150121015 {
	// This program takes an input from user and does the operations, operation descriptions were written in each method.

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int wordCount=0;
		int letterCount=0;
		while(true) {
			int operation =askForOperation();
			if (operation==1) {  // Change Case
				System.out.print("Please enter an input String: ");
				String words=input.nextLine();
				System.out.println(changeCase(words));
				}
			else if (operation==2) { // Occurrences
				System.out.println("Enter a sentence: ");
				String sentence = input.nextLine();
				String[] wordsInSentence= createArray(sentence);
				System.out.print("Please enter an input word: ");
				String word = input.nextLine();
				System.out.println(countOccurences(wordsInSentence, word));
			
			}
			else if (operation==3) {  // Encryption
				System.out.print("Please enter an input String: ");
				String sentence = input.nextLine();
				System.out.print("Enter an integer pattern: ");
				int pattern = input.nextInt();
				input.nextLine();
				System.out.println(encryption(sentence, pattern)); 
			}
			else if (operation==4) { // Statistics
				System.out.print("Enter the String words: ");
				String sentence= input.nextLine();
				wordCount=updateWordCount(wordCount, sentence);
				letterCount=updateLetterCount(letterCount, sentence);
				printStat(wordCount, letterCount);
			}
			else if (operation==5) {
				System.out.println("Program ends. Bye :)");
			break;
			}
			else {
				System.out.println("Wrong number");
			}
		}
		}
		public static int updateLetterCount(int count, String str) {// This method updates letter number
			int letterCount=count;
			for (int i = 0; i < str.length(); i++) {
				if(Character.isLetter(str.charAt(i))) {
					letterCount +=1;
				}
			}
			return letterCount;
		}
		public static int updateWordCount(int count, String str) {	// This method updates word number
			str=str.trim();
			for (int i = 1; i < str.length() ; i++) {
				if(str.charAt(i)==' '&& str.charAt(i-1)!=' ')       // I put second control statement to control if there is multiple space between words
					count +=1;
				}
			count +=1;
			return count;
		}
		public static void printStat (int wordCount, int letterCount) { // This method prints updated word and alphabetic letter counts
			System.out.println("The number of words: " + wordCount+"\n"
			+ "The number of alphabetic letters: " + letterCount);
		}
		public static String changeCase (String str) {  // This method changes cases if case is lower changes this to upper or does vice versa.
			String result = "";
			for (int i = 0; i < str.length(); i++) {
				if (Character.isLowerCase(str.charAt(i))) {
					result+=Character.toUpperCase(str.charAt(i));
				}
				else {
					result+=Character.toLowerCase(str.charAt(i));
				}
			}
			return result;
		}
		public static int countOccurences (String[] sentence, String word) {
			int counter = 0;
			for (int i = 0; i < sentence.length; i++) {
				if (word.equalsIgnoreCase(sentence[i])) {  // This block compare words by ignoring case type and if it equals add 1 to counter
					counter ++;
				}
			}
			return counter;
	}
		public static String[] createArray(String sentence) {  // I created method to create an array and I append the words to array
			Scanner scanner = new Scanner(sentence); 
			String[] wordsInSentence= new String[updateWordCount(0, sentence)];
			for (int i = 0; i < wordsInSentence.length; i++) {
				wordsInSentence[i]=(scanner.next());
				}
			return wordsInSentence;
			}
		
		public static String encryption (String str, int pattern) {
			String sentenceWithoutSpace="";  // I create new string to add letters without no space and then I made them upper case
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i)==' '){}
				else {
					sentenceWithoutSpace += Character.toUpperCase(str.charAt(i));
				}
			}
			if(pattern==1) {   // If pattern would be 1 it return as it is 
				return sentenceWithoutSpace;
			}
			String result = "";
			int step = 2*(pattern - 1); /* For first and last row, the length of index between first and second is 2 * (pattern - 1)  
			example: pattern would be = 5 there would be 8 index length between current and next character
			for the first and last row*/
			for (int rowNumber = 0; rowNumber < pattern; rowNumber++) {
				int i=0;
				if(rowNumber==0 || rowNumber == pattern-1) {  // I created If block to control if it is first or last row
					for (int j = rowNumber; j < sentenceWithoutSpace.length(); j=j+step) {
						result += sentenceWithoutSpace.charAt(j);
					}	
				}
				else { /* mid rows ---> If we look at given pattern the index difference between 2 characters is constantly changing in the mid rows so
					I created a boolean to apply different step formulas in sequence and reversed the boolean value at the end of each block.*/
					i= rowNumber;
					int stepfirst= 2 * (pattern - 1 -rowNumber);
					int stepSecond= 2 * rowNumber;
					boolean stepType = true;
					while(i<sentenceWithoutSpace.length()) {
						result+=sentenceWithoutSpace.charAt(i);
							if(stepType) {
								i+=stepfirst;
								stepType=false;
						}
							else {
								i+=stepSecond;
								stepType=true;
						}
					}
				}
				
			}
			return result;
		}
		public static int askForOperation() {  // This method takes a operation number from user
			Scanner input = new Scanner(System.in);
			System.out.print("Menu:\n"
					+ "1. Change Case\n"
					+ "2. Count occurrences\n"
					+ "3. Encryption\n"
					+ "4. Statistics\n"
					+ "5. Exit \nPlease select an option: ");
			int operation = input.nextInt();
			input.nextLine();
			return operation;
		
		}
		
		
}

// Eren Çolak - 150121015
	
		
			

