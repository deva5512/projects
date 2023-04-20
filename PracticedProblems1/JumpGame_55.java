package Medium;

import java.util.Arrays;

public class JumpGame_55 {

	public static void main(String[] args) {
		int[] a = {1,1,1,0};
		System.out.println(canJump(a));
	}

	public static boolean canJump(int[] nums) {
		if (nums.length == 0 ) {
			return false;
		}
        if(nums.length == 1)
            return true;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				break;
			int val = nums[i+1];
			boolean verify = false;
			for (int j = i + 1; j <= nums[i]+i+1; j++) {
				if (val <= nums[j]) {
					val = nums[j];
					i = j;
					verify = true;
				}
                if (val + i >= nums.length - 1)
					return true;
			}
			if (val + i >= nums.length - 1) {
				return true;
			}
			if (verify) {
				i--;
			}
		}
		return false;
	}

	public static boolean canJump1(int[] nums) {
		if (nums.length == 1 && nums[0] == 0) {
			return true;
		}
		if (nums.length == 0 || nums[0] == 0) {
			return false;
		}
		int i = 0, verf = 0;

		while (i < nums.length) {
			i += nums[i];
			if (i == verf) {
				break;
			}
			if (i >= nums.length - 1) {
				return true;
			}
			verf = i;
		}
		return canJump(Arrays.copyOfRange(nums, 1, nums.length));
	}
}
