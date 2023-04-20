package Medium;

public class ArithmaticSlices_413 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3};
		System.out.println(numberOfArithmeticSlices(a));
	}

	public static int numberOfArithmeticSlices(int[] nums) {
		if (nums.length < 3) {
			return 0;
		}
		int count = 0, dif = 0, res = 0;
		for (int a = 1; a < nums.length; a++) {
			dif = nums[a] - nums[a - 1];
			count++;
			for (int i = a + 1; i < nums.length; i++) {
				if (dif == (nums[i] - nums[i - 1])) {
					count++;
				} else
					break;
			}
			res += ((count - 1) > 0) ? count - 1 : 0;
			count = 0;
		}
		return res;
	}

	public static int numberOfArithmeticSlices1(int[] nums) {
		if (nums.length < 3) {
			return 0;
		}
		int count = 0, dif = 0, res = 0;
		for (int a = 1; a < nums.length; a++) {
			dif = nums[a] - nums[a - 1];
			count++;
			for (int i = a + 1; i < nums.length; i++) {
				if (dif == (nums[i] - nums[i - 1])) {
					count++;
				} else
					break;
			}
			if (count > 1) {
				res += 1;
			}
			count = 0;
		}
		return res;
	}
}
