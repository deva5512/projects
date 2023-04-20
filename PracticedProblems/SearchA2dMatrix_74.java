package Medium;

public class SearchA2dMatrix_74 {
	public static void main(String[] args) {
		int[][] a = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int[][] b = { { 1, 3 } };
//		[[1,3,5,7],[10,11,16,20],[23,30,34,60]]
		System.out.println(searchMatrix(b, 1));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] > target) {
				if (bs(matrix[i - 1], target) != -1)
					return true;
				else
					return false;
			}
		}
		if (matrix[matrix.length - 1][matrix[0].length - 1] >= target) {
			if (bs(matrix[matrix.length - 1], target) != -1)
				return true;
			else
				return false;
		}
		return false;
	}

	public static int bs(int[] matrix, int target) {
		int s = 0;
		int e = matrix.length - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (matrix[mid] == target) {
				return mid;
			} else if (target < matrix[mid]) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		return -1;
	}
}
