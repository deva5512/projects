package WeeklyAssignment;

import java.util.Arrays;
import java.util.Comparator;

public class SortBasedOnWeight {
	public static void main(String[] args) {
		int[] arr = { 49, 36, 8, 10, 12 };
		sort(arr);
	}

	public static void sort(int[] arr) {
		int[][] weight = new int[arr.length][2];
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			int w = 0;
			if (Math.sqrt(num) % 1 == 0) {
				w += 5;
			}
			if (num % 4 == 0 && num % 6 == 0) {
				w += 4;
			}
			if ((num & 1) == 0) {
				w += 3;
			}
			weight[i][0] = num;
			weight[i][1] = w;
		}

		Comparator<int[]> comp = (a, b) -> b[1] - a[1];

		Arrays.sort(weight, comp);

		for (int[] a : weight) {
			System.out.println(Arrays.toString(a));
		}
	}
}
