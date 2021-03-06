package m1;

/**
 * Brand object with everything a brand has and methods
 * that you can call from brand.
 * 
 * @author Henry Doan
 * @version October 4, 2018
 */
public class Brand implements  Comparable<Brand>{
	// what all brands have
	private String name;
	private int registrationNumber;
	
	/**
	 * set the brand name and number to the incoming information.
	 * 
	 * @param name -- string of the incoming name for the brand.
	 * 		  registrationNumber -- integer of the incoming registration number for the brand.
	 */
	public Brand(String name, int registrationNumber) {
		this.name = name;
		this.registrationNumber = registrationNumber; // trade mark registration number
	}
	
	/**
	 * Returns the name of this brand.
	 * 
	 * @return name -- string of the name of the brand.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the registration number of this brand.
	 * 
	 * @return registrationNumber -- integer of the registration number of the brand.
	 */
	public int getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * An override method that will have a string of the brand.
	 * 
	 * @return a string of the brand name and registration number.
	 */
	@Override
	public String toString() {
		return String.format("%-10s#%d", name, registrationNumber);
	}

	/**
	 * An override compare two brands together with ascending
	 * order of the brands names.
	 * 
	 * @return a number of order that the current brand is base on the compared to brand.
	 */
	@Override
	public int compareTo(Brand o) {
		// get the names of the brands
		String a = this.getName();
		String b = o.getName();
		
		// compare the names
		int compare = a.compareToIgnoreCase(b);

		// return the order
		return compare;
	}	

	/**
	 * A helper method that converts the brand name to upper case.
	 * 
	 */
	public void uppercaseName() {
		name = name.toUpperCase();
	}
}
