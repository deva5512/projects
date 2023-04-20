package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum_15 {

	public static void main(String[] args) {
		int[] a = { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };
		System.out.println(threeSum(a));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> ans = new HashSet<>();
		Arrays.sort(nums);
		int b = 0, c = 0;
		for (int a = 0; a < nums.length - 2; a++) {
			if (a == 0 || nums[a] != nums[a - 1]) {
				b = a + 1;
				c = nums.length - 1;
				while (b < c) {
					if (nums[a] + nums[b] + nums[c] == 0) {
						ArrayList<Integer> found = new ArrayList<>();
						found.add(nums[a]);
						found.add(nums[b]);
						found.add(nums[c]);
//						Collections.sort(found);
						ans.add(found);
						b++;
						c--;
						continue;
					}
					if (nums[b] + nums[c] + nums[a] > 0) {
						c--;
					} else {
						b++;
					}
				}
			}
		}
		List<List<Integer>> res = new ArrayList<>(ans);
		return res;
	}
}
