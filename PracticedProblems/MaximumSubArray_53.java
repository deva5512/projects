package Medium;

public class MaximumSubArray_53 {
	public static void main(String[] args) {
		int i[] = { -1, -2, 1 };
		System.out.println(maxSubArray(i));
	}

	public static int maxSubArray(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		int res = Integer.MIN_VALUE;
		int sum = 0;

		int i = 0;
		while (i < nums.length) {
			if (nums[i] + sum > 0) {
				sum += nums[i];
			} else {
				sum = 0;
			}
			if (nums[i] > res)
				res = nums[i];
			else if (sum != 0 && res < sum)
				res = sum;

			i++;
		}

		return res;
	}

	public static int maxSubArray1(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		int res = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] + sum > 0)
				sum += nums[i];
			else {
				res = sum > nums[i] ? sum : nums[i];
				sum = 0;
			}
		}

		return res;
	}
}
