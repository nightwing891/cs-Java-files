package a4;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

/**
 * This class opens a file of query words, then counts the occurrences of each
 * query word in two comparison documents. The relative frequency of each query
 * word is shown as a bar chart followed by the exact percentage of time the
 * query occurs.
 * 
 * @author Henry Doan
 *
 */
public class LexicalAnalysis {

	/**
	 * Drives the analysis program. Main should have a user select two texts and
	 * then loop over a query file, printing the relative frequency of each
	 * query.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

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
						// Say something bad has happened and quit if the query
						// file doesn't work.
						System.out.println("ERROR: File " + queryFile.getName() + " does not exist.");
						System.exit(0);
					}
					// If we made it here, read the queries and analyze the
					// frequency
					while (fs.hasNext()) {
						// Get the query word
						String query = fs.next();
						System.out.println("Comparing usage of " + query);

						// Get the percentage of words that are query in file 1.
						double percent1 = analyzeFile(file1, query);
						String chart = makeBar(percent1, '1');
						System.out.println(chart + " " + String.format("%.2f", percent1) + "%");

						// Get the percentage of words that are query in file 2.
						double percent2 = analyzeFile(file2, query);
						String chart2 = makeBar(percent2, '2');
						System.out.println(chart2 + " " + String.format("%.2f", percent2) + "%");
					} // no more tokens
				} // both files were chosen
				else {
					System.out.println("A file was not chosen");
				}
			} // main
		});
	}

	/**
	 * Given a JFileChooser, use it to ask the user for a file.
	 * 
	 * @param chooser
	 * @return Either a File object or null, if nothing chosen.
	 */

	/**
	 * This has a file variable of null, starting off of the file not being
	 * selected then the choice variable is defined by what the user choose.
	 * then if the choice meets the requirements, then the file becomes the
	 * selected file and we will return that file.
	 */

	public static File fileChooser(JFileChooser chooser) {
		File f = null;
		int choice = chooser.showOpenDialog(chooser);
		if (choice == JFileChooser.APPROVE_OPTION) {
			f = chooser.getSelectedFile();
			return f;
		}
		return null;
	}

	/**
	 * Given a file, count how many occurrences of key are in file. A token
	 * matches the key if the cleaned token (see description of cleanToken)
	 * matches an all upper-case version of key.
	 * 
	 * the counter in the word that is being looked for and the counter for the
	 * total words is initially set to 0. Then try to have a scanner go through
	 * the file and while it has a next token, assign all token to be lower case
	 * so all of the tokens be the same types of token and not have mixed types.
	 * The the clean token Clears up the conditions in the cleanToken method,
	 * and if the token is equals to the key that is lower cased, then add 1 to
	 * the counter in the word count in how make times it occurs. then also
	 * count the number of total words in the file. The catch method kicks you
	 * out of the program if the file is not found or if its the wrong type,
	 * with a message.
	 * 
	 * @param file
	 * @param key
	 *            a string of 'a'-'z' or 'A'-'Z' letters
	 * @return the percentage of tokens in file that match key, or quits if file
	 *         is not a valid file.
	 */

	public static double analyzeFile(File file, String key) {
		int countInWords = 0;
		int TotalWords = 0;
		try {
			Scanner s = new Scanner(file);
			while (s.hasNext()) {
				String token = s.next().toLowerCase();
				token = cleanToken(token);
				if (token.equals(key.toLowerCase())) {
					countInWords++;
				}
				TotalWords++;
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("Something is wrong in the analyzeFile");
			System.exit(0);

		}
		return computePercentage(countInWords, TotalWords);
	}

	/**
	 * Given a count of words found for key and the total number of words in a
	 * file, computes the percentage of words that is key, according to the
	 * matching rules.
	 * 
	 * @param key
	 *            is the count of words that match the query word
	 * @param words
	 *            is the count of words in the file.
	 * @return returns the percentage in a range from 0.0-100.0, so retaining
	 *         fractional values.
	 */

	/**
	 * This method makes a double variable of the percentage of words of the
	 * total found matching words out of total words. The logic is the number of
	 * found matching divided by the total number of words and then to get a
	 * decimal amount to have it Multiplied by a hundred. then have it be a
	 * double amount and return the percent.
	 */
	public static double computePercentage(int key, int words) {
		double percentageOfWord = ((double) key / words) * 100;
		return percentageOfWord;
	}

	/**
	 * Given a non-negative number pos, and character c, produces a string with
	 * round(pos-1) number of '+' followed by c. If pos is zero, then produce a
	 * string with just c in it (this looks the same as a pos of 1).
	 * 
	 * @param pos
	 * @param c
	 * @return a string representing a bar chart for the value in pos.
	 */

	/**
	 * This method adds the + symbol to the compare usage display from the logic
	 * of counter variable that is set to 0 and and while the counter is bigger
	 * than the pos -1 be rounded to the nearest whole number. -1 subtract one
	 * to not count the initial count.
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
	 * have punctuation we want to ignore, and we will remove it according to
	 * the following rules. These rules are not perfect, but they should be
	 * followed exactly.
	 * 
	 * Punctuation counts as a . ? , ! " or ' character. The character ' is
	 * written as '\'' since ' helps define the boundary of the character. The \
	 * tells the compiler that the letter following is a special character.
	 * 
	 * The rule for cleaning up a token is that we will remove - up to one
	 * punctuation character from the front of the token (to handle "hello
	 * situations) - up to two punctuation characters from the end of the token
	 * (to handle it?" kind of situations) - turn the remaining characters
	 * upper-case.
	 * 
	 * I recommend writing helper methods to handle different cases.
	 * 
	 * @param word
	 *            token from the source file.
	 * @return the word with the punctuation removed according to the rules and
	 *         uppercase.
	 */

	/**
	 * This method makes a new string output with the token from the AnalyzeFile
	 * method then reassigns the output string variable to have all of the
	 * punctuation be removed from the token. The way that is done is by regex,
	 * and have an array of the symbols we want to replace and then have the
	 * tokens that have any of the symbols in the array in regex punctuation and
	 * replace it all with a empty string which symbolizes us taking out the
	 * punctuation from the token entirely. Then return the token back with no
	 * punctuation.
	 */
	public static String cleanToken(String word) {
		String output = word;
		output = output.replaceAll("[.?,!\"']", "");
		return output;
	}

}
