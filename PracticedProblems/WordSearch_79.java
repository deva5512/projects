package Medium;

public class WordSearch_79 {
	public static void main(String[] args) {
		char[][] board = { { 'A', 'A', 'A', 'A', 'A', 'A' }, { 'A', 'A', 'A', 'A', 'A', 'A' },
				{ 'A', 'A', 'A', 'A', 'A', 'A' }, { 'A', 'A', 'A', 'A', 'A', 'A' }, { 'A', 'A', 'A', 'A', 'A', 'A' },
				{ 'A', 'A', 'A', 'A', 'A', 'A' }, };
		boolean b[][] = new boolean[board.length][board[0].length];
		String word = "AAAAAAAAAAAAAAa";

		String word1 = "";
		for (char[] ch : board) {
			word1 += new String(ch);
		}

		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word1.indexOf(word.charAt(i)) != -1) {
				count++;
			}
		}

		if (count == word.length()) {
			outer: for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (word.charAt(0) == board[i][j]) {
						helper(board, word, "", b, i, j);
					}
					if (res) {
						break outer;
					}
				}
			}
		}
		System.out.println(res);
	}

	static boolean res = false;

	public static void helper(char[][] board, String word, String up, boolean[][] check, int row, int col) {
		if (word.equals(up)) {
			res = true;
			return;
		}
		if (!up.equals(word.substring(0, up.length())) || up.length() >= word.length() || row > board.length - 1
				|| col > board[0].length - 1 || row < 0 || col < 0 || check[row][col]) {
			return;
		}
		check[row][col] = true;

		up = up + board[row][col];
		if (row < board.length) {
			helper(board, word, up, check, row + 1, col);
		}
		if (col < board[0].length) {
			helper(board, word, up, check, row, col + 1);
		}
		if (col >= 0) {
			helper(board, word, up, check, row, col - 1);
		}
		if (row >= 0) {
			helper(board, word, up, check, row - 1, col);
		}
		check[row][col] = false;
	}
}
