package Medium;

public class FindMinumum_153 {

	public static void main(String[] args) {
		int[] a = { 3, 4, 5, 1, 2 };
		System.out.println(findMin(a));
		System.out.println(Math.pow(2, Integer.MIN_VALUE));
	}

	public static int findMin(int[] nums) {
		int small = Integer.MAX_VALUE;
		int i = 0, j = nums.length - 1;
		while (i <= j) {
			small = nums[i] < nums[j] ? (nums[i] < small ? nums[i] : small) : (nums[j] < small ? nums[j] : small);
			i++;
			j--;
		}
		return small;
	}
}
