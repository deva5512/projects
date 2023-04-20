package Medium;

public class MinimumPathSum_64 {

	public static int minPathSum1(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {

				// if i and j are 0 no need to disturb
				if (i == 0 && j == 0) {
					continue;
				}

				// IF i or j is 0 we can't able to add both side negative values
				if (i == 0) {
					a[i][j] += a[i][j - 1];
				} else if (j == 0) {
					a[i][j] += a[i - 1][j];
				}

				// if i and j both are greater then 0 it will check the minimum value in
				// previous steps
				else
					a[i][j] += a[i - 1][j] < a[i][j - 1] ? a[i - 1][j] : a[i][j - 1];
			}
		}
		return a[a.length - 1][a[0].length - 1];
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
		System.out.println(minPathSum1(a));
	}

	static int sum = Integer.MAX_VALUE;

	public static void helper(int[][] grid, int row, int col, int pathsum) {
		if (row >= grid.length - 1 && col >= grid[0].length - 1) {
			pathsum += grid[row][col];
			if (sum > pathsum) {
				sum = pathsum;
			}
			return;
		}
		if (row < grid.length - 1) {
			helper(grid, row + 1, col, pathsum + grid[row][col]);
		}
		if (col < grid[0].length - 1) {
			helper(grid, row, col + 1, pathsum + grid[row][col]);
		}
	}

}
