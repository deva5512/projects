package WeeklyAssignment;

import java.util.Arrays;

public class SpiralMatrix {
	public static void main(String[] args) {
		spiralMatrix(3, 4);
	}

	public static void spiralMatrix(int row, int col) {
		int rs = 0, cs = 0, re = row - 1, ce = col - 1;
		int a = 1;

		int[][] arr = new int[row][col];

		while (rs <= re && cs <= ce) {
			for (int i = cs; i <= ce; i++) {
				arr[rs][i] = a++;
			}
			rs++;
			for (int i = rs; i <= re; i++) {
				arr[i][ce] = a++;
			}
			ce--;
			if (rs < re)
				for (int i = ce; i >= cs; i--) {
					arr[re][i] = a++;
				}
			re--;
			if (cs < ce)
				for (int i = re; i >= rs; i--) {
					arr[i][cs] = a++;
				}
			cs++;
		}

		for (int[] i : arr) {
			System.out.println(Arrays.toString(i));
		}
	}
}
