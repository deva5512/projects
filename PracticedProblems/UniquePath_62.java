package Medium;

public class UniquePath_62 {
	public static void main(String[] args) {
		System.out.println(uniquePaths(4, 4));
	}

	public static int uniquePaths(int m, int n) {
		int[][] board = new int[m][n];
		for (int i = 0; i < n; i++) {
			board[0][i] = 1;
		}
		for (int i = 0; i < m; i++) {
			board[i][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				board[i][j] = board[i - 1][j] + board[i][j - 1];
			}
		}
		return board[m - 1][n - 1];
	}

	public static int uniquePaths1(int m, int n) {
		int[][] board = new int[m][n];
		return helper(0, 0, board);
	}

	public static int helper(int row, int col, int[][] board) {
		if (row == board.length - 1 && col == board[0].length - 1) {
			return 1;
		}
		int ways = 0;
		if (row < board.length - 1) {
			ways += helper(row + 1, col, board);
		}
		if (col < board[0].length - 1) {
			ways += helper(row, col + 1, board);
		}
		return ways;
	}
}
