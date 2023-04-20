package Medium;

import java.util.Arrays;

public class SortedColors_75 {
	public static void main(String[] args) {
		int[] a = { 1, 5, 6, 2, 3, 5, 1 };
		sortColors(a);
		System.out.println(Arrays.toString(a));
	}

	public static void sortColors(int[] nums) {
		if (nums.length == 1) {
			return;
		}
		int len = nums.length;
		int[] left = Arrays.copyOfRange(nums, 0, len / 2);
		sortColors(left);
		int[] right = Arrays.copyOfRange(nums, len / 2, len);
		sortColors(right);
		merg(left, right, nums);
	}

	public static void merg(int[] left, int[] right, int a[]) {
		int l = 0, r = 0, i = 0;
		while (l < left.length && r < right.length) {
			if (left[l] < right[r]) {
				a[i++] = left[l++];
			} else {
				a[i++] = right[r++];
			}
		}
		while (l < left.length) {
			a[i++] = left[l++];
		}
		while (r < right.length) {
			a[i++] = right[r++];
		}
	}
}
