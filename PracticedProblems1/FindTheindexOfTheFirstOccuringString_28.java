package Medium;

public class FindTheindexOfTheFirstOccuringString_28 {

	public static void main(String[] args) {
		System.out.println(strStr("abc", "c"));
	}

	public static int strStr(String haystack, String needle) {

		int len = needle.length();

		if (len > haystack.length()) {
			return -1;
		}
		if (needle.equals(haystack)) {
			return 0;
		}

		int s = 0;
		int e = haystack.length() - 1;
		char ch = needle.charAt(0);

		while ((e - s) >= len-1) {
			if (ch == haystack.charAt(s)) {
				if (haystack.substring(s, len + s).equals(needle))
					// System.out.println(haystack.substring(s , len+s));
					return s;
			}
			s++;
		}
		return -1;
	}
}
