package Medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber_17 {
	static String[] words = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}

	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		helper(digits, result, "");

		return result;
	}

	public static void helper(String s, List<String> result, String res) {
		if (s.length() == 0) {
			System.out.println(res);
			result.add(res);
			return;
		}
		String word = words[(s.charAt(0) - '0') - 2];
		for (int i = 0; i < word.length(); i++) {
			helper(s.substring(1), result, res + word.charAt(i));
		}
	}
}
