package WeeklyAssignment;

import java.util.Arrays;

public class MatrixRotation {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
	}

	public static void right90(int[][] arr) {
		
	}

	public static void rowSwap(int[][] arr) {
		int i = 0, j = arr.length - 1;
		while (i < j) {
			int[] temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}

	public static void colSwap(int[][] arr) {
		for (int[] a : arr) {
			int i = 0, j = arr[0].length - 1;
			while (i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}

	public static void rightTranspose(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (i > j) {
					int temp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = temp;
				}
			}
		}
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}

	public static void leftTranspose(int[][] arr) {
		int n = arr.length - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i + j < n) {
					int r = n - j;
					int c = n - i;
					int temp = arr[i][j];
					arr[i][j] = arr[r][c];
					arr[r][c] = temp;
				}
			}
		}
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}
