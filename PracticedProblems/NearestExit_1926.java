package Medium;

import java.util.LinkedList;
import java.util.Queue;

import javax.security.auth.login.AccountLockedException;

public class NearestExit_1926 {
	public static void main(String[] args) {

		char[][] arr = { { '+', '.', '+', '+', '+', '+', '+' }, { '+', '.', '+', '.', '.', '.', '+' },
				{ '+', '.', '+', '.', '+', '.', '+' }, { '+', '.', '.', '.', '+', '.', '+' },
				{ '+', '+', '+', '+', '+', '.', '+' } };

		System.out.println(nearestExit1(arr, new int[] { 3, 2 }));
		// ['+','.','+','+','+','+','+'],['+','.','+','.','.','.','+'],['+','.','+','.','+','.','+'],['+','.','.','.','+','.','+'],['+','+','+','+','+','.','+']
	}

	public static int nearestExit(char[][] maze, int[] entrance) {
		Queue<int[]> outer = new LinkedList<>();
		outer.offer(entrance);
		int res = 1;

		boolean[][] check = new boolean[maze.length][maze[0].length];
		check[entrance[0]][entrance[1]] = true;

		while (!outer.isEmpty()) {
			Queue<int[]> inner = new LinkedList<>();
			while (!outer.isEmpty()) {
				int[] ind = outer.poll();
				int r = ind[0];
				int c = ind[1];
				if (r > 0 && maze[r - 1][c] == '.' && !check[r - 1][c]) {
					inner.add(new int[] { r - 1, c });
					check[r - 1][c] = true;
					if (r - 1 == maze.length - 1 || c == maze[0].length - 1 || r - 1 == 0 || c == 0) {
						return res;
					}
				}
				if (r < maze.length - 1 && maze[r + 1][c] == '.') {
					inner.add(new int[] { r + 1, c });
					check[r + 1][c] = true;
					if (r + 1 == maze.length - 1 || c == maze[0].length - 1 || r + 1 == 0 || c == 0) {
						return res;
					}
				}

				if (c > 0 && maze[r][c - 1] == '.') {
					inner.add(new int[] { r, c - 1 });
					check[r][c - 1] = true;
					if (r == maze.length - 1 || c - 1 == maze[0].length - 1 || r == 0 || c - 1 == 0) {
						return res;
					}
				}
				if (c < maze[0].length - 1 && maze[r][c + 1] == '.') {
					inner.add(new int[] { r, c + 1 });
					check[r][c + 1] = true;
					if (r == maze.length - 1 || c + 1 == maze[0].length - 1 || r == 0 || c + 1 == 0) {
						return res;
					}
				}
			}
			res++;
			outer = inner;
		}
		return -1;
	}

	public static int nearestExit1(char[][] maze, int[] entrance) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(entrance);

		boolean[][] check = new boolean[maze.length][maze[0].length];
		check[entrance[0]][entrance[1]] = true;

		int res = 0;
		int[] rows = { 0, 0, 1, -1 };
		int[] cols = { 1, -1, 0, 0 };
		while (!queue.isEmpty()) {
			res++;
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				int[] ind = queue.poll();
				for (int i = 0; i < rows.length; i++) {
					int r = rows[i] + ind[0];
					int c = cols[i] + ind[1];

					if (r >= 0 && c >= 0 && r < check.length && c < check[0].length && maze[r][c] == '.'
							&& !check[r][c]) {
						if ((r == maze.length - 1 || c == maze[0].length - 1 || r == 0 || c == 0)) {
							return res;
						}
						check[r][c] = true;
						queue.offer(new int[] { r, c });
					}
				}
			}
		}
		return -1;
	}
}
