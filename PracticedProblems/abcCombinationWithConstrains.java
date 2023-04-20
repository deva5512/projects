package WeeklyAssignment;

import java.util.LinkedList;
import java.util.List;

public class abcCombinationWithConstrains {
	public static void main(String[] args) {
		List<String> res = new LinkedList<>();
		combination("abc".toCharArray(), new StringBuilder(), res, 3);
		System.out.println(res);
		System.out.println(res.size());

	}

	public static void combination(char[] arr, StringBuilder str, List<String> res, int n) {
		if (str.length() == n) {
			String s = new String(str);
			String word = s;
			int a = s.indexOf("b");
			if (a != -1) {
				s = s.substring(0, a) + s.substring(a+1);
			}
			a = s.indexOf("c");
			if (a != -1) {
				s = s.substring(0, a) + s.substring(a+1);
			}
			a = s.indexOf("c");
			if (a != -1) {
				s = s.substring(0, a) + s.substring(a+1);
			}
			if (s.indexOf("b") == -1 && s.indexOf("c") == -1)
				res.add(word);
			return;
		}
		for (int j = 0; j < arr.length; j++) {
			str.append(arr[j]);
			combination(arr, str, res, n);
			str.deleteCharAt(str.length()-1);
		}
	}
}
