package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermitationInString_567 {
	public static void main(String[] args) {
		System.out.println(checkInclusion1("rokx", "otrxvfszxroxrzdsltg"));
	}

	/*
	 * Concept :
	 *
	 * first create two char arrays and fill it with ' '
	 * 
	 * find the index of the s1 in the other string store the substring of the s2 in
	 * word then create a while loop that runs till we match the words or till the
	 * word become invalid once the i become greater then the another string then we
	 * can't find the required answer so break and return false;
	 * 
	 */

	public static boolean checkInclusion1(String s1, String s2) {

		int length = s1.length();
		char[] one = new char[26];
		Arrays.fill(one, ' ');
		fillIt(s1, one, length);
		char[] two = new char[26];
		Arrays.fill(two, ' ');

		char c = ' ';
		for (int i = 0; i < length; i++) {
			c = s1.charAt(i);
			if (s2.indexOf(c) == -1) {
				continue;
			}
			String word = s2.substring(s2.indexOf(c));
			int a = 0;
			while (a != -1 && word.length() >= length) {
				fillIt(word, two, length);
				if (Arrays.equals(one, two))
					return true;
				Arrays.fill(two, ' ');
				word = word.substring(1);
				a = word.indexOf(c);
				if (a != -1)
					word = word.substring(a);
			}
			if (i > s2.length()) {
				break;
			}
		}
		return false;
	}

	public static void fillIt(String s, char[] ch, int len) {
		for (int i = 0; i < len; i++) {
			ch[s.charAt(i) - 'a']++;
		}
	}

	// Time limit exceed
	public static boolean checkInclusion(String s1, String s2) {
		List<String> res = perm("", s1);
		for (String s : res) {
			if (s2.indexOf(s) != -1) {
				return true;
			}
		}
		return false;
	}

	public static List<String> perm(String res, String up) {
		if (up.length() == 0) {
			ArrayList<String> adder = new ArrayList<>();
			adder.add(res);
			System.out.println(res);
			return adder;
		}
		ArrayList<String> fin = new ArrayList<>();
		for (int i = 0; i <= res.length(); i++) {
			String first = res.substring(0, i);
			char ch = up.charAt(0);
			String end = res.substring(i);
			fin.addAll(perm(first + ch + end, up.substring(1)));
		}
		return fin;
	}
}
