package assignment02;

/**
 * This program sees the lowest possible integer a hailstone cannot produce.
 * 
 * this program combines the concepts of the first 3 parts of the assignment into solving this problem.
 * I have solved this problem by a modified optimization loop and comparison logic and got the answer to be
 * 113383. This means that the int type number has a limit of how items can be stored within a range for it to
 * be accurate. when it is outside the range it will not be the same number and will be then truncated to fit the
 * range it has when it over flows and this program took for my machine about 138 - 150 milliseconds on my computer to
 * run and all of this incrementing and logic is happening so fast, its more that the speed we can think
 * so that is why it seems to never run but it does because of binary representation.
 * 
 * @author  Henry Doan
 * @version January 24, 2017
 */

public class Limit {

	public static void main(String[] args) {
		calculation();
	}
	
	public static void calculation() {
		int N = 1;
        int nextNum = N;
        
        // starting the nano timer which is in nano seconds to be more accurate 
     	final long start = System.nanoTime();
     	
     	// break reference
     	finshed: {
	        // while N is less than a billion
	        while (N < 1_000_000_000) {
	        		
	        		// assigning the starting number to be the next integer
	        		N = nextNum; 
	        		
	        		// as long as it is positive do the hailstone
	            while (N != 1) { 
	            		// if N is even
	                if ( N % 2 == 0) {
	    					// do the calculation
	    					N = N / 2;
	
		    				// else it is odd
		    			} else {
		    				// do the calculation
		    				N = ((N * 3) + 1);	
		    			}
	                
	                // if it is negative then it fails
	                if (N < 0) {
	                    System.out.println("The smallest number that doesn't have its Hailstone series is: " + nextNum);
	                    // break outside all loops and go to the next line of code
	                    break finshed;
	                }
	            }
	            
	            // increment next N
	            nextNum++; 
	        }
     	}
        
        
        // end the time 
        final long end = System.nanoTime();

		// output the results and message
		System.out.println("The loop has finshed \n");
		
		// do some math to convert the nano seconds into milliseconds
		System.out.println("The loop took: " + ((end - start) / 1_000_000) + " milliseconds to complete");
	}

}
