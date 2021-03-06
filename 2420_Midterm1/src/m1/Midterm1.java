package m1;

import java.util.Arrays;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;


/**
 * Creating methods and data structures for brands.
 * 
 * @author Henry Doan
 * @version October 4, 2018
 */
public class Midterm1 {	
	
	public static void main(String[] args) {
		Brand[] brands = {
			new Brand("Nike", 1441334),	
			new Brand("adidas", 3686084),	
			new Brand("Microsoft", 1200236),	
			new Brand("lenovo", 3226026),
			new Brand("SAMSUNG", 3503660),	
			new Brand("nook", 4286950),
			new Brand("IBM", 2183815)
		};
		
		StdOut.println("Brands:");
		StdOut.println("=======");
		printBrands(brands);
		
		
		// = = = =  Part 1	= = = = 	
		//sort the brands
		Arrays.sort(brands); 
		
		// print the brands
		StdOut.println("Brands by name:");
		StdOut.println("===============");
		printBrands(brands);
		

		// = = = =  Part 2a  = = = = 	
		// create a new stack of brand
		Stack<Brand> s = new Stack<Brand>();
		
		// push all the brands from the array into the stack
		for (Brand b : brands) {
			s.push(b);
		}
		
		
		// = = = =  Part 2b  = = = = 
		// create a new brand stack
		Stack<Brand> brandStack = new Stack<Brand>();
		
		// push items into the brand stack
		for (Brand b : brands) {
			// if the brand name is are 6 characters or shorter
			if ( b.getName().length() <= 6 ) {
				// check to see if the first letter is upper case
				if (b.getName().charAt(0) == b.getName().toUpperCase().charAt(0) ) {
					// upper case the letter with a helper method
					b.uppercaseName();
				}
				brandStack.push(b);
			}
		}
		
		StdOut.println("Names in reverse order:");
		StdOut.println("=======================");
		
		printBrandStack(brandStack);

	}

	/** 
	 * Prints all the elements of array brands side by side, separated by a single blank.
	 * @param brands
	 */
	private static void printBrands(Brand[] brands) {
		for(Brand c : brands) {
			StdOut.println(c);
		}	
		System.out.println();
	}
	
	/** 
	 * A helper method that prints all the elements of the stack brands 
	 * side by side, separated by a single blank.
	 * 
	 * @param s a incoming stack to print
	 */
	private static void printBrandStack(Stack<Brand> s) {
		for(Brand b : s) {
			StdOut.println(b);
		}	
		
		System.out.println();
	}
	

}
