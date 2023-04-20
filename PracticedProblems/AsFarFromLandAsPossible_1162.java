package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible_1162 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		System.out.println(maxDistance(arr));
	}

	public static int maxDistance(int[][] grid) {
		int res = -1;

		// Using a queue to trace the records
		Queue<int[]> queue = new LinkedList<>();

		// Find the lands first
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 1) {
					queue.add(new int[] { i, j });
				}
			}
		}

		while (!queue.isEmpty()) {
			Queue<int[]> innerqueue = new LinkedList<>();

			while (!queue.isEmpty()) {

				// Try each lands and change the nearby positions as lands
				int[] index = queue.poll();
				int row = index[0], col = index[1];
				if (row < grid.length - 1 && grid[row + 1][col] == 0) {
					grid[row + 1][col] = 1;
					innerqueue.add(new int[] { row + 1, col });
				}
				if (col < grid[0].length - 1 && grid[row][col + 1] == 0) {
					grid[row][col + 1] = 1;
					innerqueue.add(new int[] { row, col + 1 });
				}
				if (row > 0 && grid[row - 1][col] == 0) {
					grid[row - 1][col] = 1;
					innerqueue.add(new int[] { row - 1, col });
				}
				if (col > 0 && grid[row][col - 1] == 0) {
					grid[row][col - 1] = 1;
					innerqueue.add(new int[] { row, col - 1 });
				}
			}

			// consider the changed lands as the initial position and continue changing till
			// close the water body
			queue = innerqueue;

			// by increasing the res it will show us how deep we are changing the water to
			// land
			res++;
		}

		return res == 0 ? -1 : res;
	}
}
