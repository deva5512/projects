package Medium;

import java.util.Arrays;

public class NextGreatestElement_503 {

	public static void main(String[] args) {
		int [] arr = {1,2,1};
		System.out.println(Arrays.toString(nextGreaterElements(arr)));
	}

	public static int[] nextGreaterElements(int[] nums) {
		int[] res = nums.clone();

		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			boolean got = true;
			for (int j = i + 1; j < nums.length; j++) {
				if (val < nums[j]) {
					got = false;
					res[i] = nums[j];
					break;
				}
			}
			if (got) {
				for (int j = 0; j < i; j++) {
					if (val < nums[j]) {
						got = false;
						res[i] = nums[j];
						break;
					}
				}
			}
			if (got) {
				res[i] = -1;
			}
		}
		return res;
	}
}
