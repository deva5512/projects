package PreparationQuestions.ChainReaction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Model {

	private int[][][] board; // 0 balls , 1 playerid
	private List<Player> list = new ArrayList<>();
	private int ind = 0;

	public void createBoard(int size, List<String> names) {
		this.board = new int[size][size][2];
		for (String name : names) {
			list.add(new Player(name));
		}
	}

	public boolean placePosition() {

		return false;
	}

	public Player getPlayer() {
		if (ind >= list.size())
			ind = 0;
		return list.get(ind++);
	}

	public int[][][] getBoard() {
		return board;
	}

	public boolean isValidIndex(int r, int c, int playerid) {
		if (r >= board.length || c >= board.length || (board[r][c][1] != 0 && board[r][c][1] != playerid))
			return false;
		return true;
	}

	public void placeMode(int r, int c, int playerid) {
		board[r][c][0]++;
		board[r][c][1] = playerid;
		bfs(r, c, playerid);
	}

	private void bfs(int r, int c, int playerid) {
		Queue<int[]> outer = new LinkedList<>();
		outer.offer(new int[] { r, c });
		int n = board.length - 1;

		while (!outer.isEmpty()) {
			Queue<int[]> inner = new LinkedList<>();
			while (!outer.isEmpty()) {
				r = outer.peek()[0];
				c = outer.poll()[1];
				if ((r == 0 && c == 0) || (r == n && c == n) || (r == 0 && c == n) || (r == n && c == 0)) {
					if (board[r][c][0] == 2)
						addToQueue(r, c, n, playerid, inner);
				} else if ((r == 0 || c == 0 || r == n || c == n)) {
					if (board[r][c][0] == 3)
						addToQueue(r, c, n, playerid, inner);
				} else if ((r != 0 && c != 0 && r != n && c != n)) {
					if (board[r][c][0] == 4)
						addToQueue(r, c, n, playerid, inner);
				}
			}
			outer = inner;
		}
	}

	public void addToQueue(int r, int c, int n, int playerid, Queue<int[]> inner) {
		board[r][c][0] = 0;
		board[r][c][1] = 0;
		if (r + 1 <= n) {
			board[r + 1][c][0]++;
			board[r + 1][c][1] = playerid;
			inner.offer(new int[] { r + 1, c });
		}
		if (r - 1 >= 0) {
			board[r - 1][c][0]++;
			board[r - 1][c][1] = playerid;
			inner.offer(new int[] { r - 1, c });
		}
		if (c + 1 <= n) {
			board[r][c + 1][0]++;
			board[r][c + 1][1] = playerid;
			inner.offer(new int[] { r, c + 1 });
		}
		if (r - 1 >= 0) {
			board[r][c - 1][0]++;
			board[r][c - 1][1] = playerid;
			inner.offer(new int[] { r, c - 1 });
		}
	}

	public boolean isPlayerWon(int playerid) {
		int playerblocks = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j][1] != 0) {
					if (board[i][j][1] != playerid)
						return false;
					else
						playerblocks++;
				}
			}
		}
		if (playerblocks == 1)
			return false;
		return true;
	}

}
