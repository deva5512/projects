package Medium;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DesignAddSearch_211 {
	static Scanner s = new Scanner(System.in);
	Set<String> arr;

	public DesignAddSearch_211() {
		arr = new LinkedHashSet<>();
		arr.add("");
	}

	public void addWord(String word) {
		arr.add(word);
	}

//	public boolean search(String word) {
//		// To check the word contain dot or not;
//		if (word.indexOf('.') == -1) {
//			return arr.contains(word);
//		}
//
//		// To find does the full word is of dot;
//		int dots = 0;
//		for (int i = 0; i < word.length(); i++) {
//			if (word.charAt(i) == '.')
//				dots++;
//			else
//				break;
//		}
//
//		// If the words full of dot dot verifier will become true;
//		boolean dotverifier = false;
//		if (dots == word.length()) {
//			dotverifier = true;
//		}
//		int len = word.length();
//		for (String str : arr) {
//			if (str.length() == len) {
//				if (dotverifier)
//					return true;
//
//				// If the word is not a full doted word it will check with the other words
//				for (int i = 0; i < len; i++) {
//					if (word.charAt(i) != '.' && word.charAt(i) != str.charAt(i))
//						break;
//					if (i == len - 1)
//						return true;
//				}
//			}
//		}
//		return false;
//	}

	public boolean search(String word) {
		// To check the word contain dot or not;
		if (word.indexOf('.') == -1) {
			return arr.contains(word);
		}

		// To find does the full word is of dot;
		boolean dotverifier = false;
		if (word.length() == 3 && word.charAt(0) == '.' && word.charAt(1) == '.' && word.charAt(2) == '.') {
			dotverifier = true;
		}

		int len = word.length();
		for (String str : arr) {
			if (str.length() == len) {
				if (dotverifier)
					return true;

				// If the word is not a full doted word it will check with the other words
				for (int i = 0; i < len; i++) {
					if (word.charAt(i) != '.' && word.charAt(i) != str.charAt(i))
						break;
					if (i == len - 1)
						return true;
				}
			}
		}
		return false;
	}

//	public boolean search1(String word) {
//		// To check the word contain dot or not;
//		if (word.indexOf('.') == -1) {
//			return arr.contains(word);
//		}
//
//		// To find does the full word is of dot;
//		boolean dotverifier = false;
//		if (word.length() == 3 && word.charAt(0) == '.' && word.charAt(1) == '.' && word.charAt(2) == '.') {
//			dotverifier = true;
//		}
//
//		int len = word.length();
//		for (String str : arr) {
//			if (str.length() == len) {
//				if (dotverifier)
//					return true;
//
//				// If the word is not a full doted word it will check with the other words
//				int mid = len / 2;
//				for (int i = 0, j = len - 1; i <= j; i++, j++) {
//					if (word.charAt(i) != '.' && word.charAt(i) != str.charAt(i))
//						break;
//					if (word.charAt(i) != '.' && word.charAt(i) != str.charAt(i))
//						break;
//					if (i == mid)
//						return true;
//				}
//			}
//		}
//		return false;
//	}

	public static void main(String[] args) {
		DesignAddSearch_211 d = new DesignAddSearch_211();
		d.addWord("ab");
		System.out.println(d.search(".."));
	}
}
