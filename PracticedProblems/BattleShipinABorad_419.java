package Medium;

public class BattleShipinABorad_419 {

	public static void main(String[] args) {
		char[][] ch = { { 'X', '.', ',', 'X' }, { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' } };
		char[][] ch2 = { { '.', 'X', '.', '.', 'X' },
						{ '.', 'X', '.', '.', 'X' },
						{ '.', '.', '.', '.', 'X' },
						{ 'X', '.', 'X', 'X', '.' },
						{ 'X', '.', '.', '.', 'X' } };
		char[][] ch1 = { { '.', '.' }, { 'X', 'X' } };
		// [['.','X','.','.','X'],['.','X','.','.','X'],['.','.','.','.','X'],['X','.','X','X','.'],['X','.','.','.','X']]

		System.out.println(countBattleships1(ch2));
//		System.out.println(countBattleships1(ch2));
	}

	public static int countBattleships(char[][] board) {

		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					helper(board, i, j);
					count++;
				}
			}
		}
		return count;
	}

	public static void helper(char[][] board, int row, int col) {
		if (row != board.length - 1 && board[row + 1][col] == 'X') {
			for (int i = row; i < board.length; i++) {
				if (board[i][col] == '.')
					break;
				board[i][col] = '.';
			}
		} else if (col != board[0].length - 1 && board[row][col + 1] == 'X') {
			for (int i = col; i < board[0].length; i++) {
				if (board[row][i] == '.')
					break;
				board[row][i] = '.';
			}
		} else {
			board[row][col] = '.';
		}
	}

	public static int countBattleships1(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					helper1(board, i, j);
					count++;
				}
			}
		}
		return count;
	}

	public static void helper1(char[][] board, int row, int col) {
		if (row > board.length - 1 || col > board[0].length - 1 || board[row][col] == '.') {
			return;
		}
		board[row][col] = '.';
		if (row < board.length-1 && board[row + 1][col] == 'X') {
			helper1(board, row + 1, col);
		}
		if (col < board[0].length-1 && board[row][col + 1] == 'X') {
			helper1(board, row, col + 1);
		}
	}

}
