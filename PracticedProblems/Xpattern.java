package WeeklyAssignment;

public class Xpattern {
	public static void main(String[] args) {
		pattern("program");
	}

	public static void pattern(String word) {

		int ls = -1;
		int ms = word.length();
		int a = -1, b = word.length();
		for (int i = 0; i < word.length(); i++) {

			if (i != 0) {
				System.out.println();
			}

			if (i <= word.length() / 2) {
				ms -= 2;
				ls++;
				a++;
				b--;
			} else {
				ms += 2;
				ls--;
				b++;
				a--;
			}
			System.out.print("  ".repeat(ls));
			System.out.print(word.charAt(a) + " ");
			if (a == b) {
				continue;
			}
			System.out.print("  ".repeat(ms));
			System.out.print(word.charAt(b) + " ");
		}

	}
}
