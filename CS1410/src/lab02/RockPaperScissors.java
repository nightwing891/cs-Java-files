package lab02;

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// Create two String variables, one named playerGuess and the other
	//   named computerGuess, set them equal to empty strings:  ""
		String playerGuess = "";
		String computerGuess = "";

	// Make a random integer between [0...2].  If the random integer is a
	//   0, set the computer guess to "rock", if it's a 1, set the computer
	//   guess to "paper", otherwise set the computer guess to "scissors".
		int randomValue = (int) (Math.random() * 3); 
		if (randomValue == 0) {
			computerGuess = "rock";
		} else if (randomValue == 1) {
			computerGuess = "paper";
		} else {
			computerGuess = "scissors";
		}
		
//		System.out.println(randomValue);
//		System.out.println(computerGuess);

	// Using a Boolean flag, create an input loop that asks the player to enter
	//   their guess.  Don't allow the program to proceed until the player
	//   enters either "rock", "paper", or "scissors".
		Scanner in = new Scanner(System.in);  
		String input = ""; 

		boolean userInputIsOK = false;

		while ( ! userInputIsOK )
		{
			System.out.print ("Enter rock, paper, or scissors: ");
			
			input = in.next();
		    
			if (input.equals("rock") || input.equals("paper") || input.equals("scissors"))
		        userInputIsOK = true;
		    
			if (input.equals("rock")) {
				playerGuess = "rock";
			} else if (input.equals("paper")) {
				playerGuess = "paper";
			} else if (input.equals("scissors"))  {
				playerGuess = "scissors";
			} 
			
			System.out.println(playerGuess);
			
		}

	// Print out the computer's guess:  "I picked rock.", etc.
		System.out.println("I picked " + computerGuess);
		
	// Write a few 'if' statements to determine the result of the game and
	//   print out the winner:  "I win",  "You win", "It's a tie"
	// If the strings are the same, its a tie.
	//  else if the player picks "rock" and the computer picks "scissors", the player wins,
	//  else if ... (etc.)
		if (playerGuess.equals("rock") && computerGuess.equals("scissors")) {
			System.out.println("You win");
		} else if (playerGuess.equals("rock") && computerGuess.equals("paper")) {
			System.out.println("I win");
		} else if (playerGuess.equals("rock") && computerGuess.equals("rock")) {
			System.out.println("its a tie");
		} else if (playerGuess.equals("scissors") && computerGuess.equals("scissors")) {
			System.out.println("It a tie");
		}  else if (playerGuess.equals("scissors") && computerGuess.equals("paper")) {
			System.out.println("You win");
		} else if (playerGuess.equals("scissors") && computerGuess.equals("rock")) {
			System.out.println("You lose");
		} else if (playerGuess.equals("paper") && computerGuess.equals("paper")) {
			System.out.println("It's a tie");
		} else if (playerGuess.equals("paper") && computerGuess.equals("scissors")) {
			System.out.println("You lose");
		} else if (playerGuess.equals("paper") && computerGuess.equals("rock")) {
			System.out.println("You win");
		}
		
	}

}
