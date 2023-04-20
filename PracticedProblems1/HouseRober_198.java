package Medium;

public class HouseRober_198 {
	public static void main(String[] args) {
		int[] money = { 6, 7, 1, 3, 8 };
		System.out.println(rob(money));
	}

	public static int rob(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		int i = 0;
		boolean flag = true;
		int movement = 0;
		while (i < nums.length - 2) {
			if (i < nums.length - 3 && (nums[i + 3] + nums[i] > nums[i + 2] + nums[i])) {
				nums[i + 3] += nums[i];
				nums[i + 2] += nums[i];
				flag = false;
				movement = 0;
			} else if (flag || (nums[i + 2] - nums[i - 1] + nums[i]) >= nums[i + 2]) {
				nums[i + 2] += nums[i];
				if (!flag) {
					nums[i + 2] -= nums[i - 1];

				}
			}
			if (!flag) {
				movement++;
			}
			if (movement == 2) {
				flag = true;
			}
			i++;
		}
		return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
	}
}
