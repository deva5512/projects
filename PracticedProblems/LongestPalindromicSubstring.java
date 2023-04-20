package WeeklyAssignment;

import java.util.LinkedList;
import java.util.List;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		System.out.println(longestPalindromicSubstring("bb"));
		System.out.println(lengthOfLongestSubstring("aab"));
	}

	public static String longestPalindromicSubstring(String word) {
		if (word.length() <= 1) {
			return word;
		}

		String res = "";

		for (int i = 0; i < word.length(); i++) {
			int left = i;
			int right = i;

			while (left > -1 && right < word.length() && word.charAt(left) == word.charAt(right)) {
				left--;
				right++;
			}

			String found = word.substring(left + 1, right);
			if (res.length() < found.length()) {
				res = found;
			}

			left = i - 1;
			right = i;

			while (left > -1 && right < word.length() && word.charAt(left) == word.charAt(right)) {
				left--;
				right++;
			}

			found = word.substring(left + 1, right);
			if (res.length() < found.length()) {
				res = found;
			}

		}

		return res;
	}

	public static int lengthOfLongestSubstring(String s) {
		int i = 0;
		int res = 0;

		List<Character> list = new LinkedList<>();

		while (i < s.length()) {
			if (!list.contains(s.charAt(i))) {
				list.add(s.charAt(i));
				i++;
			} else {
				res = Math.max(res, list.size());
				list.remove(0);
			}
		}

		if (res < list.size()) {
			return list.size();
		}
		return res;
	}
}
