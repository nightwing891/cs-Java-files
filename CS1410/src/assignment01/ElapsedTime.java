package assignment01;

import java.util.Scanner;

/**
 * This class calculates the hours, minutes and seconds of any given seconds.
 *
 * @author  Henry Doan
 * @version January 17, 2017
 */

public class ElapsedTime {

	/**
	 * Main method to run all the other methods in order.
	 */
	
	public static void main(String[] args) {
		welcome();
		calculation();
	}
	
	/**
	 * welcome method shows a welcome text in a string and a line separation.
	 */
	
	public static void welcome() {
		System.out.println("Hello! Welcome to the ElapsedTime,\nwhere this program will calculate the time with any given amount of seconds!");
		System.out.println("----------------------------------------------------------------------------");
	}
	
	/**
	 * Calculation method where the program gets the user input and used a scanner to do so and initialize the scanner as a integer variable for 
	 * shorter code. then use math library and logic to get the end result.
	 */
	
	public static void calculation() {
		// message prompt to get the user input.
		System.out.println("Enter the amount of seconds for the program to be converted: ");
		
		// initializing a new scanner with the user input to be a int, scanning the next input in the console for the integer for the seconds all in one line.
		int userInputInSeconds = new Scanner(System.in).nextInt();
		
		// set the int hours variable to be the divided by 3600 because that's how many seconds in an hour
		int hours = userInputInSeconds / 3600;
		
		// have the remaining of the hours be divided by 60 for the minutes
		int minutes = (userInputInSeconds % 3600) / 60;
		
		// have the remaining seconds 
		int seconds = userInputInSeconds % 60;

		// format into hours and minutes and seconds format with a modulo of 2 double meaning display the number with 2 places and put a 0 if it is a single digit of all the varibles
		String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
		
		// message out the process 
		System.out.println(userInputInSeconds + " seconds converts to: " + hours + " hours " + minutes + " minutes" + " and " + seconds + " seconds" );
		System.out.println("or");
		
		// display the formated string
		System.out.println(timeString);
	}
}
