package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	public static void main(String[] args) {
		char[][] ch = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		System.out.println(numIslands(ch));

		// ['1','1','1','1','0'],['1','1','0','1','0'],['1','1','0','0','0'],['0','0','0','0','0']
		// ['1','1','0','0','0'],['1','1','0','0','0'],['0','0','1','0','0'],['0','0','0','1','1']
	}

	public static int numIslands(char[][] grid) {
		int number = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
//					helper(grid, i, j);

					// When ever found a 1 bfs function is called and the surrounding ons will be
					// encountered
					bfshelper(grid, i, j);
					number++;
				}
			}
		}
		return number;

	}

	public static void helper(char[][] grid, int row, int col) {
		if (grid[row][col] == '0') {
			return;
		}
		grid[row][col] = '0';

		if (row < grid.length - 1 && grid[row + 1][col] == '1') {
			helper(grid, row + 1, col);
		}
		if (col < grid[0].length - 1 && grid[row][col + 1] == '1') {
			helper(grid, row, col + 1);
		}
		if (row > 0 && grid[row - 1][col] == '1') {
			helper(grid, row - 1, col);
		}
		if (col > 0 && grid[row][col - 1] == '1') {
			helper(grid, row, col - 1);
		}

	}

	public static void bfshelper(char[][] grid, int row, int col) {

		// The outer queue will initially contain the starting position
		Queue<Integer> positions = new LinkedList<>();
		positions.add(row);
		positions.add(col);

		// change the starting position and continue with encountering the enter island
		grid[row][col] = '0';

		while (!positions.isEmpty()) {
			Queue<Integer> inner = new LinkedList<>();

			while (!positions.isEmpty()) {
				row = positions.poll();
				col = positions.poll();

				// Note the points we moved
				if (row < grid.length - 1 && grid[row + 1][col] == '1') {
					grid[row + 1][col] = '0';
					inner.add(row + 1);
					inner.add(col);
				}
				if (col < grid[0].length - 1 && grid[row][col + 1] == '1') {
					grid[row][col + 1] = '0';
					inner.add(row);
					inner.add(col + 1);
				}
				if (row > 0 && grid[row - 1][col] == '1') {
					grid[row - 1][col] = '0';
					inner.add(row - 1);
					inner.add(col);
				}
				if (col > 0 && grid[row][col - 1] == '1') {
					grid[row][col - 1] = '0';
					inner.add(row);
					inner.add(col - 1);
				}
			}

			// reinitialize the moved position in the outer queue and start encountering
			// again
			positions = inner;
		}
	}
}
