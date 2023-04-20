package WeeklyAssignment;

import java.util.Arrays;

public class ArrayRotation {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		rotate(arr, 3);
	}

	public static void rotate(int[] arr, int n) {
		n %= arr.length;
		if (n == 0) {
			return;
		}
		int i = 0, j = arr.length - 1;
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		i = 0;
		j = n-1;
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		i = n;
		j = arr.length-1;
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void leftRotate(int[] arr, int n) {
		n %= arr.length;
		int[] res = new int[arr.length];

		int j = 0;
		for (int i = res.length - n; i < res.length; i++) {
			res[j++] = arr[i];
		}
		int i = 0;
		for (; j < res.length; j++) {
			res[j] = arr[i++];
		}
		System.out.println(Arrays.toString(res));
	}

	public static void rightRotate(int[] arr, int n) {
		n %= arr.length;
		int[] res = new int[arr.length];

		int j = arr.length - 1;
		for (int i = n - 1; i >= 0; i--) {
			res[j--] = arr[i];
		}
		n = arr.length - 1;
		for (; j >= 0; j--) {
			res[j] = arr[n--];
		}
		System.out.println(Arrays.toString(res));
	}
}
