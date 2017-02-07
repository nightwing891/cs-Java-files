package assignment04;

public class FractionTester {

	public static void main(String[] args) {
		System.out.println("Fraction tester: \n");
		
		Fraction f = new Fraction (2, 3);
		Fraction g = new Fraction (1, 4);
		Fraction h = new Fraction (5, 1);
		
		Fraction productOfFAndG = f.multiply(g);
		Fraction divisionOfGAndf = g.divide(f);
		Fraction productOfHAndF = h.multiply(f);
		Fraction divisionOfHAndH = h.divide(h);
		
		System.out.println("Fraction f contains: " + f);
		System.out.println("Fraction g contains: " + g);
		System.out.println("Fraction h contains: " + h + "\n");
		
		System.out.println("F's denominator is: " + f.getDenominator());
		System.out.println("G's numerator is: " + g.getNumerator());
		System.out.println("H's numerator is: " + h.getNumerator() + " H's denominator is: " + h.getDenominator() + "\n");

		System.out.println("The multiple of f and g is:  " + productOfFAndG);
		System.out.println("The division of g and f is: " + divisionOfGAndf);
		System.out.println("The multiple of h and f is: " + productOfHAndF + " The division of h is: " + divisionOfHAndH + "\n");
	}

}
