package WeeklyAssignment;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String arr[] = { "flower", "flow", "flo" };
		System.out.println(longestprefix(arr));
	}

	public static String longestprefix(String[] arr) {

		String word = arr[0];

		for (int i = 1; i < arr.length; i++) {
			while (!start(word, arr[i])) {
				word = word.substring(0, word.length() - 1);
			}
			if (word.isEmpty()) {
				break;
			}
		}

		return word;
	}

	public static boolean start(String word, String wordarr) {
		if (word.length() > wordarr.length() || word.isEmpty() || wordarr.isEmpty()) {
			return false;
		}
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) != wordarr.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
