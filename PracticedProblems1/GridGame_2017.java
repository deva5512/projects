package Medium;

import java.util.ArrayList;
import java.util.List;

public class GridGame_2017 {
	public static void main(String[] args) {
		int[][] arr = { { 20, 3, 20}, { 20, 10, 13} };
		System.out.println(gridGame(arr));
	}

	public static long gridGame(int[][] grid) {
		List<int[]> res = new ArrayList<>();

		path(grid, 0, 0, res, new ArrayList<>(), new long[] { 0 }, grid[0][0]);

		grid[0][0] = 0;

		for (int[] a : res) {
			grid[a[0]][a[1]] = 0;
		}

		res.clear();

		path(grid, 0, 0, res, new ArrayList<>(), new long[] { 0 }, grid[0][0]);

		int sum = 0;

		for (int[] a : res) {
			sum += grid[a[0]][a[1]];
		}

		return sum;
	}

	public static void path(int[][] grid, int i, int j, List<int[]> res, List<int[]> path, long[] max, long total) {
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			if (max[0] < total) {
				max[0] = total;
				res.clear();
				res.addAll(path);
			}
			return;
		}
		if (i == 0) {
			if (i == 0 && j == grid[0].length - 1 || grid[i + 1][j] > grid[i][j + 1]) {
				path.add(new int[] { i + 1, j });
				path(grid, i + 1, j, res, path, max, total + grid[i + 1][j]);
				path.remove(path.size() - 1);
			}
			if (j != grid[0].length - 1) {
				path.add(new int[] { i, j + 1 });
				path(grid, i, j + 1, res, path, max, total + grid[i][j + 1]);
				path.remove(path.size() - 1);
			}
		} else {
			path.add(new int[] { i, j + 1 });
			path(grid, i, j + 1, res, path, max, total + grid[i][j + 1]);
			path.remove(path.size() - 1);
		}
	}
}
