package WeeklyAssignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pairs {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		for (int i[] : pair(a, 5)) {
			System.out.println(Arrays.toString(i));
		}
	}

	public static List<int[]> pair(int[] nums, int k) {
		Arrays.sort(nums);

		ArrayList<int[]> res = new ArrayList<>();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++)
				if (nums[i] < nums[j] && (nums[i] + nums[j]) % k == 0)
					res.add(new int[] { nums[i], nums[j] });
		}

		return res;
	}
}
