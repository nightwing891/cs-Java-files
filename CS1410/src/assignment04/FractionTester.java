package assignment04;

public class FractionTester {

	public static void main(String[] args) {
		System.out.println("Fraction tester: \n");
		
		Fraction f = new Fraction (2, 3);
		Fraction g = new Fraction (1, 4);
		Fraction h = new Fraction (5, 1);
		Fraction l = new Fraction (50, -100);
		Fraction a = new Fraction (12);
		Fraction b = new Fraction (2, 4);
		
		Fraction productOfFAndG = f.multiply(g);
		Fraction divisionOfGAndf = g.divide(f);
		Fraction productOfHAndF = h.multiply(f);
		Fraction divisionOfHAndH = h.divide(h);
		
		Fraction addGandB = g.add(b);
		Fraction subtractBandG = b.subtract(g);
		Fraction subtractBandF = b.subtract(f);
		
		System.out.println("Fraction " + l + " contains: " + l);
		System.out.println("Fraction " + a + " contains: " + a);
		System.out.println("Fraction " + f + " contains: " + f);
		System.out.println("Fraction " + g + " contains: " + g);
		System.out.println("Fraction " + h + " contains: " + h + "\n");
		
		System.out.println(f + " denominator is: " + f.getDenominator());
		System.out.println(g + " numerator is: " + g.getNumerator());
		System.out.println(h + " numerator is: " + h.getNumerator() + h + " denominator is: " + h.getDenominator() + "\n");

		System.out.println("The multiple of " + f + "and" + g +" is: " + productOfFAndG);
		System.out.println("The division of " + g + "and" + f + " is: " + divisionOfGAndf);
		System.out.println("The multiple of " + h + "and" + f + " is: " + productOfHAndF + " The division of " + h + " is: " + divisionOfHAndH + "\n");
	
		System.out.println("The addition of " + g + "and" + b + " is: " + addGandB);
		System.out.println("The subtraction of " + b + "and" + g + " is: " + subtractBandG);
		System.out.println("The subtraction of " + b  + "and" + f + " is: " + subtractBandF + "\n");
		
		System.out.println("This is the double for the " + f + " fraction: " + f.toDouble());
		System.out.println("This is the double for the " + b.toString() + " fraction: " + b.toDouble() + "\n");
	}

}
