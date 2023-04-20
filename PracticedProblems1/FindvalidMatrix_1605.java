package Medium;

import java.util.Arrays;

public class FindvalidMatrix_1605 {
	public static void main(String[] args) {
		int row[] = { 5, 7, 10 };
		int col[] = { 8, 6, 8 };

		for (int i[] : restoreMatrix(row, col)) {
			System.out.println(Arrays.toString(i));
		}
	}

	public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
		int[][] result = new int[rowSum.length][colSum.length];

		int val = 0;
		for (int i = rowSum.length - 1; i >= 0; i--) {
			for (int j = colSum.length - 1; j >= 0; j--) {

				// Find the minimum of rowsum of i and colsum of j assign the value
				if (rowSum[i] < colSum[j]) {
					val = rowSum[i];
					result[i][j] = val;
					colSum[j] -= val;
					rowSum[i] -= val;
				} else {
					val = colSum[j];
					result[i][j] = val;
					rowSum[i] -= val;
					colSum[j] -= val;
				}
			}
		}
		return result;
	}
}
