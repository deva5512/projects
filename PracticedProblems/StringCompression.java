package Medium;

import java.util.Arrays;

public class StringCompression {

	public static void main(String[] args) {
		char[] ch = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};

		//'a','a','a','b','b','b','c'
		//'a','b','b','b','b','b','b','b','b','b','b','b','b'

		System.out.println(compress(ch));
	}

	public static int compress(char[] chars) {

		int res = 1;
		char ch = chars[0];
		int count = 1, i = 1, j = 1;

		while (i < chars.length) {

			if (chars[i] == ch) {
				count++;
			} else {
				if (count > 1) {
					String rep = count + "";
					int ind = 0;
					while (ind < rep.length()) {
						chars[j++] = rep.charAt(ind++);
						res++;
					}
				}
				count = 1;

				ch = chars[i];
				chars[j] = ch;
				j++;
				res++;
			}
			i++;
		}
		if (count > 1) {
			String rep = count + "";
			int ind = 0;
			while (ind < rep.length()) {
				chars[j++] = rep.charAt(ind++);
				res++;
			}
		}

		System.out.println(Arrays.toString(chars));

		return res;
	}
}
