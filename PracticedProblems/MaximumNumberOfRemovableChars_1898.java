package Medium;

public class MaximumNumberOfRemovableChars_1898 {

	public static void main(String[] args) {
		System.out.println(maximumRemovals("qobftgcueho", "obue", new int[] { 5, 3, 0, 6, 4, 9, 10, 7, 2, 8 }));
	}

	public static int maximumRemovals(String s, String p, int[] removable) {
		int l = 0, h = removable.length - 1;
		int res = 0;

		while (l <= h) {
			int mid = (l + h) / 2;
			char[] temp = s.toCharArray();

			for (int i = 0; i <= mid; i++) {
				temp[removable[i]] = '.';
			}
			boolean verify = check(new String(temp), p);

			if (verify) {
				res = mid + 1;
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}

		return res;
	}

	static boolean check(String s, String p) {
		int i = 0, j = 0;
		int plen = p.length();
		int slen = s.length();

		while (j < plen && i < slen) {
			if (s.charAt(i) != '.' && s.charAt(i) == p.charAt(j))
				j++;
			i++;
		}

		return j == plen;
	}
}
