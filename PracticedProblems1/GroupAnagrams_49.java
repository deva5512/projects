package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GroupAnagrams_49 {

	public static void main(String[] args) {
		String[] a = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(a));

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		if (strs.length == 1) {
			result.add(new ArrayList<>(Arrays.asList(strs[0])));
			return result;
		}

		HashMap<String, List<String>> combinations = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			String key = sortingWord(strs[i]);
			ArrayList<String> words = new ArrayList<>();
			words.add(strs[i]);
			if (combinations.containsKey(key)) {
				words.addAll(combinations.get(key));
				combinations.put(key, words);
			} else {
				combinations.put(key, words);
			}
		}

		Iterator<String> i = combinations.keySet().iterator();

		while (i.hasNext()) {
			result.add(combinations.get(i.next()));
		}

		return result;

	}

	// Sort the word
	public static String sortingWord(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}

	// Ascii value generator
	public static int askiValue(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int sum = 0, len = s.length() - 1;
		if (len % 2 == 0) {
			sum += (int) s.charAt(len / 2);
		}
		int i = 0, j = len;
		while (i < j) {
			sum += (int) s.charAt(i++);
			sum += (int) s.charAt(j--);

		}
		return sum;
	}

}
