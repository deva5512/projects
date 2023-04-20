package WeeklyAssignment;

import java.util.Arrays;

public class RearrangementOfArrayElements {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 4, 5, 6, 8, 8 };
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
		rearrange(arr);
	}

	public static void rearrange(int[] arr) {
		Arrays.sort(arr);

		int[] temp = arr.clone();

		int a = 0;
		int b = arr.length - 1;

		for (int i = arr.length - 1; i >= 0; i--) {
			if (i % 2 != 0) {
				arr[i] = temp[b--];
			} else {
				arr[i] = temp[a++];
			}
		}

		System.out.println(Arrays.toString(arr));

	}
}
