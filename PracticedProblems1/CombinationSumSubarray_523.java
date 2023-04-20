package Medium;


public class CombinationSumSubarray_523 {
	public static void main(String[] args) {
		int[] arr = {23,2,6,4,7};
		System.out.println(checkSubarraySum(arr, 6));
		
		
		
	}

	public static boolean checkSubarraySum(int[] nums, int k) {

		int i = 0;
		int addition = 0;
		int verification = 0;
		
		while (i < nums.length) {
			if (addition == k) {
				return true;
			}
			if (nums[i] > k || addition > k) {
				i++;
				addition = 0;
				continue;
			}
			if (nums[i] < k && addition < k) {
				addition += nums[i];
				i++;
			}else {
				i++;
				addition = 0;
			}
		}
		if (total(nums) % k == 0) {
			return true;
		}

		return false;

	}

	public static int total(int[] a) {
		int total = 0;
		for (int i : a) {
			total += i;
		}
		return total;
	}
}
