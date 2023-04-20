package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestConsequtiveSequence_128 {

	public static void main(String[] args) {
		int[] arr = { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsequtiveSequence(arr));
	}

	public static int longestConsequtiveSequence(int[] arr) {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		int res = 0;

		for (int i = 0; i < arr.length; i++) {
			if (!list.contains(arr[i] - 1)) {
				int value = arr[i];
				int got = 0;
				while (list.contains(value)) {
					got++;
					value++;
				}
				res = Math.max(got, res);
			}
		}

		return res;
	}
}
