package WeeklyAssignment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateNumber {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 4, 5, 6, 7, 8, 9 };
		System.out.println(duplicate1(arr));
	}

	public static int duplicate(int[] arr) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			if (set.add(arr[i])) {
				return arr[i];
			}
		}
		return -1;
	}

	public static int duplicate1(int... a) {

		int min = Arrays.stream(a).min().getAsInt();
		int max = Arrays.stream(a).max().getAsInt();
		int range = max - min + 1;

		int[] count = new int[range];

		for (int i = 0; i < a.length; i++) {
			int ind = a[i] - min;
			if (count[ind] == 1) {
				return a[i];
			} else {
				count[ind]++;
			}
		}
		return -1;
	}
}
