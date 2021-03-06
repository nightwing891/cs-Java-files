package assignment03;

import java.io.File;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * This class uses a file chooser to look through it to see if the file has any particular errors with the 
 * Calculations in the file of a particular format.
 * 
 * This either returns an error message or returns the value if it is right.
 *
 * @author  Henry Doan
 * @version February 3rd, 2017
 */
public class SummaryFileVerifier {

	/**
	 * has a file chooser to choose the file and run other methods to do the calculations and will return nothing if the
	 * user cancel.
	 */
	public static void main(String[] args) {
		// set it equals to the main directory to find the file.
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Which file would you like to verify?");
		
		int result;
		result = chooser.showOpenDialog(null);
		
		if (result == JFileChooser.CANCEL_OPTION) {
			return;
		}
		
		File inputFile;
		inputFile = chooser.getSelectedFile();
		
		System.out.println("You chose: " + inputFile);
		try {
			Scanner in = new Scanner(inputFile);
			
			scanNextTransaction(in);
			
			System.out.println("File verified ok.");
			
			in.close();
		
		} catch (IOException e) {
			System.out.println("Could not read the file: " + inputFile);
		}
		
	}
	
	/**
	 * A Boolean method to see if the word is a summary and is not a money value and bigger than 2 length
	 * 
	 * @return true if the condition is met
	 * 			false elsewise
	*/
	public static boolean isSummary (String s) {
		if (s.length() >= 2 && s.startsWith("SUMMARY") && s.charAt(0) != '$')
			return true;
		else 
			return false;
	}
	
	/**
	 * A Boolean method to see if the word is a buy section and is not a money value and bigger than 2 length
	 * 
	 * @return true if the condition is met
	 * 			false elsewise
	*/
	public static boolean isBuy (String s) {
		if (s.length() >= 3 && s.startsWith("BUY") && s.charAt(0) != '$')
			return true;
		else 
			return false;
	}
	
	/**
	 * A Boolean method to see if the word is a sell section and is not a money value and bigger than 2 length
	 * 
	 * @return true if the condition is met
	 * 			false elsewise
	*/
	public static boolean isSell (String s) {
		if (s.length() >= 2 && s.startsWith("SELL") && s.charAt(0) != '$')
			return true;
		else 
			return false;
	}
	

	/**
	 * this double method takes in a sting and takes the money sign off and convert what is left into a
	 * double and then return the double
	 * 
	 * @return double of the money value without the money sign
	*/
	public static double moneyValue (String openName) {
		String finalValue = openName.replace("$", "");
		
		return Double.parseDouble(finalValue);
	}

	/**
	 * a method to go through all the lines and make the appropriate values to see if the summary is right
	 * 
	 * 
	 * @return comparedValue the value of the total amount of the value that suppose to be
	 * 			else throw a error.
	*/
	
	// for some reason the variables are not being set properly an are stuck in a scope and thus gets an error
	// it was working then it lost scope for some reason in this method.
	
	public static double scanNextTransaction(Scanner s) {
		double sumOfSummary = 0;
		double sumOfSubSummary = 0;
		double comparedValue = 0;
		int summaryEntry = 0;
		
		//getting the next line
		String line = s.next();
		System.out.println(line);

		if (isSummary(line)) {
			String summaryDate = s.next(); // date
			String summaryValue = s.next(); // money value
			sumOfSummary = moneyValue(summaryValue); // setting the summary total to a double value

			summaryEntry = s.nextInt(); // gets the number of entries
				
			sumOfSubSummary = comparedValue + scanSubSummary(s, summaryEntry); 
		}
		
		if (isBuy(line) || isSell(line)) {
			String transactionDate = s.next();	// transaction date
			String transactionValue = s.next(); // transaction value
	
			comparedValue = comparedValue + moneyValue(transactionValue);
			
			scanNextTransaction(s);
		}
			
		// logic to see if the summary is vaild with the math. round
		if (Math.round(100 * sumOfSummary) != Math.round(100 * comparedValue)) {				
			JOptionPane.showMessageDialog(null, "error in the file and summary does not match the transaction records" );
			System.exit(0);
		}
		
		// for some reason the variables are not being set properly an are stuck in a scope and thus gets an error
		return comparedValue;
		
	}
	
	/**
	 *This method handles the sub summary and takes in a scanner and int number. The initializer is the 
	 *placeholder for the sub summary is read. a loop to recurse back to the scan next transaction method.
	 *This method sets the sum of the summary to whatever the value is and then returning it.
	 *
	 * @return sumOfSummarySum a double representing the sub summary value to be added in the scan next 
	 * transaction method.
	*/
	public static double scanSubSummary(Scanner s, int numberOfEntry) {
		double sumOfSummarySum = 0;
		
		for (int i = 0; i < numberOfEntry; i++) {
			sumOfSummarySum = scanNextTransaction(s);
		}
		
		return sumOfSummarySum;
	}

}
