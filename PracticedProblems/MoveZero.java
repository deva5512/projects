package WeeklyAssignment;

import java.util.Arrays;

public class MoveZero {
	public static void main(String[] args) {
		int[] arr = { 5, 0, 1, 0, 2, 0, 0 };
		System.out.println(Arrays.toString(arr));
		moveZeros(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void moveZeros(int[] arr) {
		int m = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[m++] = arr[i];
			}
		}
		for (; m < arr.length; m++) {
			arr[m] = 0;
		}
	}
}
