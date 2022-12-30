import java.util.Scanner;
public class Pro5_150121015 {/*
User enters a string such as “4-1-7”*/

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to my program.");
		int sizeofRow=1;
		while(true) {
			System.out.print("Enter a String: ");
			String enteredNumbers = input.nextLine();
			int[] decimalArray = getNumbersfromString(enteredNumbers); // Split and create digit array (int type) 
			sizeofRow=sizeControl(enteredNumbers);
			if(!(biggestOneBinaryLength(decimalArray)>sizeofRow)) {
				System.out.print("Enter number of steps: ");
				int steps=input.nextInt();
				input.nextLine();
		        int[][] binaryNumbersArray=new int[sizeofRow+2][sizeofRow+2]; // I put extra row and column not to get out of bound error and to ease control the neighbours
		        for (int i = 0; i < sizeofRow+1;i++)   
		        { // add all binaries to 2D array 
		        	if(i==0 || i==sizeofRow-1) {
		        		for (int j = 0; j < sizeofRow+2; j++) {
		        			binaryNumbersArray[j][0]=0;
		        			binaryNumbersArray[j][sizeofRow+1]=0;
		        			binaryNumbersArray[0][j]=0;
		        			binaryNumbersArray[sizeofRow+1][j]=0;  // I put 0 value to extra rows and columns not to change the sum value in the checkNeigh method
		        		}
		        		
		        	}
		        	else {
		        		for (int j = 1 ; j < sizeofRow+1; j++) {
		        			for(int p = 1,x=0; p < sizeofRow+1 && x<sizeofRow; p++,x++) {
		        			binaryNumbersArray[j][p]=convertDectoB(decimalArray[j-1], sizeofRow)[x];
		        			}
		        		}
		        	}
		        }
		        //pattern design
		        printShortLines(sizeofRow);
		        for (int i = 1; i < sizeofRow+1; i++) {
		        	for (int j = 1; j < sizeofRow+1; j++) {
		        	 
		        	 System.out.print("| "+binaryNumbersArray[i][j]+" ");
		        	}
		        	System.out.print("|");
		        	System.out.println();
		        printShortLines(sizeofRow);
		        }
				for (int i = 1; i < steps+1; i++) {
					System.out.println("It is converted to the following table after "+i+". step:");
					printShortLines(sizeofRow);
					int[][] finalArray=checkNeigh(binaryNumbersArray);
					for (int x = 1; x < sizeofRow+1; x++) {
						for (int j = 1; j < sizeofRow+1; j++) {
						 System.out.print("| "+finalArray[x][j]+" ");
						}
						System.out.print("|");
						System.out.println();
					printShortLines(sizeofRow);
				//
					if(x==sizeofRow) {
						for (int j = 1; j < sizeofRow+1; j++) {
							if(i==steps && j==1)
								System.out.printf("The decimal value for the second table after %d steps: ",steps);
							//binary to decimal
							int numberDec=0;
							for (int j2 = 1; j2 < sizeofRow+1; j2++) {
								numberDec+=finalArray[j][j2]*Math.pow(2,sizeofRow-j2);
							}
							//
							if(i==steps) {
							System.out.print(numberDec);
							if(j==sizeofRow)
							System.out.print(".");
							else
							System.out.print("-");
							}
							}
						}
					}
				}
				break;
		}
			else {
				System.out.printf("The number %d cannot be represented with %d x %d array! \n",biggestOneDecimal(decimalArray),sizeofRow,sizeofRow);
			}
	}
}
	
	public static int sizeControl(String entered) { // It counts short lines then add +1 end of the method and take it as size
		int size=0;
		for (int i = 0; i < entered.length() ; i++) {
			if (entered.charAt(i)=='-') {
				size ++;
			}
		}
		size++;
		return size;
	}
	public static int[] convertDectoB(int number, int size)  {
		int[] binaryArray = new int[size];
		int binary=decToBinary(number);  // Converts decimal to binary  
		String result=Integer.toString(binary);
		if (result.length()<size) {
			if(number==0) {
				for (int i = 0; i <size; i++) {
					result+="0";
				}
			}
			else {
				for (int j = 0; j < size-result.length()+1; j++) {
					result="0"+result;  // if size is 5 and binary 110 it makes 00110
				}
				for (int i = 0; i < size; i++) {
					binaryArray[i]=Integer.parseInt(Character.toString(result.charAt(i)));  // numbers was added to array one by one
				}
			}
		}
		else {
			for (int i = 0; i < size; i++) {
				binaryArray[i]=Integer.parseInt(Character.toString(result.charAt(i)));  // numbers was added to array one by one
			}
			
		}
		return binaryArray;
}
	public static int[] getNumbersfromString(String numberStr) { // Split the lines and get the numbers  1-2
	String[] numbersArrayStr = new String[sizeControl(numberStr)];
		int a = 0;
		int j = 0;
		for (int i = 0; i < numberStr.length(); i++) {
			String newStrNumber=" ";
			if(numberStr.charAt(i)=='-') {
					newStrNumber=numberStr.substring(a,i);
					a=i+1;
					numbersArrayStr[j]=newStrNumber;
					j++;
			if(j==numbersArrayStr.length-1) {
				break;
			}
			}
		}
		for (int i = numberStr.length()-1; i > 0; i--) {
			if(numberStr.charAt(i)=='-') {
				numbersArrayStr[numbersArrayStr.length-1]= numberStr.substring(i+1,numberStr.length());
			break;
			}
		}
		int[] intNumbers = new int[numbersArrayStr.length];
		for (int i = 0; i < numbersArrayStr.length; i++) {
			intNumbers[i] = Integer.parseInt(numbersArrayStr[i]);
		}
		return intNumbers;
	}
	public static int biggestOneBinaryLength(int[] numbers) { /* this method finds max number in the given 
	numbers ad converts binary and return max binary length*/
		int biggest = 0;
		for (int i = 0; i < numbers.length; i++) {
			biggest = Math.max(biggest,numbers[i]);
		}
		int maxBinarySize= Integer.toString(decToBinary(biggest)).length();
		return maxBinarySize;
	}
	public static int biggestOneDecimal(int[] numbers) { // It returns max value of entered numbers
		int biggest = 0;
		for (int i = 0; i < numbers.length; i++) {
			biggest = Math.max(biggest,numbers[i]);
		}
		return biggest;
	}
	public static int decToBinary(int number) {
		int binary = 0;
		int multiplier = 1;
		while (number != 0) {// This block convert the decimal which output of the selected operation to binary again
			int remainder = number % 2;
			binary += multiplier * remainder;
			number /= 2;
			multiplier *= 10;
			}
		return binary;
	}
	public static int binaryToDec(int number) {
		int decNumber=0;
		int sayacAddition=0;
		while (number != 0 ) 
		{
			if (number % 10 != 0) {
				decNumber+= number % 10 * Math.pow(2,sayacAddition);
				number /= 10;
				sayacAddition+=1;
				}
			else {
				number /= 10;
				sayacAddition+=1;
			}
		}
		return decNumber;
	}
	public static void printShortLines(int size) {
		for (int i = 0; i < 4*(size) + 1; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	public static int [][] checkNeigh(int[][] firstArray){
		int [][] newArray= new int[firstArray.length][firstArray.length];
		for (int i = 0; i < newArray.length; i++) {
			for (int j = 0; j < newArray.length; j++) {
				newArray[i][j]=firstArray[i][j];
			} // I created different 2D array with same values of old array
		}
		for (int i = 1; i < firstArray.length-1; i++) {
			for (int j = 1; j < firstArray.length-1; j++) {
				int valueInBox=firstArray[i][j];
				int sum=newArray[i-1][j-1]+newArray[i-1][j]+newArray[i-1][j+1] +newArray[i][j-1]+newArray[i][j+1]+newArray[i+1][j-1]+newArray[i+1][j]+newArray[i+1][j+1]; 
			//  I sum neighbour values of current block
			if(valueInBox==1) {
				if(sum<2)
					firstArray[i][j]=0;
				else if(sum==3||sum==2)
					firstArray[i][j]=1;
				else 
					firstArray[i][j]=0;
			}
			else {
				if(sum==3)
					firstArray[i][j]=1;
				else {
					firstArray[i][j]=0;
				}
			}
			}
		}
		return firstArray;
	}
}
// Eren Çolak - 150121015