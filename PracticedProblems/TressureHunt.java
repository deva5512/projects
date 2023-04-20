package WeeklyAssignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TressureHunt {

	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		TressureHunt d = new TressureHunt();

		System.out.println("Enter size of dungen (R,C) : ");
		String[] dun = s.nextLine().split(",");
//		String[] dun = "5,4".split(",");
		int drow = Integer.parseInt(dun[0]);
		int dcol = Integer.parseInt(dun[1]);

		System.out.println("Enter the Position of Gold (R,C) : ");
		String[] gold = s.nextLine().split(",");
//		String[] gold = "1,3".split(",");
		int grow = Integer.parseInt(gold[0]) - 1;
		int gcol = Integer.parseInt(gold[1]) - 1;

		System.out.println("Enter the Position of adventure (R,C) : ");
		String[] adv = s.nextLine().split(",");
//		String[] adv = "4,1".split(",");
		int arow = Integer.parseInt(adv[0]) - 1;
		int acol = Integer.parseInt(adv[1]) - 1;

		System.out.println("Enter the Position of monster (R,C) : ");
		String[] mon = s.nextLine().split(",");
//		String[] mon = "1,1".split(",");
		int mrow = Integer.parseInt(mon[0]) - 1;
		int mcol = Integer.parseInt(mon[1]) - 1;

		System.out.println("Enter the Position of Triger (R,C) : ");
		String[] tri = s.nextLine().split(",");
//		String[] tri = "4,4".split(",");
		int rtri = Integer.parseInt(tri[0]) - 1;
		int ctri = Integer.parseInt(tri[1]) - 1;

		char[][] dungern = new char[drow][dcol];
		dungern[arow][acol] = 'A';
		dungern[grow][gcol] = 'G';
		dungern[mrow][mcol] = 'M';
		dungern[rtri][ctri] = 'T';

		System.out.println("Enter the number of pits : ");
		int size = s.nextInt();
		for (int i = 0; i < size; i++) {
			System.out.print("Enter the row : ");
			int r = s.nextInt();
			System.out.print("Enter the col : ");
			int c = s.nextInt();
			dungern[r - 1][c - 1] = 'P';
		}

		d.level1(dungern, new int[] { arow, acol });
		d.level2(dungern, new int[] { arow, acol }, new int[] { mrow, mcol });
		d.level3(dungern, new int[] { arow, acol }, new int[] { mrow, mcol });
		d.level4(dungern, new int[] { arow, acol }, new int[] { mrow, mcol });
		d.level5(dungern, new int[] { arow, acol });
		d.level6(dungern, new int[] { arow, acol }, new int[] { mrow, mcol });
		d.level7(dungern, new int[] { arow, acol }, new int[] { mrow, mcol });
	}

	public void level1(char[][] arr, int[] adv) {

		boolean[][] advcheck = new boolean[arr.length][arr[0].length];

		Queue<int[]> aouter = new LinkedList<>();
		aouter.offer(adv);
		int count = 0;

		while (!aouter.isEmpty()) {
			Queue<int[]> ainner = new LinkedList<>();

			while (!aouter.isEmpty()) {
				int[] ind = aouter.poll();
				int arow = ind[0];
				int acol = ind[1];

				if (arr[arow][acol] == 'G') {
					System.out.println("Number of Steps : " + count);
					return;
				}

				if (arow > 0 && !advcheck[arow - 1][acol]) {
					ainner.add(new int[] { arow - 1, acol });
					advcheck[arow - 1][acol] = true;
				}
				if (acol > 0 && !advcheck[arow][acol - 1]) {
					ainner.add(new int[] { arow, acol - 1 });
					advcheck[arow][acol - 1] = true;
				}
				if (arow < arr.length - 1 && !advcheck[arow + 1][acol]) {
					ainner.add(new int[] { arow + 1, acol });
					advcheck[arow + 1][acol] = true;
				}
				if (acol < arr[0].length - 1 && !advcheck[arow][acol + 1]) {
					ainner.add(new int[] { arow, acol + 1 });
					advcheck[arow][acol + 1] = true;
				}
			}
			count++;
			aouter = ainner;
		}
		System.out.println("Not Found");
		return;
	}

	public void level2(char[][] arr, int[] adv, int[] monster) {

		if (arr[adv[0]][adv[1]] == 'G') {
			System.out.println("Reached Gold in 0 steps ");
			return;
		}
		Queue<int[]> aouter = new LinkedList<>();
		aouter.offer(adv);

		char[][] check = new char[arr.length][arr[0].length];
		check[adv[0]][adv[1]] = 'A';
		check[monster[0]][monster[1]] = 'M';

		Queue<int[]> mouter = new LinkedList<>();
		mouter.offer(monster);

		int[] rmove = { -1, 1, 0, 0 };
		int[] cmove = { 0, 0, -1, 1 };
		int count = 0;

		while (!aouter.isEmpty()) {
			List<int[]> ainner = new LinkedList<>();
			Queue<int[]> minner = new LinkedList<>();

			count++;

			while (!aouter.isEmpty()) {
				int arow = aouter.peek()[0];
				int acol = aouter.poll()[1];

				for (int i = 0; i < rmove.length; i++) {
					int r = arow + rmove[i];
					int c = acol + cmove[i];
					if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && check[r][c] != 'M'
							&& check[r][c] != 'A') {
						if (arr[r][c] == 'G') {
							System.out.println("Number of Steps : " + count);
							return;
						}
						check[r][c] = 'A';
						ainner.add(new int[] { r, c });
					}
				}
			}
			while (!mouter.isEmpty()) {
				int mrow = mouter.peek()[0];
				int mcol = mouter.poll()[1];

				for (int i = 0; i < rmove.length; i++) {
					int r = mrow + rmove[i];
					int c = mcol + cmove[i];
					if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && check[r][c] != 'M') {
						if (arr[mrow][mcol] == 'G') {
							System.out.println("No Way Exist ");
							return;
						}
						check[r][c] = 'M';
						int[] index = new int[] { r, c };
						for (int j = 0; j < ainner.size(); j++) {
							int [] pos = ainner.get(j);
							if (Arrays.equals(pos, index)) {
								ainner.remove(pos);
							}
						}
						minner.offer(index);
					}
				}

			}
			aouter = new LinkedList<>(ainner);
			mouter = minner;
		}
		System.out.println("No Way Exist");
	}

	static class Position {
		int i;
		int j;
		List<int[]> path = new LinkedList<>();

		public Position(int i, int j, List<int[]> path) {
			this.i = i;
			this.j = j;
			this.path = new LinkedList<>(path);
		}
	}

	public void level3(char[][] arr, int[] adv, int[] monster) {
		if (arr[adv[0]][adv[1]] == 'G') {
			System.out.println("Reached Gold in 0 steps ");
			return;
		}
		Queue<Position> aouter = new LinkedList<>();
		aouter.offer(new Position(adv[0], adv[1], Arrays.asList(adv)));

		char[][] check = new char[arr.length][arr[0].length];
		check[adv[0]][adv[1]] = 'A';
		check[monster[0]][monster[1]] = 'M';

		Queue<int[]> mouter = new LinkedList<>();
		mouter.offer(monster);

		int[] rmove = { -1, 1, 0, 0 };
		int[] cmove = { 0, 0, -1, 1 };
		int count = 0;

		while (!aouter.isEmpty()) {
			List<Position> ainner = new LinkedList<>();
			Queue<int[]> minner = new LinkedList<>();

			count++;

			while (!aouter.isEmpty()) {
				int arow = aouter.peek().i;
				int acol = aouter.peek().j;
				List<int[]> moves = aouter.poll().path;

				for (int i = 0; i < rmove.length; i++) {
					int r = arow + rmove[i];
					int c = acol + cmove[i];
					if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && check[r][c] != 'M'
							&& check[r][c] != 'A') {
						moves.add(new int[] { r, c });
						if (arr[r][c] == 'G') {
							System.out.println("Number of Steps : " + count);
							for (int[] a : moves) {
								System.out.println("[" + (a[0] + 1) + "," + (a[1] + 1) + "]");
							}
							return;
						}
						check[r][c] = 'A';
						ainner.add(new Position(r, c, moves));
						moves.remove(moves.size() - 1);
					}
				}
			}

			while (!mouter.isEmpty()) {

				int mrow = mouter.peek()[0];
				int mcol = mouter.poll()[1];

				for (int i = 0; i < rmove.length; i++) {
					int r = mrow + rmove[i];
					int c = mcol + cmove[i];
					if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && check[r][c] != 'M') {
						if (arr[mrow][mcol] == 'G') {
							System.out.println("No Way Exist ");
							return;
						}
						check[r][c] = 'M';
						int[] index = new int[] { r, c };
						for (int j = 0; j < ainner.size(); j++) {
							Position pos = ainner.get(j);
							if (r == pos.i && c == pos.j) {
								ainner.remove(pos);
							}
						}
						minner.offer(index);
					}
				}
			}

			aouter = new LinkedList<>(ainner);
			mouter = minner;
		}
		System.out.println("No Way Exist");
	}

	public void level4(char[][] arr, int[] adv, int[] monster) {
		if (arr[adv[0]][adv[1]] == 'G') {
			System.out.println("Reached Gold in 0 steps ");
			return;
		}
		Queue<int[]> aouter = new LinkedList<>();
		aouter.offer(adv);

		char[][] check = new char[arr.length][arr[0].length];
		check[adv[0]][adv[1]] = 'A';
		check[monster[0]][monster[1]] = 'M';

		Queue<int[]> mouter = new LinkedList<>();
		mouter.offer(monster);

		int[] rmove = { -1, 1, 0, 0 };
		int[] cmove = { 0, 0, -1, 1 };
		int count = 0;

		boolean alive = true;

		while (!aouter.isEmpty()) {
			List<int[]> ainner = new LinkedList<>();
			Queue<int[]> minner = new LinkedList<>();

			count++;

			while (!aouter.isEmpty()) {
				int arow = aouter.peek()[0];
				int acol = aouter.poll()[1];

				for (int i = 0; i < rmove.length; i++) {
					int r = arow + rmove[i];
					int c = acol + cmove[i];
					if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && check[r][c] != 'M'
							&& check[r][c] != 'A') {
						if (arr[r][c] == 'G') {
							System.out.println("Number of Steps : " + count);
							return;
						}

						if (arr[r][c] == 'T') {
							for (char[] a : check) {
								Arrays.fill(a, ' ');
							}
							alive = false;
						}

						check[r][c] = 'A';
						ainner.add(new int[] { r, c });
					}
				}
			}

			if (alive) {
				while (!mouter.isEmpty()) {

					int mrow = mouter.peek()[0];
					int mcol = mouter.poll()[1];

					for (int i = 0; i < rmove.length; i++) {
						int r = mrow + rmove[i];
						int c = mcol + cmove[i];
						if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && check[r][c] != 'M'
								&& check[r][c] != 'T') {
							check[r][c] = 'M';
							if (arr[mrow][mcol] == 'G') {
								alive = false;
								break;
							}
							int[] index = new int[] { r, c };
							for (int j = 0; j < ainner.size(); j++) {
								int [] pos = ainner.get(j);
								if (Arrays.equals(pos, index)) {
									ainner.remove(pos);
								}
							}
							minner.offer(index);
						}
					}
				}

			}
			aouter = new LinkedList<>(ainner);
			mouter = minner;
		}
		System.out.println("No Way Exist");
	}

	public void level5(char[][] arr, int[] adv) {
		if (arr[adv[0]][adv[1]] == 'G') {
			System.out.println("Reached Gold in 0 steps ");
			return;
		}
		Queue<int[]> aouter = new LinkedList<>();
		aouter.offer(adv);

		char[][] check = new char[arr.length][arr[0].length];
		check[adv[0]][adv[1]] = 'A';

		int[] rmove = { -1, 1, 0, 0 };
		int[] cmove = { 0, 0, -1, 1 };
		int count = 0;

		while (!aouter.isEmpty()) {
			Queue<int[]> ainner = new LinkedList<>();

			count++;

			while (!aouter.isEmpty()) {
				int arow = aouter.peek()[0];
				int acol = aouter.poll()[1];

				for (int i = 0; i < rmove.length; i++) {
					int r = arow + rmove[i];
					int c = acol + cmove[i];
					if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && check[r][c] != 'A'
							&& arr[r][c] != 'P') {
						if (arr[r][c] == 'G') {
							System.out.println("Number of Steps : " + count);
							return;
						}
						check[r][c] = 'A';
						ainner.offer(new int[] { r, c });
					}
				}
			}

			aouter = ainner;
		}
		System.out.println("No Way Exist");
	}

	public void level6(char[][] arr, int[] adv, int[] monster) {
		if (arr[adv[0]][adv[1]] == 'G') {
			System.out.println("Reached Gold in 0 steps ");
			return;
		}
		Queue<int[]> aouter = new LinkedList<>();
		aouter.offer(adv);

		char[][] check = new char[arr.length][arr[0].length];
		check[adv[0]][adv[1]] = 'A';
		check[monster[0]][monster[1]] = 'M';

		Queue<int[]> mouter = new LinkedList<>();
		mouter.offer(monster);

		int[] rmove = { -1, 1, 0, 0 };
		int[] cmove = { 0, 0, -1, 1 };
		int count = 0;

		while (!aouter.isEmpty()) {
			List<int[]> ainner = new LinkedList<>();
			Queue<int[]> minner = new LinkedList<>();

			count++;

			while (!aouter.isEmpty()) {
				int arow = aouter.peek()[0];
				int acol = aouter.poll()[1];

				for (int i = 0; i < rmove.length; i++) {
					int r = arow + rmove[i];
					int c = acol + cmove[i];
					if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && check[r][c] != 'M'
							&& check[r][c] != 'A' && arr[r][c] != 'P') {
						if (arr[r][c] == 'G') {
							System.out.println("Number of Steps : " + count);
							return;
						}
						check[r][c] = 'A';
						ainner.add(new int[] { r, c });
					}
				}
			}
			while (!mouter.isEmpty()) {
				int mrow = mouter.peek()[0];
				int mcol = mouter.poll()[1];

				for (int i = 0; i < rmove.length; i++) {
					int r = mrow + rmove[i];
					int c = mcol + cmove[i];
					if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && check[r][c] != 'M') {
						if (arr[mrow][mcol] == 'G') {
							System.out.println("No Way Exist ");
							return;
						}
						check[r][c] = 'M';
						int[] index = new int[] { r, c };
						for (int j = 0; j < ainner.size(); j++) {
							int [] pos = ainner.get(j);
							if (Arrays.equals(pos, index)) {
								ainner.remove(pos);
							}
						}
						minner.offer(index);
					}
				}

			}
			aouter = new LinkedList<>(ainner);
			mouter = minner;
		}
		System.out.println("No Way Exist");
	}

	public void level7(char[][] arr, int[] adv, int[] monster) {
		if (arr[adv[0]][adv[1]] == 'G') {
			System.out.println("Reached Gold in 0 steps ");
			return;
		}
		Queue<int[]> aouter = new LinkedList<>();
		aouter.offer(adv);

		char[][] check = new char[arr.length][arr[0].length];
		check[adv[0]][adv[1]] = 'A';
		check[monster[0]][monster[1]] = 'M';

		Queue<int[]> mouter = new LinkedList<>();
		mouter.offer(monster);

		int[] rmove = { -1, 1, 0, 0 };
		int[] cmove = { 0, 0, -1, 1 };
		int count = 0;

		boolean alive = true;

		while (!aouter.isEmpty()) {
			List<int[]> ainner = new LinkedList<>();
			Queue<int[]> minner = new LinkedList<>();

			count++;

			while (!aouter.isEmpty()) {
				int arow = aouter.peek()[0];
				int acol = aouter.poll()[1];

				for (int i = 0; i < rmove.length; i++) {
					int r = arow + rmove[i];
					int c = acol + cmove[i];
					if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && check[r][c] != 'M'
							&& check[r][c] != 'A' && arr[r][c] != 'P') {
						if (arr[r][c] == 'G') {
							System.out.println("Number of Steps : " + count);
							return;
						}

						check[r][c] = 'A';
						ainner.add(new int[] { r, c });

						if (arr[r][c] == 'T') {
							for (char[] a : check) {
								Arrays.fill(a, ' ');
							}
							check[r][c] = 'A';
							ainner.clear();
							aouter.clear();
							ainner.add(new int[] { r, c });
							alive = false;
							break;
						}
					}
				}
			}

			if (alive) {
				while (!mouter.isEmpty()) {

					int mrow = mouter.peek()[0];
					int mcol = mouter.poll()[1];

					for (int i = 0; i < rmove.length; i++) {
						int r = mrow + rmove[i];
						int c = mcol + cmove[i];
						if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && check[r][c] != 'M'
								&& check[r][c] != 'T') {
							check[r][c] = 'M';
							if (arr[mrow][mcol] == 'G') {
								alive = false;
								break;
							}
							int[] index = new int[] { r, c };
							for (int j = 0; j < ainner.size(); j++) {
								int [] pos = ainner.get(j);
								if (Arrays.equals(pos, index)) {
									ainner.remove(pos);
								}
							}
							minner.offer(index);
						}
					}
				}

			}
			aouter = new LinkedList<>(ainner);
			mouter = minner;
		}
		System.out.println("No Way Exist");
	}
}
