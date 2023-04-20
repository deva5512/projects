package Medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
	public static void main(String[] args) {
		System.out.println(partition("efe"));
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		helper(s, new ArrayList<>(), result);
		return result;
	}

	public static void helper(String s, List<String> ans, List<List<String>> result) {
		if (s.length() == 0) {
			if (ans.isEmpty()) {
				return;
			}
			List<String> list = new ArrayList<>(ans);
			result.add(list);
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s.substring(0, i + 1))) {
				ans.add(s.substring(0, i + 1));
				helper(s.substring(i + 1), ans, result);
				ans.remove(ans.size() - 1);
			} else {
				continue;
			}
		}
	}

	public static boolean isPalindrome(String s) {
		int a = 0, b = s.length() - 1;
		while (a < b) {
			if (s.charAt(a) != s.charAt(b)) {
				return false;
			}
			a++;
			b--;
		}
		return true;
	}
}
