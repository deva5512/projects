package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement_229 {

	public static void main(String[] args) {
		int[] a = { 2 ,2};
		majorityElement(a);
	}

	public static List<Integer> majorityElement(int[] nums) {
		Arrays.sort(nums);
		int count = nums.length / 3;
		ArrayList<Integer> res = new ArrayList<>();

		int num_count = 0;

		int i = 0, j = nums[0];
		while (i < nums.length) {
			if (nums[i] == j) {
				num_count++;
				i++;
			} else {
				if (num_count > count) {
					res.add(nums[i - 1]);
				}
				num_count = 1;
				j = nums[i];
				i++;
			}
		}

		if (num_count > count) {
			res.add(nums[i - 1]);
		}
		System.out.println(res);
		return res;

	}
}
