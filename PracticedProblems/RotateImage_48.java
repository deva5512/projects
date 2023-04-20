package Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateImage_48 {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate1(a);
	}

	public static void rotate(int[][] matrix) {
		ArrayList<int[]> arrays = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			arrays.add(matrix[i].clone());
		}
		int k = 0;
		for (int j = matrix[0].length - 1; j >= 0; j--) {
			int[] temp = arrays.get(k++);
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][j] = temp[i];
			}
		}
	}

	public static void rotate1(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				matrix[i][j] = (matrix[i][j] + matrix[j][i]) - (matrix[j][i] = matrix[i][j]);
			}
		}
		for (int[] a : matrix) {
			swap(a);
			System.out.println(Arrays.toString(a));
		}
	}

	public static void swap(int[] a) {
		int i = 0, j = a.length - 1;
		while (i <= j) {
			a[i] = (a[i] + a[j]) - (a[j] = a[i]);
			i++;
			j--;
		}
	}
}
