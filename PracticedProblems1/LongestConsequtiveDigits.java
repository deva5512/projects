package WeeklyAssignment;

public class LongestConsequtiveDigits {
	public static void main(String[] args) {
		System.out.println(consequtiveDigits("00000011111"));
	}

	public static String consequtiveDigits(String s) {

		String res = "";
		String found = s.charAt(0) + "";

		for (int i = 1; i < s.length(); i++) {
			if (found.charAt(found.length() - 1) == s.charAt(i)) {

				if (res.length() < found.length())
					res = found;

				found = s.charAt(i) + "";
			} else {
				found += s.charAt(i);
			}
		}
		if (res.length() < found.length()) {
			res = found;
		}

		return res;

	}
}
