package WeeklyAssignment;

import java.util.HashSet;
import java.util.Set;

public class DistinctSubsets {
	public static void main(String[] args) {
		String word[] = { "one", "two" };
		distinct(word);
	}

	public static void distinct(String[] words) {

		Set<String> subsets = new HashSet<>();

		for (int i = 0; i < words.length; i++) {
			subset("", words[i], subsets, 0);
		}
		System.out.println(subsets);
	}

	public static void subset(String up, String s, Set<String> res, int ind) {
		if (ind == s.length()) {
			res.add(up);
			return;
		}

		subset(up, s, res, ind + 1);

		up += s.charAt(ind);
		subset(up, s, res, ind + 1);
		up = up.substring(0, up.length() - 1);

	}
}
