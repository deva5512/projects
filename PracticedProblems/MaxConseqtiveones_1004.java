package Medium;

public class MaxConseqtiveones_1004 {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		System.out.println(longestOnesg(arr, 2));
	}

	// leetcode solution
	public static int longestOnesg(int[] nums, int k) {
		int right, left = 0;
		for (right = 0; right < nums.length; right++) {
			k = k - 1 + nums[right];
			if (k < 0) {
				k = k + 1 - nums[left];
				left++;
			}
		}
		return right - left;
	}

	public static int longestOnes(int[] nums, int k) {
		int temp = k;
		int i = 0, count = 0, j = 0, res = 0;

		while (i < nums.length) {
			if (nums[i] == 1 || temp > 0) {
				if (nums[i] != 1) {
					temp--;
				}
				count++;
				i++;
			} else {
				if (res < count) {
					res = count;
				}

				j++;
				count = 0;
				temp = k;
				i = j;
			}
		}
		return res > count ? res : count;
	}

	public static int longestOnes1(int[] nums, int k) {
		int temp = k;
		int i = 0, res = 0;
		StringBuilder put = new StringBuilder();

		while (i < nums.length) {
			if (nums[i] == 1 || temp > 0) {
				if (nums[i] == 0) {
					temp--;
				}
				put.append(nums[i]);
				i++;
			} else {
				res = Math.max(res, put.length());

				if (k != 0) {
					temp++;
					put.delete(0, put.indexOf("0") + 1);
				} else {
					i++;
					put = new StringBuilder();
				}
			}
		}

		res = Math.max(res, put.length());

		return res;
	}
}
