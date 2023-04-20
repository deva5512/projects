package Medium;

public class LongestPalindromicSubstring_5 {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("ac"));
		String one = "oneoneone";
		System.out.println(one.indexOf('o'));
		System.out.println(one.indexOf('o'));
		System.out.println(one.indexOf('o'));
	}

	public static String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}

		StringBuilder res = new StringBuilder();
		int reslen = res.length();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String word = s.substring(i, s.lastIndexOf(ch) + 1);
			int a = 0, b = word.lastIndexOf(ch);
			while (a <= b) {
				word = word.substring(a, b + 1);
				if (isPalin(word) && reslen < word.length()) {
					res = new StringBuilder(word);
					reslen = res.length();
					break;
				}
				b = word.substring(a, b).lastIndexOf(ch);
			}
			if (res.length() == s.length() - i) {
				break;
			}
		}

		return new String(res);
	}
	
	public static String longestPalindrome1(String s) {
		if (s.length() <= 1) {
			return s;
		}

		StringBuilder res = new StringBuilder();
		int reslen = res.length();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String word = s.substring(i, s.lastIndexOf(ch) + 1);
			int a = 0, b = word.lastIndexOf(ch);
			while (a <= b) {
				word = word.substring(a, b + 1);
				if (isPalin(word) && reslen < word.length()) {
					res = new StringBuilder(word);
					reslen = res.length();
					break;
				}
				b = word.substring(a, b).lastIndexOf(ch);
			}
			if (res.length() == s.length() - i) {
				break;
			}
		}

		return new String(res);
	}

	public static boolean isPalin(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
