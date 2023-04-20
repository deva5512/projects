package WeeklyAssignment;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		System.out.println(anagram("list", "tsil"));
	}

	public static boolean anagram(String one, String two) {
		one = one.toLowerCase();
		two = two.toLowerCase();

		int[] first = new int[26];
		int[] second = new int[26];

		for (int i = 0; i < one.length(); i++)
			first[one.charAt(i) - 'a']++;

		for (int i = 0; i < two.length(); i++)
			second[two.charAt(i) - 'a']++;

		return Arrays.equals(first, second);
	}
}
