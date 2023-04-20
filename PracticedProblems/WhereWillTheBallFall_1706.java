package Medium;

import java.util.Arrays;

public class WhereWillTheBallFall_1706 {
	public static void main(String[] args) {
		int[][] a = { { 1, 1, 1, -1, -1 }, { 1, 1, 1, -1, -1 }, { -1, -1, -1, 1, 1 }, { 1, 1, 1, 1, -1 },
				{ -1, -1, -1, -1, -1 } };
		int[][] b = { { -1 } };
		int[][] c = { { 1, 1, 1, 1, 1, 1 }, { -1, -1, -1, -1, -1, -1 }, { 1, 1, 1, 1, 1, 1 },
				{ -1, -1, -1, -1, -1, -1 } };

		// [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]

		System.out.println(Arrays.toString(findBall(c)));
	}

	public static int[] findBall(int[][] grid) {

		int res[] = new int[grid[0].length];
		boolean changed = true;
		for (int cols = 0; cols < grid[0].length; cols++) {
			int sub_col = cols;
			inner: for (int row = 0; row < grid.length; row++) {

				if (sub_col != grid[0].length - 1 && grid[row][sub_col] == 1) {
					if (sub_col != grid[0].length - 1 && grid[row][sub_col] != grid[row][sub_col + 1])
						break inner;
					sub_col++;
				} else if (sub_col != 0 && grid[row][sub_col] == -1) {
					if (sub_col != 0 && grid[row][sub_col] != grid[row][sub_col - 1])
						break inner;
					sub_col--;
				} else {
					break inner;
				}
				if (row == grid.length - 1) {
					res[cols] = sub_col;
					changed = false;
				}
			}
			if (changed)
				res[cols] = -1;
			changed = true;
		}
		return res;
	}
}
