import java.util.Scanner;
import java.util.regex.Pattern;

//********************************************************************
//
//Author:        Madeline Weber
//
//Program:		 Number To Word Generator
//
//File Name:     NumberToWord.java
//
//
//Description:   This program receives a numeric check amount and writes the word 
//				 equivalent of the amount for security purposes. 
//				 Originally completed as part of a homework assignment.
//				 Asks user for input amount less than one thousand dollars. 
//
//********************************************************************

public class NumberToWord {

	//***************************************************************
    //
    //  Method:       main
    // 
    //  Description:  The main method of the program
    //
    //  Parameters:   String array
    //
    //  Returns:      N/A 
    //
    //**************************************************************
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);
        NumberToWord myobject = new NumberToWord(); 
        boolean runAgain = true;
      
        myobject.checkBool( runAgain );
    }
    
    //***************************************************************
    //
    //  Method:       checkBool
    // 
    //  Description:  Allows the users to continue the program until 
    // 				  a sentinel value of 0 is entered.
    //
    //  Parameters:   boolean seeIf
    //
    //  Returns:      N/A
    //
    //**************************************************************
   public void checkBool( boolean seeIf ){
	   NumberToWord temp = new NumberToWord();
	   double amount = 0.0;
	   while( seeIf ){
		   amount = temp.getInput();
		   if( amount == 0 ){
			   seeIf = false;
		   }
		   else{
			   String[] numericPostion = temp.splitString(Double.toString(amount));
			   int main = Integer.parseInt(numericPostion[0]);
			   int change = Integer.parseInt(numericPostion[1]);
			   String mwm = temp.numbertoString(main);
			   temp.printAmount(mwm, change);

		   }
	   }
   }
 //***************************************************************
   //
   //  Method:       printAmount
   // 
   //  Description:  Displays the numeric amount in words 
   //
   //  Parameters:   String mwm, int change
   //
   //  Returns:      N/A
   //
   //**************************************************************
   public void printAmount( String mwm, int change ){
	   System.out.println("" + mwm + " and " + change + "/100 dollars");
   }
 //***************************************************************
   //
   //  Method:       getInput
   // 
   //  Description:  Gets input from the user
   //
   //  Parameters:   None
   //
   //  Returns:      amount
   //
   //**************************************************************
    
    public double getInput(){
		// Scanner to get user input
		Scanner input = new Scanner(System.in);
		// Get dollar amount
		String numberToString = new String();
		System.out.println("Enter numeric check amount (less than $1000.00): $");
		double amount = input.nextDouble();
		numberToString = Double.toString(amount);
		if ( numberToString.contains(".")) {
        	String[] split = numberToString.split(Pattern.quote("."));
        	String decimalCheck = split[1];
        	if ( decimalCheck.length() > 2){
        		System.out.println("Invalid amount.");
        		amount = getInput();
        	}
        	else if ( amount >= 1000.00 ){
    			System.out.println("Invalid amount.");
    			amount = getInput();
        	}
		}
		return amount;
    } 
  //***************************************************************
    //
    //  Method:       splitString
    // 
    //  Description:  Creates an array by splitting the String of the 
    // 				  numeric value
    //
    //  Parameters:   String number
    //
    //  Returns:      fullAmount
    //
    //**************************************************************
    
    public static String[] splitString(String number) {
    	NumberToWord temp = new NumberToWord();
    	//String split[]; 
    	String[] split = new String[2]; 	
        if ( number.contains(".")) {
        	split = number.split(Pattern.quote("."));
        	}
        else {
        	split[0] = number;
        	split[1]= "00";
        }
        String main = split[0];
        String change = split[1];
        
        if ( split[1].length() == 1 ){
        	split[1] = (split[1] + "0" );
        }
        String[] fullAmount;
        fullAmount = new String[2];
        fullAmount[0] = main;
        fullAmount[1] = change;
        
        return fullAmount;
    }
    //***************************************************************
    //
    //  Method:       numbertoString
    // 
    //  Description:  Creates an array to get word of numeric value
    //
    //  Parameters:   int number
    //
    //  Returns:      buildSentence
    //
    //**************************************************************
    private static String numbertoString(int number) {
    	
        String buildSentence = new String();
        
        String one_19[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen"};
        String decades[] = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"};

        if ((number / 100) > 0) { 
            buildSentence += numbertoString(number / 100) + " hundred ";
            number %= 100;
        }

        if (number < 20) { 
            buildSentence += one_19[number]; 
        } else {
            buildSentence += decades[number / 10]; 
            if ((number % 10) > 0) {
                buildSentence += "-" + one_19[number % 10];
            }
        }
        return buildSentence;
    }
   
   // End Program
}
