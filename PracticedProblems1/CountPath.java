package WeeklyAssignment;

public class CountPath {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		System.out.println(path(board, 0, 0));
	}

	public static int path(int[][] board, int row, int col) {
		if (row >= board.length - 1 && col >= board[0].length - 1) {
			return 1;
		}

		int count = 0;
		if (row < board.length - 1) {
			count += path(board, row + 1, col);
		}

		if (col < board[0].length - 1) {
			count += path(board, row, col + 1);
		}
		return count;
	}
}
