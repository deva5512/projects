package Medium;

public class BullsAndcows_299 {
	public static void main(String[] args) {
		String secret = "1807";
		String guess = "7810";
		System.out.println(getHint(secret, guess));
	}

	public static String getHint(String secret, String guess) {

		// Convert both strings to string builder for easy deleting
		StringBuilder sec = new StringBuilder(secret);
		StringBuilder gus = new StringBuilder(guess);

		int bull = 0;
		int cow = 0;

		// Used to count the number of bulls
		for (int i = 0; i < sec.length(); i++) {
			if (sec.charAt(i) == gus.charAt(i)) {
				bull++;
				sec.deleteCharAt(i);
				gus.deleteCharAt(i);
				i--;
			}
		}

		// Used to count the number of cows
		char ch = ' ';
		for (int i = 0; i < sec.length(); i++) {
			ch = sec.charAt(i);

			if (gus.indexOf(ch + "") != -1) {
				cow++;
				sec.deleteCharAt(i);
				gus.deleteCharAt(gus.indexOf(ch + ""));
				i--;
			}
		}

		return bull + "A" + cow + "B";
	}
}
