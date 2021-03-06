package lab3;

public class Lab3 {

	/**
	 * Adds up the series of numbers from 0 to topNumber.
	 * @param topNumber
	 * @return the summed series.
	 */
	public static int sumFrom0ToNumber(int topNumber) {
		int currentNumber = 0;
		int sum = 0;
		while (currentNumber <= topNumber) {
			 sum += currentNumber;
			 currentNumber++;
			 System.out.println(currentNumber);
		}
		// Change the return
		return sum;
	}
	/**
	 * This code displays the characters in a string.
	 * Convert it to count the number of 'a' or 'A' character in the string.
	 * @param word
	 * @return the number of 'a' or 'A' characters in word.
	 */
	public static int countA(String word) {
		System.out.println(word);
		int letterPosition = 0;
		int counter = 0;
		while (letterPosition < word.length()) {
			if (word.charAt(letterPosition) == 'A' ){
				counter++;
				letterPosition++;
			};
			if (word.charAt(letterPosition) == 'a' ){
				counter++;
				letterPosition++;
			};
			letterPosition++;
		}
		// change the return to the count of a letters.
		return counter;
	}
	
	/**
	 * Given a word, take the first half of the word and put it on the 
	 * end.
	 * @param word
	 * @return Returns the new word with the front moved to the back.
	 */
	public static String splitFlipWord(String word) {
		// Add code and change the return
		String stringCopy = word.substring(0, word.length());
		String front = word.substring(0, word.length() / 2);
		String back = word.substring(word.length() / 2, word.length()) ;
		return back + front;
	}
	
	public static void main(String[] args) {
		// Test the sum method
		System.out.println("The sum from 0 to 5 is " + sumFrom0ToNumber(5));
		// Test the countA method
		System.out.println("The a/A count is: " + countA("A happy anaconda"));
		// Test the splitFlip method
		String startWord = "David";
//		System.out.println("Splitflip of " + startWord + " is " + splitFlipWord(startWord));
	}

}
