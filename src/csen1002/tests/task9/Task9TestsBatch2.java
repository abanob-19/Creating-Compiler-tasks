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
public class Task9TestsBatch2 {
	
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
		assertEquals(1, sCheckValue("1000000000000#0100000000000#0010000000000#0001000000000#0000100000000#0000010000000#0000001000000#0000000100000#0000000010000#0000000001000#0000000000100#0000000000010#0000000000001#0000000000000#0000000000000#0000000000000#0000000000000"));
	}

	@Test
	public void testString2() {
	    assertEquals(0, sCheckValue("1000100001#0111101110#0001010010#0000111111#1100111001#0111011010#1010010001#0101011001#1110111001#0011111000"));
	}

	@Test
	public void testString3() {
		assertEquals(0, sCheckValue("001000101#011111101#100101000#111000100#110111001#101010011#011111010#111011111#110001101"));
	}

	@Test
	public void testString4() {
		assertEquals(0, sCheckValue("011001011100111011#110111010010100110#111001001100101011#011000101010011111#101110001010110001#011100000000110000#001010001100011001#101100001011100101#110111000010010110#110010010101010111#011000101101011110#000011001100000001#101100010111111011#001011010001101011#000111001100000111#111010100001001000#110001110101100100#101011001110100000"));
	}

	@Test
	public void testString5() {
		assertEquals(0, sCheckValue("001100101100000110#110010000110101111#110011011010110110#011100110011110101#101011001110001010#100011011110111100#111100010011101111#011100000001001001#111111110101001001#100010111111001001#000001111100100110#100000000111101100#101111000111111000#110001010010000110#011001011001100000#110010011001101010#100111111010010001#100110001100010000"));
	}

	@Test
	public void testString6() {
		assertEquals(0, sCheckValue("1001001101#0100000011#0000011100#1101100100#0110110000#0100000111#1001111111#0011001111#0010010101#1011110011"));
	}

	@Test
	public void testString7() {
		assertEquals(0, sCheckValue("10011100010100#10000010001000#10111110011000#11010110000111#00001011011101#00011101111010#01111000100100#11111100001011#01011010010110#00001000010100#00011111110010#00011101111100#10111111010011#11000000001111"));
	}

	@Test
	public void testString8() {
		assertEquals(0, sCheckValue("11001#01011#10010#10000#11100"));
	}

	@Test
	public void testString9() {
		assertEquals(1, sCheckValue("100000000000000#010000000000000#001000000000000#000100000000000#000010000000000#000001000000000#000000100000000#000000010000000#000000001000000#000000000100000#000000000010000#000000000001000#000000000000100#000000000000010#000000000000001"));
	}

	@Test
	public void testString10() {
		assertEquals(0, sCheckValue("1000000000000000000000#010000000000000000#0010000000000000#0001000000000000000000000000#000010000000000000000000#000001000000000000#0000001000000000000000000#0000000100000000#000000001000000000000#000000000100000000000000000"));
	}

}