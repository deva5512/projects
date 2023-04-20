package Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakeAndLadder_909 {

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, -1 }, { 1, 1, 1 }, { -1, 1, 1 }, };

		// [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
		// [-1,-1,-1],[-1,9,8],[-1,8,9]
		// [[1,1,-1],[1,1,1],[-1,1,1]]
//		int res = snakesAndLadders(arr);
//		System.out.println(res);
		System.out.println();
	}

	public static int snakesAndLadders(int[][] board) {

		int size = board.length * board.length;
		int n = board.length;
		boolean check = board.length % 2 == 0;

		Queue<Integer> outer = new LinkedList<>();
		Set<Integer> pre = new HashSet<>();
		outer.add(1);
		int res = 0;

		while (!outer.isEmpty()) {

			Queue<Integer> inner = new LinkedList<>();
			res++;

			while (!outer.isEmpty()) {
				int start = outer.poll();

				if(pre.contains(start)) {
					continue;
				}
				for (int i = 1; i <= 6; i++) {
					int pos = start + i;

					if (pre.add(pos)) {

						int[] ind = pos(pos, n, check);

						if (board[ind[0]][ind[1]] != -1) {
							inner.add(board[ind[0]][ind[1]]);
							pos = board[ind[0]][ind[1]];
						} else {
							inner.add(pos);
						}

						if (pos == size) {
							return res;
						}

					}
				}

			}
			outer = inner;

		}
		return -1;

	}

	public static int[] pos(int pos, int n, boolean check) {

		int row = 0;
		int col = 0;

		boolean last = pos % n == 0;

		if (last) {
			row = pos / n - 1;
		} else {
			row = pos / n;
		}

		if (row % 2 == 0 == check) {
			if (last) {
				col = n - 1;
			} else
				col = pos % n - 1;
		} else {
			col = n - (pos % n);
			if (col == n) {
				col = 0;
			}
		}
		n--;
		row = n - row;
		return new int[] { row, col };
	}

	public static void findInd(int[] res, int[][] board, int moves, int pos, boolean check) {
		if (pos < moves) {
			for (int i = res[0]; i >= 0; i--) {
				if (i % 2 == 0 == check)

					for (int j = res[1] - 1; j >= 0; j--) {
						pos++;
						res[0] = i;
						res[1] = j;
						if (pos == moves) {
							return;
						}
					}
				else
					for (int j = res[1] + 1; j < board.length; j++) {
						pos++;
						res[0] = i;
						res[1] = j;
						if (pos == moves) {
							return;
						}
					}
			}
		} else {
			for (int i = res[0]; i < board.length; i++) {
				if (i % 2 == 0 == check)

					for (int j = res[1] - 1; j >= 0; j--) {
						pos--;
						res[0] = i;
						res[1] = j;
						if (pos == moves) {
							return;
						}
					}
				else
					for (int j = res[1] + 1; j < board.length; j++) {
						pos--;
						res[0] = i;
						res[1] = j;
						if (pos == moves) {
							return;
						}
					}
			}
		}
	}
}
