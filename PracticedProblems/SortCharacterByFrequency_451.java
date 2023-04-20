package Medium;

import java.util.Arrays;

public class SortCharacterByFrequency_451 {

	public static void main(String[] args) {
		System.out.println(frequencySort("Aabb"));
	}

	public static String frequencySort(String s) {
		char c[] = s.toCharArray();
		Arrays.sort(c);
		s = new String(c);

		StringBuilder res = new StringBuilder();

		StringBuilder finalchars;
		StringBuilder repetedchars;

		while (s.length() != 0) {

			finalchars = new StringBuilder();
			repetedchars = new StringBuilder();
			int a = 0, b = 0;
			while (a < s.length()) {
				if (s.charAt(a) == s.charAt(b)) {
					repetedchars.append(s.charAt(a));
					a++;
				} else {
					if (finalchars.length() < repetedchars.length()) {
						finalchars = repetedchars;
					}
					b = a;
					repetedchars = new StringBuilder();
				}
			}
			if (finalchars.length() < repetedchars.length()) {
				finalchars = repetedchars;
			}
			s = s.replace(finalchars, "");
			res.append(finalchars);
		}

		return new String(res);
	}
}
