package Medium;

public class LongestPalindromicSubsequence_516 {

	public static void main(String[] args) {
//		String[] arr = { "aba" };
//		subsequence("abc", "", arr);
		System.out.println(longestPalindromeSubseq("abbbbaa"));
	}

	public static int longestPalindromeSubseq(String s) {
		String[] arr = {""};
		subsequence(s, "", arr);
		return arr[0].length();
	}

	public static void subsequence(String s, String up, String[] arr) {
		if (s.isEmpty()) {
			if (arr[0].length() < up.length() && palindrome(up)) {
				arr[0] = up;
			}
			return;
		}

		subsequence(s.substring(1), up, arr);
		subsequence(s.substring(1), up += s.charAt(0), arr);

	}

	public static boolean palindrome(String s) {
		if (s.length() % 2 == 1) {
			int i = s.length() / 2;
			int j = i;
			while (i >= 0) {
				if (s.charAt(i) == s.charAt(j)) {
					i--;
					j++;
				} else {
					return false;
				}
			}
		} else if (s.length() % 2 == 0) {
			int j = s.length() / 2;
			int i = j - 1;
			while (i >= 0) {
				if (s.charAt(i) == s.charAt(j)) {
					i--;
					j++;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
