package WeeklyAssignment;

public class PrintPath {
	public static void main(String[] args) {
		int[][] board = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		path(board, 0, 0, "");
	}

	public static void path(int[][] board, int row, int col, String res) {
		if (row >= board.length - 1 && col >= board[0].length - 1) {
			System.out.println(res);
			return;
		}

		if (row < board.length - 1) {
			path(board, row + 1, col, res + "D");
		}

		if (col < board[0].length - 1) {
			path(board, row, col + 1, res + "R");
		}
	}
}
