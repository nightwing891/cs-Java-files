package assignment04;

public class Fraction {
	private int numerator;
	private int denominator;
	
	public static void main(String[] args) {

	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public Fraction (int n, int d) {
		numerator = n;
		denominator = d;
		
//		System.out.println("Fraction constructor called with " + n + " and " + d + ".");
	}
	
	public String toString () {
		return numerator + "/" + denominator;
	}
	
	public Fraction multiply (Fraction rightHandSide) {
		// Create a variable to hold the result
	    Fraction multiplyResult;  

	    // Build a new Fraction object - send the products to the constructor.
	    multiplyResult = new Fraction (this.numerator * rightHandSide.numerator,
	                           this.denominator * rightHandSide.denominator);

	     // Pass the resulting fraction back to the caller.
	     return multiplyResult; 
	}
	
	public Fraction divide (Fraction rightHandSide) {
		// Create a variable to hold the result
	    Fraction divideResult;  

	    // Build a new Fraction object - send the products to the constructor.
	    divideResult = new Fraction (this.numerator * rightHandSide.denominator,
	                           this.denominator * rightHandSide.numerator);

	     // Pass the resulting fraction back to the caller.
	     return divideResult; 
	}
}
