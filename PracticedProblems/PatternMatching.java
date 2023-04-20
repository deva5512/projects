package WeeklyAssignment;

public class PatternMatching {
	public static void main(String[] args) {
		System.out.println(patternVerifier("baaabab", "********b" , false));
	}

	public static boolean patternVerifier(String word, String pattern, boolean consume) {
		if (word.length() == 0 && pattern.length() == 0) {
			return true;
		}
		if (word.length() == 0 || pattern.length() == 0) {
			if(consume && pattern.length() == 0) {
				return consume;
			}
			return false;
		}
		if (pattern.charAt(0) == '*') {
			if (patternVerifier(word, pattern.substring(1) , true)) {
				return true;
			} else if (patternVerifier(word.substring(1), pattern.substring(1) , false)) {
				return true;
			}
		}
		if (pattern.charAt(0) == '?' || word.charAt(0) == pattern.charAt(0)) {
			if (patternVerifier(word.substring(1), pattern.substring(1) , false)) {
				return true;
			}
		}
		if (consume) {
			if (patternVerifier(word.substring(1), pattern, true)) {
				return true;
			}
		}
		return false;
	}
}
