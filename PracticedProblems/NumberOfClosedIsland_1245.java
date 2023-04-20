package Medium;

public class NumberOfClosedIsland_1245 {

	public static void main(String[] args) {
		int[][] grid = { 	{ 0, 0, 1, 1, 0, 1, 0, 0, 1, 0 }, 
							{ 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
							{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 }, 
							{ 0, 1, 1, 0, 0, 0, 0, 1, 0, 1 }, 
							{ 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 },
							{ 0, 1, 0, 1, 0, 1, 0, 1, 1, 1 }, 
							{ 1, 0, 1, 0, 1, 1, 0, 0, 0, 1 }, 
							{ 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
							{ 1, 1, 1, 0, 0, 1, 0, 1, 0, 1 }, 
							{ 1, 1, 1, 0, 1, 1, 0, 1, 1, 0 } };

		// [[0,0,1,1,0,1,0,0,1,0],[1,1,0,1,1,0,1,1,1,0],[1,0,1,1,1,0,0,1,1,0],
		// [0,1,1,0,0,0,0,1,0,1],[0,0,0,0,0,0,1,1,1,0],[0,1,0,1,0,1,0,1,1,1],
		// [1,0,1,0,1,1,0,0,0,1],[1,1,1,1,1,1,0,0,0,0],[1,1,1,0,0,1,0,1,0,1],[1,1,1,0,1,1,0,1,1,0]]

		System.out.println(closedIsland(grid));
	}

	public static int closedIsland(int[][] grid) {
		boolean check[][] = new boolean[grid.length][grid[0].length];

		int count = 0;

		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[0].length - 1; j++) {
				if (grid[i][j] == 0 && !check[i][j] && dfs(grid, i, j, check)) {
					count++;
				}
			}
		}
		return count;

	}

	public static boolean dfs(int[][] grid, int i, int j, boolean[][] check) {
		if (i < 0 || j < 0 || i > grid.length || j > grid[0].length) {
			return false;
		}
		if (grid[i][j] == 1 || check[i][j]) {
			return true;
		}
		if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
			if (grid[i][j] == 0) {
				return false;
			}
		}
		check[i][j] = true;

		boolean one = dfs(grid, i + 1, j, check);
		boolean two = dfs(grid, i, j + 1, check);
		boolean three = dfs(grid, i, j - 1, check);
		boolean four = dfs(grid, i - 1, j, check);
		
		return one && two && three && four;
	}
}
