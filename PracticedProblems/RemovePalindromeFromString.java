package WeeklyAssignment;

public class RemovePalindromeFromString {
	public static void main(String[] args) {
		System.out.println(removePalindrome("He did a  good job"));
	}

	public static String removePalindrome(String s) {
		s = s.trim();
		String res = "";
		String word = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (!palindrome(word)) {
					res += word + " ";
				}
				word = "";
			} else {
				word += s.charAt(i);
			}
		}
		if (!palindrome(word)) {
			res += word;
		}
		return res;
	}

	public static boolean palindrome(String word) {
		if (word.isEmpty()) {
			return true;
		}
		int i = 0, j = word.length() - 1;

		while (i < j) {
			if (word.charAt(i) != word.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
