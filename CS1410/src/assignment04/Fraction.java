package assignment04;

/**
 * This class takes a long value as an input and have a fraction be outputed and/or with the appropriate 
 * math operations with the fractions.
 *
 * @author  Henry Doan
 * @version February 7th, 2017
 */
public class Fraction {
	// private constructors as longs to represents the top and bottom nummber of a fraction
	private long numerator;
	private long denominator;
	
	/**  
	 * Application entry point.  This is where  
	 * execution starts.  This application allows  
	 * a user to select make and manipulate fractions
	 * with some operations to the console.  
	 *  
	 * @param args (not used)  
	 */ 
	
	public static void main(String[] args) {

	}
	
	/**  
	 * A getter to return the numerator.
	 * 
	 * @return   numerator a long number to represent the top number of a fraction
	 */ 
	public long getNumerator() {
		return numerator;
	}
	
	/**  
	 * A getter to return the denominator.
	 * 
	 * @return   denominator a long number to represent the bottom number of a fraction
	 */ 
	public long getDenominator() {
		return denominator;
	}
	
	/**  
	 * A setter or constructor to set the denominator from d and the numerator from n.
	 * N and D are long numbers that are from the parameters and are the input for the
	 * user to have as a numerator and denominator for the fraction
	 * 
	 * @param long n a long type number to represent the numerator from the user input.
	 * @param long d a long type number to represent the denominator from the user input.
	 */ 
	public Fraction (long n, long d) {
		
		long greatestCommonDivisor = n;
		long remainder = d;

	    while (remainder != 0) {
	        long temp = remainder;
	        remainder = greatestCommonDivisor % remainder;
	        greatestCommonDivisor = temp;
	    }
	    
		numerator = n / greatestCommonDivisor;
		denominator = d /greatestCommonDivisor;
		
		// if the denominator is negative then negative both the numerator and denominator
		
		if (denominator < 0) {
			numerator = -numerator;
			denominator = -denominator;
		}
		
	}
	
	/**  
	 * A setter or constructor to set the numerator and denominator. It takes in a numerator
	 * and then turns the number into a fraction with a 1 as the denominator. The name
	 * of the method is the same as the one above but this works because it takes in 
	 * different parameters and this is called overload.
	 * 
	 * @param long n a long type number to represent the numerator from the user input.       
	 */ 
	public Fraction (long n) {
		numerator = n;
		denominator = 1;
	}
	
	/**  
	 * Getting the result to display as a string .
	 * 
	 * @return   a string of the numerator over the denominator.
	 */ 
	public String toString () {
		return numerator + "/" + denominator;
	}
	
	/**  
	 * Getting the result to display as a double .
	 * 
	 * @return   a double of the numerator divided by the denominator.
	 */ 
	public Double toDouble () {
		double doubleValue = ( (double) this.numerator / (double) this.denominator);
		return doubleValue;
	}
	
	/**  
	 * A method that takes in a fraction param and return the result when the fractions are
	 * Multiplied.
	 * 
	 * @param Fraction rightHandSide this is a custom object that is a fraction
	 * @return multiplyResult the answer of the fractions multiplied out.
	 */ 
	public Fraction multiply (Fraction rightHandSide) {
		// Create a variable to hold the result
	    Fraction multiplyResult;  

	    // Build a new Fraction object - send the products to the constructor.
	    multiplyResult = new Fraction (this.numerator * rightHandSide.numerator,
	                           this.denominator * rightHandSide.denominator);

	     // Pass the resulting fraction back to the caller.
	     return multiplyResult; 
	}
	
	/**  
	 * A method that takes in a fraction param and return the result when the fractions are
	 * Divided.
	 * 
	 * @param Fraction rightHandSide this is a custom object that is a fraction
	 * @return divideResult the answer of the fractions divided out.
	 */ 
	public Fraction divide (Fraction rightHandSide) {
		// Create a variable to hold the result
	    Fraction divideResult;  

	    // Build a new Fraction object - send the products to the constructor.
	    divideResult = new Fraction (this.numerator * rightHandSide.denominator,
	                           this.denominator * rightHandSide.numerator);

	     // Pass the resulting fraction back to the caller.
	     return divideResult; 
	}
	
	/**  
	 * A method that takes in a fraction param and return the result when the fractions are
	 * added.
	 * 
	 * @param Fraction rightHandSide this is a custom object that is a fraction
	 * @return addResult the answer of the fractions added.
	 */ 
	public Fraction add (Fraction rightHandSide) {
		// Create a variable to hold the result
	    Fraction addResult;  

	    if (this.denominator == rightHandSide.denominator) {
	    // Build a new Fraction object - send the products to the constructor.
	    		addResult = new Fraction (this.numerator + rightHandSide.numerator,
	                           this.denominator);
	    } else {
	    		addResult = new Fraction ((this.numerator * rightHandSide.denominator) + (rightHandSide.numerator * this.denominator),
                    (this.denominator * rightHandSide.denominator));
	    }
	     // Pass the resulting fraction back to the caller.
	     return addResult; 
	}
	
	/**  
	 * A method that takes in a fraction param and return the result when the fractions are
	 * subtracted.
	 * 
	 * @param Fraction rightHandSide this is a custom object that is a fraction
	 * @return subtractResult the answer of the fractions subtracted.
	 */ 
	public Fraction subtract (Fraction rightHandSide) {
		// Create a variable to hold the result
	    Fraction subtractResult;  

	    if (this.denominator == rightHandSide.denominator) {
	    // Build a new Fraction object - send the products to the constructor.
	    		subtractResult = new Fraction (this.numerator - rightHandSide.numerator,
	                           this.denominator);
	    } else {
	    		subtractResult = new Fraction ((this.numerator * rightHandSide.denominator) - (rightHandSide.numerator * this.denominator),
                    (this.denominator * rightHandSide.denominator));
	    }
	     // Pass the resulting fraction back to the caller.
	     return subtractResult; 
	}
}
