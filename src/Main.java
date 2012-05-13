import java.awt.Point;
import java.io.PrintStream;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	private final static Scanner IN = new Scanner(System.in);
	private final static PrintStream OUT = System.out;

	static final Point startPoint = new Point(-1, -5);

	private static void ccc2009() {

		println("Which question would you like answered? 1 for ISBN. 2 for friends.");

		switch (nextInt()) {

			case 1:
				ISBN();
				break;
			case 2:
				friendSolve();
				break;
		}
		ccc2009();
	}

	private static void ccc2011() {
		println("Which question would you like answered? 1 for \"Which alien?\",\n 2 for weather balloon altitude, 3 for Sumac sequences. "
				+ "4 for the unfriend problem.");
		switch (nextInt()) {
			case 1:
				whichAlien();
				break;
			case 2:
				windAltitude();
				break;
			case 3:
				sumacSequence();
				break;
			case 4:
				unfriend();
				break;
		}
		ccc2011();

	}

	private static void ccc2012() {
		println("Which question would you like answered? 1 for speed limit."
				+ " 2 for fish finding. 3 for the Big Bang Problem. 4 for icon scaling."
				+ " 5 for the coin problem.");

		switch (nextInt()) {

			case 1:
				speedLimit();
				break;
			case 2:
				fishFind();
				break;
			case 3:
				shiftWord();
				break;
			case 4:
				scaleIcon();
				break;
			case 5:
				coinSolve();
				break;
		}
		ccc2012();

	}

	private static void coinSolve() {
		/*
		 * When she is bored, Jo Coder likes to play the following game with
		 * coins on a table. She takes a set of distinct coins and lines them up
		 * in a row. For example, let us say that she has a penny (P, worth
		 * $0.01), a nickel (N, worth $0.05), and a dime (D, worth $0.10). She
		 * lines them up in an arbitrary order, (for example, D N P), and then
		 * moves them around with the goal of placing them in strictly
		 * increasing order by value, that is P N D (i.e., $0.01, $0.05, $0.10).
		 * She has particular rules that she follows: • The initial coin
		 * line-up defines all positions where coins can be placed. That is, no
		 * additional positions can be added later, and even if one of the
		 * positions does not have a coin on it at some point, the position
		 * still exists. • The game consists of a sequence of moves and in
		 * each move Jo moves a coin from one position to an adjacent position.
		 * The coins can be stacked, and in a move Jo always takes the top coin
		 * from one stack and moves it to the top of another stack. In a stack
		 * of coins, Jo never places a higher-value coin on top of a lower-value
		 * coin. For simplicity, let the coins have consecutive integer values
		 * (e.g., denote the penny as 1, nickel as 2, and dime as 3). Then, in
		 * the above example, Jo could play the game in the following way in 20
		 * moves (where XY denotes that coin X is on top of coin Y).
		 */

	}

	private static boolean firstIsHighest(int... args) {
		for (int i : args) {
			if (i > args[0]) {
				return false;
			}
		}
		return true;
	}

	private static void fishFind() {
		int[] fishDepths = new int[4];
		for (int i = 0; i < 4; i++) {
			printfln("Enter reading %s", i + 1);
			fishDepths[i] = IN.nextInt();
		}
		String output = "";
		if (firstIsHighest(fishDepths)) {
			output = "Fish Rising";
		}
		else if (lastIsHighest(fishDepths)) {
			output = "Fish Diving";
		}
		else {
			output = "No Fish";
		}
		println(output);
	}

	private static void friendSolve() {
		Queue<int[]> l;

	}

	private static void ISBN() {
		char[] isbnchars = IN.nextLine().toCharArray();
		if (isbnchars.length != 13) {
			println("Not a valid ISBN number.");
			return;
		}
		int[] isbnnum = new int[13];
		int isbnsum = 0;
		for (int i = 0; i < isbnchars.length; i++) {
			int newNum = Character.digit(isbnchars[i], 36);
			isbnnum[i] = newNum * i % 2 == 1 ? 3 : 1;
			isbnsum += isbnnum[i];
		}
		if (isbnsum % 10 != 0) {
			println("Not a valid ISBN number.");
		}
		else {
			println("This is a valid ISBN number.");
		}

	}

	private static char lastCharByInt(char value, int shift) {
		if (!Character.isLetter(value)) {
			return value;
		}
		if (shift == 0) {
			return value;
		}
		else {
			return lastCharByInt(value == 'A' ? 'Z' : --value, --shift);
		}
	}

	private static boolean lastIsHighest(int... args) {
		for (int i : args) {
			if (i > args[args.length - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String... args) {
		println("Enter the year of the CCC questions you want answered.");
		switch (nextInt()) {
			case 2009:
				ccc2009();
				break;
			case 2011:
				ccc2011();
				break;

			case 2012:
				ccc2012();
				break;
		}
	}

	private static int nextInt() {
		return Integer.parseInt(IN.nextLine());
	}

	private static int nextSumac(int t1, int t2) {
		if (t1 < t2) {
			return 2;
		}
		return nextSumac(t2, t2 - t1) + 1;

	}

	private static void printfln(String s, Object... args) {
		OUT.printf(s, args);
		OUT.println();
	}

	private static void println(String output) {
		OUT.println(output);
	}

	private static void scaleIcon() {
		char[][] originalIcon =
				new char[][] { { '*', 'x', '*' }, { ' ', 'x', 'x' },
						{ '*', ' ', '*' } };
		println("Factor:");
		int scaleFactor = nextInt();
		char[][] newIcon = new char[3 * scaleFactor][3 * scaleFactor];
		for (int i = 0; i < 3 * scaleFactor; i++) {
			for (int j = 0; j < 3 * scaleFactor; j++) {
				int[] pos = { i / scaleFactor, j / scaleFactor };
				newIcon[i][j] = originalIcon[pos[0]][pos[1]];
			}
		}
		for (char[] chars : newIcon) {
			OUT.println(chars);
		}
	}

	private static void shiftWord() {
		/*
		 * Shifting a letter by S positions means to go forward S letters in the
		 * alphabet. For example, shifting B by S = 3 positions gives E.
		 * However, sometimes this makes us go past Z, the last letter of the
		 * alphabet. Whenever this happens we wrap around, treating A as the
		 * letter that follows Z. For example, shifting Z by S = 2 positions
		 * gives B. Sheldon and Leonard’s code depends on a parameter K and
		 * also varies depending on the position of each letter in the word. For
		 * the letter at position P , they use the shift value of S = 3P + K.
		 * For example, here is how ZOOM is encoded when K = 3. The first letter
		 * Z has a shift value of S = 3 × 1 + 3 = 6; it wraps around and
		 * becomes the letter F. The second letter, O, has S = 3 × 2 + 3 = 9
		 * and becomes X. The last two letters become A and B. So Sheldon sends
		 * Leonard the secret message: FXAB Write a program for Leonard that
		 * will decode messages sent by Sheldon. Input Specification The input
		 * will be two lines. The first line will contain the positive integer K
		 * (K < 10), which is used to compute the shift value. The second line
		 * of input will be the word, which will be a sequence of uppercase
		 * characters of length at most 20. Output Specification The output will
		 * be the decoded word of uppercase letters.
		 */
		// S = 3P + Ks

		println("K = ");
		int k = nextInt();
		println("Message: ");
		String message = IN.nextLine().toUpperCase();
		String output = "";
		for (int i = 0; i < message.length(); i++) {
			int s = (3 * (i + 1)) + k;
			output += lastCharByInt(message.charAt(i), s);
		}
		println(output);
	}

	private static void speedLimit() {
		println("Limit: ");
		double limit = IN.nextDouble();
		println("Speed: ");
		double speed = IN.nextDouble();
		int diff = (int) (speed - limit);
		if (diff <= 0) {
			println("Congratulations, you are within the speed limit!");
		}
		else {
			printfln("You are speeding and your fine is $%d",
					(diff >= 20 ? (diff > 30 ? 500 : 270) : 100));
		}
	}

	private static void sumacSequence() {
		println("t1 = ");
		int t1 = nextInt();
		println("t2 = ");
		int t2 = nextInt();
		printfln("Sumac length equals %s", nextSumac(t1, t2));
	}

	private static void unfriend() {
	}

	private static void whichAlien() {
		/*
		 * • TroyMartian, who has at least 3 antenna and at most 4 eyes; •
		 * VladSaturnian, who has at most 6 antenna and at least 2 eyes; •
		 * GraemeMercurian, who has at most 2 antenna and at most 3 eyes.
		 */
		String output = "";
		println("How many antennae?");
		int antennae = nextInt();
		println("How many eyes?");
		int eyes = nextInt();
		if (antennae >= 3 && eyes <= 4) {
			output += "TroyMartian\n";
		}
		if (antennae <= 6 && eyes >= 2) {
			output += "VladSaturnian\n";
		}
		if (antennae <= 2 && eyes <= 3) {
			output += "GraemeMercurian";
		}
		println(output);
	}

	private static void windAltitude() {
		println("Humidity factor = ");
		int h = nextInt();
		println("Largest hour = ");
		int M = nextInt();
		int firstHour = -1;
		for (int t = 1; t <= M; t++) {
			int a =
					(int) ((-6 * (Math.pow(t, 4)))
							+ (30 * (Math.pow(t, 3)))
							+ (2 * (Math.pow(t, 2))) + t);
			if (a <= 0) {
				firstHour = t;
				break;
			}
		}
		String output;
		if (firstHour == -1) {
			println("The balloon does not touch ground in the given time.");
		}
		else {
			printfln("The balloon first touches ground at hour :\n%d",
					firstHour);
		}

	}
}
