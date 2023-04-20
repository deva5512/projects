package Medium;

public class UniquePaths2_63 {
	public static void main(String[] args) {
		int[][] a = { { 0, 0 }, { 1, 1 }, { 0, 0 } };

		System.out.println(uniquePathsWithObstacles(a));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

		// If first index is the block we can't able to move further so return 0
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}

		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[i].length; j++) {

				// if we found a obstacle convert it into 0
				if (obstacleGrid[i][j] == 1)
					obstacleGrid[i][j] = 0;
				else {

					// Ultimately first index has to be 1
					if (i == 0 && j == 0) {
						obstacleGrid[i][j] = 1;
					}

					// if i or j is first index then its previous element has to be crossed
					else if (i == 0 && obstacleGrid[i][j - 1] == 1) {
						obstacleGrid[i][j] = 1;
					} else if (j == 0 && obstacleGrid[i - 1][j] == 1) {
						obstacleGrid[i][j] = 1;
					}

					// if the position is middle of the array it should crossed the previous path
					else if (i != 0 && j != 0)
						obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
				}
			}
		}
		return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

	// Used to find the no of path by backtracking
	public static int helper(int[][] grid, int row, int col) {

		if (grid[row][col] == 1) {
			return 0;
		}
		if (row == grid.length - 1 && col == grid[0].length - 1) {
			return 1;
		}
		int count = 0;
		if (row < grid.length - 1) {
			count += helper(grid, row + 1, col);
		}
		if (col < grid[0].length - 1) {
			count += helper(grid, row, col + 1);
		}
		return count;
	}
}
