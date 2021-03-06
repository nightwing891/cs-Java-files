package a6;

/**
 * A collection of methods for the A6: Arrays and Search of CS 1410. An assortment of 
 * methods that does multiple function and has different purposes with array manipulations.
 * 
 * @author Henry Doan
 */

public class ArrayLibrary {
	
	public static void main(String[] args) {
		int[] arr = new int[5];
		int[] arryNum = { 2, 3, 4, 5, 4, 4, 3 };
		int[] integers = { 2, -9, 87, 6, 0, 12, -3 };
		int[] lost = { 4, 8, 15, 16, 23, 42 };
		String[] words = { "the", "quick", "brown", "fox" };
		char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 };
		int[] duplicates = { 4, 2, 3, 5, 4, 4, 3, 2, 9, 1, 3, 4, 5, 2, 1, 5 };
		int[] test= { 0,0,0,0};
//		System.out.println(clear(integers));	 
//		System.out.println(reverseFill(arr, 2));
//		System.out.println(arrayToString(lost));
//		System.out.println(containsDuplicate(words));
//		System.out.println(average(lost));
//		System.out.println(frequencyCount(test));
//		System.out.println(makeFilledArray(5));
		
//		System.out.println(sequentialSearchCount(arryNum, 100));
//		System.out.println(binarySearchCount(arryNum, 100));
//		
		System.out.println(performanceTestSequential(1000, 100));
		System.out.println(performanceTestBinary(1000, 100));
	}
	
	/**
	 * This method takes in a parameter of an integer array called clearArr and set 
	 * all the values of each array element to 0. The logic takes a for loop and set
	 * an integer variable of i and set it initaily to 0 and as i is less than the 
	 * length of the clearArr , then increment by 1 as long as the condition is met.
	 * inside the for loop, the clearArr array element , in the position of i gets 
	 * reassigned as 0. Then return the clearArr with the new values in it. This method
	 * does not show in the console, but does show as a debugger reference number 
	 * so to see the method in action, we would have to see it in the Debugger. 
	 * 
	 * @param clearArr  an integer array
	 * @return  clearArr with the new reassigned elements of 0
	 */
	
	// output is in the debugger 
	
	public static int[] clear(int[] clearArr) {
	    for(int i = 0; i < clearArr.length; i++ ){
	    		clearArr[i] = 0; 
	    }
		return clearArr;
	}
	
	/**
	 * This method takes and integer array and an integer value of N and set the 
	 * last array element value to N and then count backwards by 1 to the left until 
	 * the size of the integer array , reverseput is met. The logic takes a for loop
	 * and set an integer variable of i and set it initaily to 0 and as i is less 
	 * than the length of the integer array reverseput , then increment by 1 as long as 
	 * the condition is met. In the for loop, the array element at the end of the array
	 * subtract by the i while it is being incremented each time, and reassign the 
	 * element with N and then N incremented by one. Then return the array with the new
	 * assigned element. This method does not show in the console, but does show as 
	 * a debugger reference number so to see the method in action, we would have to 
	 * see it in the Debugger. 
	 * 
	 * @param reverseput  an integer array
	 * @param N           and integer to set the value of the last array element
	 * @return reverseput with the new elements be reassigned to the value of the last array
	 *          element to n and then increment the left values by n plus one
	 */
	
	// output is in the debugger 
	
	public static int[] reverseFill(int[] reverseput, int N) {
	    for (int i = 0; i < reverseput.length; i++) {
	    		reverseput[( reverseput.length - 1) - i] = N++;
	    }
		return reverseput;
	}
	
	/**
	 * This method takes and integer array of arrToStringArr turns the array into
	 * a string. I have set up a string builder to built a new string called builder
	 * Then the logic takes a for loop and set an integer variable of i and set it 
	 * initaily to 0 and while i is less than the length of the integer array, 
	 * arrToStringArr, then increment by 1 as long as the condition is met. In the
	 * for loop, the array the elements of the array is then appended to the string
	 * builder of builder and while the position element is incrementing in the for
	 * loop followed by a comma at the end. With this logic, the last element is followed
	 * by a comma as well, which is unnessary to print. The new string variable takes 
	 * the builder and turns it into a string and set as a variable. The newerString
	 * takes away the last comma I mention above to make things logical by taking the
	 * substring at the end of the string token and remove it. Then the Final String 
	 * takes the newerString and wrap it in brackets. Then return the array as a string.
	 * and prints it in the console.
	 * 
	 * @param arrToStringArr  an integer array
	 * @return FinalString  as the newerString is wrapped in brackets
	 */

	public static String arrayToString(int[] arrToStringArr) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < arrToStringArr.length; i++ ) {
		    builder.append( arrToStringArr[i] + "," );
		}
		
		String newString = builder.toString();
		String newerString = newString.substring(0, newString.length()-1);
		String FinalString = "{" + newerString + "}";
		return FinalString;
	}
	
	/**
	 * This is a boolean method that returns true if there is a duplicate array element
	 * and returns false if there are no duplicates. This takes in a String array
	 * of DuplicateArrCheck and checks all of the elements. The logic takes a for loop
	 * and set an integer variable of i and set it initaily to 0 and as i is less 
	 * than the length of the integer array duplicateArrCheck, then increment by 1 as 
	 * long as the condition is met. There is another for loop inside the for loop to
	 * set an integer variable h to i on the next place of position as h is less than
	 * the string array length and then increment plus one. This is for looking at
	 * as i is at one position h is at another position and and checks the rest of the
	 * array and compares it with the i position element. Checks if the element at i and
	 * at h are equal the return true. Else on the out side return false. This is printed
	 * in the console.
	 * 
	 * @param DuplicateArrCheck  a string array to do the logic. 
	 * @return true if the elements in the array match and false if it does not.
	 */
	
	public static boolean containsDuplicate(String[] DuplicateArrCheck) {
		for (int i = 0; i < DuplicateArrCheck.length; i++) {
		    for ( int h = i + 1; h < DuplicateArrCheck.length; h++) {
		        if (DuplicateArrCheck[h] == DuplicateArrCheck[i]){ 
		            return true;
		        }
		    }
		}
		return false;
	}
	
	/**
	 * This method takes an integer array and takes the average of the array of AverageArr.
	 * we first set a sum integer to 0 and a double type of average. The logic takes a for 
	 * loop and set an integer variable of i and set it initaily to 0 and as i is less 
	 * than the length of the integer array AverageArr, then increment by 1 as long as 
	 * the condition is met. In the for loop, the sum gets reassigned as the whatever
	 * the sum is at the time added the next element in the array. The the Average is
	 * the reassigned to a double value of all of the sum of the element and divided
	 * by how many are in the array by array.length. Then return the average then 
	 * prints it in the console in the main.
	 * 
	 * @param AverageArr  an integer array 
	 * @return average    an average of the elements in the integer array.
	 */
	
	public static double average(int[] AverageArr) {
	    int sum = 0;
	    
	    double average;
	    
	    for(int i = 0; i < AverageArr.length; i++){
	    		sum = sum + AverageArr[i];
	    }
		average = (double)sum/AverageArr.length;
		
		return average;
	}
	
	/**
	 * This method takes an integer array of dupArr and checks to see the frequency
	 * of each number in the array. First we make to arrays, one being the array of
	 * the counter and has the counter start off at 0 for numbers representing 0-9
	 * The logic takes a for loop and set an integer variable of i and set it initaily
	 * to 0 and as i is less than the length of the integer array dupArr, then increment 
	 * by 1 as long as the condition is met. In the for loop,the counter method then gets 
	 * its element in each slot of the dupArr element then increment it by 1 to
	 * count each times a certain number shows up. then the next for loop with the logic similar
	 * to the above but as i is less than counter length, all of its element is then
	 * pushed into the array and then return the array. This method does not show in the console, but does show as 
	 * a debugger reference number so to see the method in action, we would have to 
	 * see it in the Debugger.
	 * 
	 * @param dupArr  an integer array 
	 * @return newArray  a new array with the counter of frequent elements in the array.
	 */
	
	// output is in the debugger
	
	public static int[] frequencyCount(int[] dupArr) {
		int[] counter = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] newArray = new int[counter.length];
		for (int i = 0; i < dupArr.length; i++) {
		    counter[dupArr[i]]++;
		}

		for (int i = 0; i < counter.length; i++) {
		    newArray[i] = counter[i];
		}

		return newArray;
	}
	
	/**
	 * This method takes an integer and the build an array with the number being the
	 * length. The integer variable makes a new array of the number size of the array 
	 * Then the logic takes a for loop and set an integer variable of i and set it 
	 * initaily to 0 and as i is less than the length of the integer array intArray, 
	 * then increment by 1 as long as the condition is met. In the for loop, the array
	 * get populated with i as i is incremented with the for loop logic. Then return
	 * the int array with the new populated array elements. This method does not show 
	 * in the console, but does show as a debugger reference number so to see the method 
	 * in action, we would have to see it in the Debugger. 
	 * 
	 * @param arrSize  an integer for the array to be made with the length being the parameter
	 * @return intArray  a array populated with number incrementing until the arrSize is met.
	 */
	
	// output is in the debugger
	
	public static int[] makeFilledArray(int arrSize) {
		int[] intArray = new int[arrSize];
		
		for (int i = 0; i < intArray.length; i++){
	    	   intArray[i] = i;
	    }
		return intArray;
	}
	
	public static int sequentialSearchCount(int[] vals, int key) {
		int counter = 0;
		
		for (int currentIndex = 0; currentIndex < vals.length; currentIndex++) { 
			if (vals[currentIndex] == key) {
				counter += 1;
				break;
			}
			counter += 1;
		} 
		return counter;
	}
	
	public static int binarySearchCount(int[] vals, int key) {
		int counter = 0;
		int lo = 0; 
		int hi = vals.length - 1; 
		
		while (lo <= hi) {
			int arrayLength = hi + 1 - lo; 
			int mid = arrayLength / 2 + lo; 
			
			if (vals[mid] == key){
				counter += 1;
				return mid; 
			}
			
			if (vals[mid] < key) {
				counter += 1;
				lo = mid + 1;
			} else { 
				hi = mid - 1;
			}
		} 
		return counter;
	}
	
	public static double performanceTestSequential(int arrSize, int repetitions) {
		int[] intArray = makeFilledArray(arrSize);
		int key = (int)(Math.random() * intArray.length);
		
		int sum = 0;
		int counter = 0;
		
		for (int i = 0; i < repetitions; i++){
	    	   sum += sequentialSearchCount(intArray, key);
	    	   counter ++;
	    }
		return (double) sum / counter;
	}
	
	public static double performanceTestBinary(int arrSize, int repetitions) {
		int[] intArray = makeFilledArray(arrSize);
		int key = (int)(Math.random() * intArray.length);
		
		int sum = 0;
		int counter = 0;
		
		for (int i = 0; i < repetitions; i++){
	    	   sum += binarySearchCount(intArray, key);
	    	   counter ++;
	    }
		return (double) sum / counter;
	}	
	
	
}
