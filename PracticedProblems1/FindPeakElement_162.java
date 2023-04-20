package Medium;

public class FindPeakElement_162 {

	public static void main(String[] args) {
		int[] a = {3,4,3,2,1};
		System.out.println(findPeakElement(a));
	}

	public static int findPeakElement(int[] nums) {
		int i = 0, j = nums.length - 1, mid = 0;

		while (i <= j) {
			mid = (i + j) / 2;

			int num = nums[mid];

			if (mid == 0 || mid == nums.length - 1 || nums[mid - 1] < num && nums[mid + 1] < num)
				break;
			else if (mid > 0 && mid < nums.length - 1 && nums[mid - 1] < num && nums[mid + 1] > num)
				i = mid + 1;
			else
				j = mid - 1;

		}
		return mid;
	}

}
