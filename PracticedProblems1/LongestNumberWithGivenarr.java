package WeeklyAssignment;

import java.util.Arrays;
import java.util.Comparator;

public class LongestNumberWithGivenarr {
	public static void main(String[] args) {
		int[] arr = { 3, 30, 34, 9, 5 };
		longestNumber(arr);
	}

	public static void longestNumber(int[] arr) {

		String[] array = new String[arr.length];

		for (int i = 0; i < arr.length; i++) {
			array[i] = String.valueOf(arr[i]);
		}

		Comparator<String> comp = (a, b) -> {
			if ((a + b).compareTo(b + a) < 0) {
				return 1;
			} else {
				return -1;
			}
		};
		Arrays.sort(array, comp);

		String res = "";
		for (int i = 0; i < array.length; i++) {
			res += array[i];
		}
		System.out.println(res);
	}
}
