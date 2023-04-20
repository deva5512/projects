package Medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoko_36 {
	public static void main(String[] args) {
		char[][] ch = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

//		[['5','3','.','.','7','.','.','.','.']
//		,['6','.','.','1','9','5','.','.','.']
//		,['.','9','8','.','.','.','.','6','.']
//		,['8','.','.','.','6','.','.','.','3']
//		,['4','.','.','8','.','3','.','.','1']
//		,['7','.','.','.','2','.','.','.','6']
//		,['.','6','.','.','.','.','2','8','.']
//		,['.','.','.','4','1','9','.','.','5']
//		,['.','.','.','.','8','.','.','7','9']]
		System.out.println(isValidSudoku(ch));

	}

	public static boolean isValidSudoku(char[][] board) {

		Set<Character> row = new HashSet<>();
		Set<Character> col = new HashSet<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				char r = board[i][j];
				char c = board[j][i];
				if (r != '.' && (!row.add(r))) {
					return false;
				}
				if (c != '.' && (!col.add(c))) {
					return false;
				}
			}
			row.clear();
			col.clear();
		}

		for (int or = 0; or < board.length; or += 3) {
			for (int oc = 0; oc < board[0].length; oc += 3) {

				Set<Character> small_box = new HashSet<>();
				for (int i = or; i < or + 3; i++) {
					for (int j = oc; j < oc + 3; j++) {
						if (board[i][j] != '.' && (!small_box.add(board[i][j])))
							return false;
					}
				}
				small_box.clear();

			}
		}

		return true;
	}
}

//Set<Character> row = new HashSet<>();
//Set<Character> col = new HashSet<>();
//
//for (int i = 0; i < board.length; i++) {
//	for (int j = 0; j < board[0].length; j++) {
//
//		char r = board[i][j];
//		char c = board[j][i];
//		if (r != '.' && (!row.add(r))) {
//			return false;
//		}
//		if (c != '.' && (!col.add(c))) {
//			return false;
//		}
//	}
//	row.clear();
//	col.clear();
//}
//
//return true;
