package csen1002.tests.task9;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task9.Task9Lexer;
import csen1002.main.task9.Task9Parser;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task9TestsBatch7 {
	
    /**
     * Parses a provided string using Task 9's grammar
     * and gets the value of the attribute "check" of the variable "s"
     *
     * @param input a string to parse
     * @return the value of the attribute "check" of the variable "s"
     */
    public static int sCheckValue(String input) {
        Task9Lexer lexer = new Task9Lexer(CharStreams.fromString(input));
        Task9Parser parser = new Task9Parser(new CommonTokenStream(lexer));
        return parser.s().check;
    }

	@Test
	public void testString1() {
		assertEquals(1, sCheckValue("10000000#01000000#00100000#00010000#00001000#00000100#00000010#00000001#00000000#00000000#00000000#00000000#00000000#00000000#00000000"));
	}

	@Test
	public void testString2() {
	    assertEquals(0, sCheckValue("00100#00010#01010#11100#00111"));
	}

	@Test
	public void testString3() {
		assertEquals(0, sCheckValue("0111010010111000#0111000101001001#0101001100011111#0101011100011111#0010011010001111#0101110000000011#0011010111111000#0101111111001010#1011001100010001#0000111011111001#0101110101001111#1000101001101110#1000111111001000#1010100111110101#1001011110001001#1010000101100111"));
	}

	@Test
	public void testString4() {
		assertEquals(0, sCheckValue("001101100011#111100001110#001010110101#010011111100#011100110001#110011011011#001000011110#001001001101#001000111010#011001111100#000000101001#010010011001"));
	}

	@Test
	public void testString5() {
		assertEquals(0, sCheckValue("011101#001110#010111#001110#101011#110110"));
	}

	@Test
	public void testString6() {
		assertEquals(0, sCheckValue("001110#000010#100000#001000#111000#100011"));
	}

	@Test
	public void testString7() {
		assertEquals(0, sCheckValue("10001101#00010001#01110100#10011111#10100011#11100011#11100110#10111110"));
	}

	@Test
	public void testString8() {
		assertEquals(0, sCheckValue("11011011#00011110#10001010#10101011#11010010#10100010#00111100#00111110"));
	}

	@Test
	public void testString9() {
		assertEquals(1, sCheckValue("10000000000000#01000000000000#00100000000000#00010000000000#00001000000000#00000100000000#00000010000000#00000001000000#00000000100000#00000000010000#00000000001000#00000000000100#00000000000010#00000000000001"));
	}

	@Test
	public void testString10() {
		assertEquals(0, sCheckValue("100000000000000000000#0100000000000000000000#00100000000000000000#0001000000000000000000000#00001000000000000000000#0000010000000000#000000100000000000000#00000001000000"));
	}

}
