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
public class Task9TestsBatch3 {
	
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
		assertEquals(1, sCheckValue("10000000000000000#01000000000000000#00100000000000000#00010000000000000#00001000000000000#00000100000000000#00000010000000000#00000001000000000#00000000100000000#00000000010000000#00000000001000000#00000000000100000"));
	}

	@Test
	public void testString2() {
	    assertEquals(0, sCheckValue("1001100#0101111#0001110#0101111#1000010#0000111#0111101"));
	}

	@Test
	public void testString3() {
		assertEquals(0, sCheckValue("001011111011101#001111110110010#111011110000001#000110001011101#100110010000110#001011000010001#100111001110011#001010000001001#000101100110111#000000111101101#110010011010000#110000110101001#111011111000010#111111010110100#110100001100110"));
	}

	@Test
	public void testString4() {
		assertEquals(0, sCheckValue("111011#110111#001011#100000#001011#010100"));
	}

	@Test
	public void testString5() {
		assertEquals(0, sCheckValue("11011#00001#10101#01000#10011"));
	}

	@Test
	public void testString6() {
		assertEquals(0, sCheckValue("00010101101001010#10001100000101100#11001001001110100#01001111000011110#11110111100011000#11000011001100011#01001110100100011#01001111010001011#01111100000011110#10010000110110010#11100001110011011#01110001011101100#01000001000100101#01100010010100010#11100000110100011#10011110101111101#10001010111001110"));
	}

	@Test
	public void testString7() {
		assertEquals(0, sCheckValue("101001010101111011#001001010110111010#011010000001001101#011001010111101110#011100101011100011#001001101011111101#010110111011111010#111010111011011001#110011010000101001#111011101011011110#011101100110101100#001110110101110000#010010110100101110#000101010111000001#001000100111111101#111000000000110001#110100100110011110#111000010111011011"));
	}

	@Test
	public void testString8() {
		assertEquals(0, sCheckValue("1110011110010011#0000011110010011#1010110000000000#1000111111110001#1000011010111001#1011101001110100#0101010011011010#1011110011101110#1110110011100110#0100000100001001#1101000010100101#0011111111111000#1000101011011001#1110000000000100#0000001000000000#1110010100000101"));
	}

	@Test
	public void testString9() {
		assertEquals(1, sCheckValue("10000000000000000#01000000000000000#00100000000000000#00010000000000000#00001000000000000#00000100000000000#00000010000000000#00000001000000000#00000000100000000#00000000010000000#00000000001000000#00000000000100000#00000000000010000#00000000000001000#00000000000000100#00000000000000010#00000000000000001"));
	}

	@Test
	public void testString10() {
		assertEquals(0, sCheckValue("100000000000000000000000#010000000000000000000000000#001000000000000000000000000000000000#0001000000000000000000000000#0000100000000000000000#000001000000000000000000#000000100000000000000000000000000#000000010000000000000000000000000000#0000000010000000000000000000#0000000001000000000000#00000000001000000000000000#000000000001000000000000000000000#0000000000001000000000000000#0000000000000100000000000000000000#0000000000000010000000000000000#000000000000000100000000000#000000000000000010000000"));
	}

}
