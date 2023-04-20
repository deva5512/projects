package Medium;

public class LongestCommonSubsequence_1143 {
	public static void main(String[] args) {
//		System.out.println(longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr"));

		String s1 = "hofubmnylkra";
		String s2 = "pqhgxgdofcvmr";

		System.out.println(longestCommonSubsequence1(s1, s2, 0, 0, new Integer[s1.length()][s2.length()]));

	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int max = 0;

		for (int a = 0; a < text1.length(); a++) {
			int len = 0;
			int start = 0;
			for (int i = a; i < text1.length(); i++) {

				char req = text1.charAt(i);
				int j = start;

				for (; j < text2.length(); j++) {
					if (req == text2.charAt(j)) {
						start = j + 1;
						len++;
						break;
					}
				}
			}
			if (max < len) {
				max = len;
			}
		}

		return max;
	}

	public static int longestCommonSubsequence1(String text1, String text2, int a, int b, Integer[][] arr) {
		if (text1.length() == a || text2.length() == b) {
			return 0;
		}
		if (arr[a][b] != null) {
			return arr[a][b];
		}
		if (text1.charAt(a) == text2.charAt(b)) {
			return arr[a][b] = longestCommonSubsequence1(text1, text2, a + 1, b + 1, arr)+1;
		} else {
			int a1 = longestCommonSubsequence1(text1, text2, a + 1, b, arr);
			int a2 = longestCommonSubsequence1(text1, text2, a, b + 1, arr);
			return arr[a][b] = Math.max(a2, a1);
		}
	}

}
