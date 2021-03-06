package a4;

import java.io.File;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests required code in the LexicalAnalysis class. You should add additional
 * tests and asserts to more carefully test your code.
 * 
 * @author David Johnson & Henry Doan
 *
 */
public class TestLexicalAnalysis {

	/**
	 * Test the word count done on a simple file. The last parameter of the
	 * assert is a margin of error allowed.
	 */
	@Test
	public void testAnalyzeFilePercentage() {
		File file = new File("TestWords.txt");
		assertEquals(4.16, LexicalAnalysis.analyzeFile(file, "it"), 0.01);
	}

	/**
	 * Test the percentage computation
	 */
	@Test
	public void testComputePercentage() {
		assertEquals(10.0, LexicalAnalysis.computePercentage(10, 100), 0.0001);
		assertEquals(1.0, LexicalAnalysis.computePercentage(1, 10), 0.001);
	}

	/**
	 * Test the makeBar method
	 */
	@Test
	public void testMakeBar() {
		assertEquals("++1", LexicalAnalysis.makeBar(3, '1'));
	}

	/**
	 * Test the cleanToken method. It shows that a token with stuff before and
	 * after is cleaned up, but also that a token with too much punctuation is
	 * not fully cleaned up.
	 */
	@Test
	public void testCleanToken() {
		assertEquals("HI", LexicalAnalysis.cleanToken(".hi\"."));
		assertEquals("HI\"", LexicalAnalysis.cleanToken(".hi\".."));
		assertEquals("HI?", LexicalAnalysis.cleanToken(".hi?.."));
		assertEquals("HI,", LexicalAnalysis.cleanToken(".hi,.."));
		assertEquals("HI!", LexicalAnalysis.cleanToken(".hi!.."));
	}
}
