package csen1002.tests.task10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task10.Task10Lexer;
import csen1002.main.task10.Task10Parser;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task10TestsBatch0 {
	
	/**
     * Parses a provided string using Task 10's grammar
     * and gets the value of the attribute "val" of the variable "s"
     *
     * @param input a string to parse
     * @return the value of the attribute "val" of the variable "s"
     */
    public static int sValValue(String input) {
        Task10Lexer lexer = new Task10Lexer(CharStreams.fromString(input));
        Task10Parser parser = new Task10Parser(new CommonTokenStream(lexer));
        return parser.s().val;
    }


	@Test
	public void testString1() {
		assertEquals(4, 
        sValValue("316,4854,842,7164,7164,7652,9870,501,501,501,9610,7785,3569,1530,8525,2944,9085,9085,9085,9085,4620,27,676,1357,2616,2616,2616,2616,8968,1116"));
	}

	@Test
	public void testString2() {
		assertEquals(3, 
        sValValue("5006,4417,6404,6404,6404,6404,8762,4314,4637,2351,2351,2351,547,282,4488,4790,8982,6576,2954,273,8340,1203,3517,5592,9910,6276,5454,1716,3414,2961,307,1999,6658,6447,6925,697,4791,6124,369,1407,1550,5016,1426,1843,2466,4196,7,8241,6405,6405,6405,6405,7920,2490,7491,7380,2116,9103,210,6729,2608,6989,8681"));
	}

	@Test
	public void testString3() {
		assertEquals(10, 
        sValValue("3951,3693,5960,7059,705,3024,3024,5335,5128,3618,7771,7771,7771,7771,3134,9807,9807,9807,2126,6064,5320,7747,3441,7543,9501,4653,2728,1984,1361,8861,9950,1217,3377,3377,3377,2612,1637,9263,9263,9263,9263,2068,2068,8358,7175,2491,4164,4758,3025,7870,5976,5887,9864,583,9539,698,1314,9690,5584,1888,2830,7913,7302,9056,8032,8032,8032,3385,7938,7938,7938,8147,8147,8147,9590,8799,742,4032,4712,7921,8888,7683,2709,3271,7056,3014,4145,4145,8599,1425"));
	}

	@Test
	public void testString4() {
		assertEquals(8, 
        sValValue("7291,9128,1143,3856,6421,9351,2760,3329,3251,4616,9791,5227,3204,7477,6202,8323,8323,8323,6259,1530,7027,9409,5379,1786,3569,5468,3104,8790,5142,4440,2395,1602,1602,1602,3711,3711,4172,7310,880,880,880,880,4394,2440,7787,922,922,922,5044,7851,518,6260,8292,7582,1255,708,862,9652,7054,9280,7967,7967,7967,7967,5636,317,8276,9104,6608,7806,12,6802,1439,4116,1800,1990,2029,5803,6913,5423,6793,6793,6793,6793,4070,3901,1232,2750,4930,6569,3405,8896,4795,7666,7042,5619,7199,1991,3081,7676,3817,4770,4770,4770,483,501,1345,8792,6881,7331,3660,4437,4844,5380,7450,5353,4765,747,477,440,3152,4914,4553,121,5492,2731,8465,1639,3545,7753,8100,5873,8637,2101,4817,1193,8631,6675,1482"));
	}

	@Test
	public void testString5() {
		assertEquals(20, 
        sValValue("4167,7812,9617,4090,6648,6648,4707,8243,8243,7608,7608,6550,6550,8776,5921,5976,5976,5976,6120,6540,2521,4917,4917,4917,6891,5418,206,206,206,415,6554,6554,1901,7788,4887,6528,4357,4357,4357,1311,1311,1311,3462,2846,2846,2846,2846,3261,47,2131,9237,6104,6104,6104,6104,1086,1086,7551,7551,7551,7551,7564,6285,8514,5341,8829,9205,9271,3175,3175,3175,2731,1628,1628,1628,1628,8131,3136,3136,3136,3136,6900,6900,6900,6900,8639,4941,4941,9602,4401,4401,4401,2337"));
	}

	@Test
	public void testString6() {
		assertEquals(4, 
        sValValue("7783,823,6851,1407,4148,6276,9157,3854,6448,3618,8224,4338,2698,8842,8508,4015,9964,6073,6762,7888,194,9493,798,8443,2759,2759,2759,9788,8371,9802,1894,2349,8181,9054,6525,1010,5151,829,7962,1253,355,1050,7045,7083,9735,2456,4226,5896,5199,1434,1400,9228,4826,5222,8905,6282,3411,8527,7532,4644,8138,3772,2812,7917,7972,4014,4014,4014,4014,7178,1612,3136,9553,3656,9113,9362,9362,1772,6778,7103,5962,5962,7607,6906,6113,9111,7254,5703,4679,8316,2911,724,3627,4670,464,5801,4979,7756,707,2201,6181,5950,8755,8651,2908,3700,2206,4402,7349,7475,1831,7981,6136,7079,4450"));
	}

	@Test
	public void testString7() {
		assertEquals(24, 
        sValValue("1698,1698,5170,8140,8140,5120,1274,3927,1273,579,7039,7039,4373,1360,1689,1689,4677,4636,2852,4096,3422,3422,3422,3422,8111,6975,6975,2277,8532,8940,9085,6320,9521,6544,6544,7837,7837,2575,269,269,269,269,1109,3452,8195,3846,3846,3846,5920,9173,9173,9173,9173,7155,5081,1532,8655,7127,7282,8296,8296,8296,4930,3278,8075,8075,1189,1528,1528,1528,1528,2266,6326,8170,9924,4142,4142,3763,6674,6073,3217,8850,9397,5671,1149,6061,6259,3879,6358,6358,6358,6358,1706,4848,9008,9008,9008,7057,4712,4712,5243,7186,7186,1016,7907,6013,4587,4587,4587,6661,639,7766,7766,7766,7766,8850,7890,4836,4836,4836,9254,1734,6506,9841,852,4501,4012,3843,4204,4204,4204,7804,8768,3753,3753,3753,6069,9027,4350,1948"));
	}

	@Test
	public void testString8() {
		assertEquals(0, 
        sValValue("2399,6365,9209,7304,9502,327,2008,725,1924,607,9828,3148,9871,5593,8315,3532,5953,8421,5981,7199"));
	}

	@Test
	public void testString9() {
		assertEquals(1, 
        sValValue("9261,686,686,1558"));
	}

	@Test
	public void testString10() {
		assertEquals(28, 
        sValValue("9057,2575,8701,7205,8476,8327,8327,8565,6708,2842,9398,548,2598,4197,1101,843,843,843,843,4360,4817,8580,5934,7847,2248,7943,7943,9425,9425,9425,1631,1932,5598,6846,6846,6846,8937,1094,1094,1094,9647,2282,8891,6682,5038,7630,3379,3481,3833,3833,3833,3833,5100,3839,2178,6257,4677,4676,4065,6410,5304,5634,9508,9064,1040,8384,8384,8384,8384,3912,2847,7882,9237,7992,3921,3945,3945,3945,7368,6263,4586,3766,2199,9173,9173,9173,1591,7722,2252,9702,9702,1947,4346,880,1298,4957,4010,9233,8792,9384,9384,3561,143,923,831,8594,6949,9746,9507,9507,9507,9507,8812,274,7393,6413,3982,7098,313,7645,3682,256,1122,7365,3579,4438,2068,7146,7146,4740,8547,2521,9366,2942,4720,4631,3364,9363,9363,9363,9363,9540,9540,1790,4383,7735,2255,6365,4442,2499,2499,2499,8292,8292,8292,5472,8840,8840,2844,9621,8658,6526,324,776,3605,1263,1263,1263,1263,2619,1333,2869,5454,5454,5454,8413,597,3008,3008,3008,3914,2192,8752,8065,6255,9586,6216,5967,7731,8510,5857,5308,9080,697,7695,1551,4940,3725,6778,5910,7983,6526,1768,9218,9218,9218,9218,2667,5926,5926,5926,5909,7971,3477,163,599,6421,6421,6421,3494,6100,6429,2595,9359,9694,5012,4597,7729,712,236,236,2567,6219,6661,6661,6661,6818,1228,3117,8168,4139,4519,3444,4225,407,1413,4238,4238,5287,2734,8857"));
	}

}