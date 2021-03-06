package assignment01;

import java.util.Scanner;

/**
 * This class implements calculates the area with any given radius of a circle.
 *
 * @author  Henry Doan
 * @version January 17, 2017
 */

public class CircleArea {

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
		// welcome message with regex \n to have a new line and keep code D.R.Y
		System.out.println("Hello! Welcome to the CircleArea,\nwhere this program will calculate the area of a circle with any given radius!");
		
		// line for separation
		System.out.println("----------------------------------------------------------------------------");
	}
	
	/**
	 * Calculation method where the program gets the user input and used a scanner to do so and initialize the scanner as a double variable for 
	 * shorter code. then use math library and logic to get the end result.
	 */
	
	public static void calculation() {
		// message prompt to get the user input.
		System.out.println("Enter in a radius for this program to calculate the area of the circle:");
		
		// initializing a new scanner with the input to be a double, scanning the next input in the console for the double  for the radius all in one line.
		double radius = new Scanner(System.in).nextDouble();
		
		// square roots the radius with math pow and what power I want to use, in this case 2 for being squared. Then set it to a variable
		double radiusSquared = Math.pow(radius, 2);
		
		// the final step is to multiple the radiusSqaured with pi with the math helper.
		double areaOfCircle = ((Math.PI * radiusSquared));
		
		// clever display for the result
		System.out.println("You entered the radius of: " +  radius + " with the area calculated to be: " +  areaOfCircle);
	}

}
