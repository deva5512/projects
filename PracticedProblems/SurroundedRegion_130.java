package Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegion_130 {
	public static void main(String[] args) {
		char[][] board = { { 'O', 'O', 'O', 'O', 'X', 'X' }, { 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'O', 'X', 'O', 'X', 'O', 'O' }, { 'O', 'X', 'O', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'O' },
				{ 'O', 'X', 'O', 'O', 'O', 'O' } };

		// [['X','X','X','X','X'],['X','O','O','O','X'],['X','X','O','O','X'],['X','X','X','O','X'],['X','O','X','X','X']]
		// [['O','O','O','O','X','X'],['O','O','O','O','O','O'],['O','X','O','X','O','O'],['O','X','O','O','X','O'],['O','X','O','X','O','O'],['O','X','O','O','O','O']]
		for (char[] ch : board) {
			System.out.println(Arrays.toString(ch));
		}
		System.out.println();
		solve(board);
		for (char[] ch : board) {
			System.out.println(Arrays.toString(ch));
		}
	}

	public static void solve(char[][] board) {
		boolean[][] check = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1)
					if (!check[i][j] && board[i][j] == 'O')
						helper(board, check, i, j);
			}
		}

		for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[0].length - 1; j++) {
				if (!check[i][j] && board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}

	}

	public static void helper(char[][] board, boolean[][] check, int i, int j) {
		Queue<int[]> outer = new LinkedList<>();
		outer.add(new int[] { i, j });
		check[i][j] = true;

		while (!outer.isEmpty()) {
			Queue<int[]> inner = new LinkedList<>();
			while (!outer.isEmpty()) {
				int[] ind = outer.poll();
				int row = ind[0];
				int col = ind[1];
				if (row > 0&& !check[row - 1][col] && board[row - 1][col] == 'O') {
					check[row - 1][col] = true;
					inner.add(new int[] { row - 1, col });
				}
				if (col > 0&& !check[row][col - 1]  && board[row][col - 1] == 'O') {
					check[row][col - 1] = true;
					inner.add(new int[] { row, col - 1 });
				}
				if (row < board.length - 1&& !check[row + 1][col] && board[row + 1][col] == 'O') {
					check[row + 1][col] = true;
					inner.add(new int[] { row + 1, col });
				}
				if (col < board[0].length - 1 && !check[row][col + 1] && board[row][col + 1] == 'O') {
					check[row][col + 1] = true;
					inner.add(new int[] { row, col + 1 });
				}
			}
			outer = inner;
		}
	}
}
