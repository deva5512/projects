package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak_139 {
	public static void main(String[] args) {
		System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
	}

	public static boolean wordBreak1(String s, List<String> wordDict) {

		StringBuilder word = new StringBuilder(s);
		int len = word.length();
		int i = 0;
		while (i < len) {
			if (wordDict.contains(word.substring(i, len))) {
				word.delete(i, len);
				i = 0;
				len = word.length();
			} else
				i++;
		}
		if (word.length() == 0) {
			return true;
		}

		return false;
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		boolean[] check = new boolean[n];
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				String word = s.substring(j, i);
				if ((j == 0 || check[j-1]) && wordDict.contains(word)) {
					check[i - 1] = true;
					break;
				}
			}
		}
		return check[n - 1];
	}
}
