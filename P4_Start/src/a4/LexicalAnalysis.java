package a4;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

/**
 * This class opens a file of query words, then counts the occurrences of each query
 * word in two comparison documents. The relative frequency of each query word is shown
 * as a bar chart followed by the exact percentage of time the query occurs. 
 * @author David Johnson
 *
 */
public class LexicalAnalysis {

	/**
	 * Drives the analysis program. Main should have a user select two texts and then 
	 * loop over a query file, printing the relative frequency of each query.
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override public void run() {
				System.out.println(cleanToken("hi!.asdf,ad'\""));
				// Open a file chooser.
				JFileChooser chooser = new JFileChooser();

				// Prompt the user for a file
				System.out.println("Select the first text");
				File file1 = fileChooser(chooser);

				// Prompt the user for a second file
				System.out.println("Select the second text");
				File file2 = fileChooser(chooser);

				// Do not proceed if either file choice was cancelled.
				if (file1 != null && file2 != null) {
					// Look in the project folder for a queries file.
					String filename = "queries.txt";
					// Get the file
					File queryFile = new File(filename);
					// Declare a Scanner for use
					Scanner fs = null;
					try {
						fs = new Scanner(queryFile);
					} catch (FileNotFoundException e) {
						// Say something bad has happened and quit if the query file doesn't work.
						System.out.println("ERROR: File " + queryFile.getName() + " does not exist.");
						System.exit(0);
					}
					// If we made it here, read the queries and analyze the frequency
					while (fs.hasNext()) {
						// Get the query word
						String query = fs.next();
						System.out.println("Comparing usage of " + query);

						// Get the percentage of words that are query in file 1.
						double percent1 = analyzeFile(file1,query);
						String chart = makeBar(percent1, '1');
						System.out.println(chart + " " + String.format( "%.2f",percent1) + "%");

						// Get the percentage of words that are query in file 2.
						double percent2 = analyzeFile(file2,query);
						String chart2 = makeBar(percent2, '2');
						System.out.println(chart2 + " " + String.format( "%.2f",percent2) + "%");
					} // no more tokens
				} // both files were chosen
				else {
					System.out.println("A file was not chosen");
				}
			} // main
		}
	);}
	
	/**
	 * Given a JFileChooser, use it to ask the user for a file.
	 * @param chooser
	 * @return Either a File object or null, if nothing chosen.
	 */
	public static File fileChooser(JFileChooser chooser) {         
		File f = null;
		int choice = chooser.showOpenDialog(chooser);
		if ( choice == JFileChooser.APPROVE_OPTION) {
			f = chooser.getSelectedFile();
			return f;
		}
		return null;
	}
	
	/**
	 * Given a file, count how many occurrences of key are in file. A token matches
	 * the key if the cleaned token (see description of cleanToken) matches an
	 * all upper-case version of key.
	 * @param file 
	 * @param key a string of 'a'-'z' or 'A'-'Z' letters
	 * @return the percentage of tokens in file that match key, or quits if file
	 * is not a valid file.
	 * 
	 */
	public static double analyzeFile( File file, String key) {
		int countInWords = 0;
		int TotalWords = 0;
		try {
			Scanner s = new Scanner(file);
			while (s.hasNext()) {
				String token = s.next().toLowerCase();
				token = cleanToken(token);
				if (token.equals(key.toLowerCase())) {
					countInWords ++;
				}
				TotalWords ++;
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("Something is wrong in the analyzeFile");
			System.exit(0);
			
		}
		return computePercentage(countInWords, TotalWords);
	}

	/**
	 * Given a count of words found for key and the total number of words in a file,
	 * computes the percentage of words that is key, according to the matching rules.
	 * @param key is the count of words that match the query word
	 * @param words is the count of words in the file.
	 * @return returns the percentage in a range from 0.0-100.0, so retaining fractional values.
	 */
	public static double computePercentage(int key, int words) {
		double percentageOfWord = ((double) key / words) * 100;
		return percentageOfWord;
	}
	
	/**
	 * Given a non-negative number pos, and character c, produces a string with 
	 * round(pos-1) number of '+' followed by c. 
	 * If pos is zero, then produce a string with just c in it (this looks the
	 * same as a pos of 1).
	 * @param pos
	 * @param c
	 * @return a string representing a bar chart for the value in pos.
	 */
	public static String makeBar(double pos, char c) {
		String emptyString = "";
		if (Math.round(pos - 1) == 0) {
			emptyString = "" + c;
			return emptyString;
		} else {
			int i = 0;
			while (i < Math.round(pos - 1) - 1) {
				i++;
				emptyString = emptyString + "+";
			}
			return emptyString + c;
		}
	}
	
	/**
	 * cleanToken tries to clean up a token from a text file. The text file may
	 * have punctuation we want to ignore, and we will remove it according to the
	 * following rules. These rules are not perfect, but they should be followed exactly.
	 * 
	 * Punctuation counts as a . ? , ! " or ' character. The character ' is written
	 * as '\'' since ' helps define the boundary of the character. The \ tells the
	 * compiler that the letter following is a special character.
	 * 
	 * The rule for cleaning up a token is that we will remove 
	 *   - up to one punctuation character from the front of the token (to handle "hello situations)
	 *   - up to two punctuation characters from the end of the token (to handle it?" kind of situations)
	 *   - turn the remaining characters upper-case.
	 * 
	 *  I recommend writing helper methods to handle different cases.
	 * @param word token from the source file.
	 * @return the word with the punctuation removed according to the rules and uppercase.
	 */
	public static String cleanToken(String word) {
		String output = word;
		output = output.replaceAll("[.?,!\"']", "");
		return output;
	}
	
}
