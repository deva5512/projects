package Medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {
	public static void main(String[] args) {
		int num[] = { 1};
		System.out.println(Arrays.toString(searchRange(num, 1)));
	}

	public static int[] searchRange(int[] a, int target) {
		int[] res = { -1, -1 };
		int verify = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == target && verify == 0) {
				res[0] = i;
				res[1] = i;
				verify++;
			} else if (verify == 1) {
				if (a[i] == target)
					res[1] = i;
				else
					break;
			}
		}
		return res;
	}
}
