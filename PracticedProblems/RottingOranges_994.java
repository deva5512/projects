package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_994 {

	public static void main(String[] args) {
		int[][] arr = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(orangesRotting(arr));
	}

	public static int orangesRotting(int[][] grid) {

		int min = -1 , good = 0;;

		Queue<int[]> outer = new LinkedList<>();
		
		for(int i = 0;i<grid.length;i++) {
			for(int j = 0;j<grid[i].length;j++) {
				if(grid[i][j] == 2) {
					outer.add(new int [] {i , j});
				}else if(grid[i][j] == 1) {
					good++;
				}
			}
		}
		
		if(outer.isEmpty() && good == 0) {
			return 0;
		}

		while (!outer.isEmpty()) {

			Queue<int[]> inner = new LinkedList<>();

			while (!outer.isEmpty()) {
				int[] index = outer.poll();
				int row = index[0];
				int col = index[1];

				if (row > 0 && grid[row - 1][col] == 1) {
					grid[row - 1][col] = 2;
					good--;
					inner.offer(new int[] { row - 1, col });
				}
				if (row < grid.length - 1 && grid[row + 1][col] == 1) {
					good--;
					grid[row + 1][col] = 2;
					inner.offer(new int[] { row + 1, col });
				}
				if (col > 0 && grid[row][col - 1] == 1) {
					good--;
					grid[row][col - 1] = 2;
					inner.offer(new int[] { row, col - 1 });
				}
				if (col < grid[0].length - 1 && grid[row][col + 1] == 1) {
					good--;
					grid[row][col + 1] = 2;
					inner.offer(new int[] { row, col + 1 });
				}
			}
			min++;
			outer = inner;
		}
		if(good != 0) {
			return -1;
		}
		return min;
	}
}
