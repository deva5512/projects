package WeeklyAssignment;

public class Minimumlengthpath {
	public static void main(String[] args) {
		int[][] board = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(path(board, 0, 0, 0, 8));
	}

	public static boolean path(int[][] board, int row, int col, int sum, int target) {
		if (row >= board.length - 1 && col >= board[0].length - 1) {
			sum += board[row][col];
			if (sum == target)
				return true;
		}

		if (row < board.length - 1 && path(board, row + 1, col, sum + board[row][col], target)) {
			return true;
		}

		if (col < board[0].length - 1 && path(board, row, col + 1, sum + board[row][col], target)) {
			return true;
		}
		return false;
	}
}
