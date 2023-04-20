package Medium;

public class longestRepeatingCharactor_424 {

	public static void main(String[] args) {
		System.out.println(characterReplacement("ABAB", 2));
	}

	public static int characterReplacement(String s, int k) {

		int res = 0;
		int got = 0;

		int len = s.length();

		for (int i = 0; i < len; i++) {
			if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
				char req = s.charAt(i);
				got = 1;
				int temp = k;
				int j = i+1;
				for (; j < len; j++) {
					if (s.charAt(j) == req) {
						got++;
					} else if (temp > 0) {
						temp--;
						got++;
					} else {
						break;
					}
				}
				if (temp > 0) {
					j = i-1;
					for (; j >= 0; j--) {
						if (s.charAt(j) == req) {
							got++;
						} else if (temp > 0) {
							temp--;
							got++;
						} else {
							break;
						}
					}
				}else if (j == len) {
					break;
				}
				res = Math.max(res, got);
			}
		}
		return Math.max(res, got);
	}
}
