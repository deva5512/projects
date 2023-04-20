package WeeklyAssignment;

import java.util.LinkedList;
import java.util.Queue;

public class rottenOrange {
	public static void main(String[] args) {
		
	}

	public static int rottime(int[][] arr) {

		Queue<int[]> outer = new LinkedList<>();
		int good = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					outer.add(new int[] { i, j });
				} else {
					good++;
				}
			}
		}
		if (outer.isEmpty()) {
			System.out.println("No rotten ");
			return 0;
		}
		int min = -1;
		while (!outer.isEmpty()) {

			Queue<int[]> inner = new LinkedList<>();

			while (!outer.isEmpty()) {
				int[] index = outer.poll();
				int row = index[0];
				int col = index[1];

				if (row > 0 && arr[row - 1][col] == 1) {
					arr[row - 1][col] = 2;
					good--;
					inner.offer(new int[] { row - 1, col });
				}
				if (row < arr.length - 1 && arr[row + 1][col] == 1) {
					good--;
					arr[row + 1][col] = 2;
					inner.offer(new int[] { row + 1, col });
				}
				if (col > 0 && arr[row][col - 1] == 1) {
					good--;
					arr[row][col - 1] = 2;
					inner.offer(new int[] { row, col - 1 });
				}
				if (col < arr[0].length - 1 && arr[row][col + 1] == 1) {
					good--;
					arr[row][col + 1] = 2;
					inner.offer(new int[] { row, col + 1 });
				}
			}
			min++;
			outer = inner;
		}
		return min;
	}
}
