package Medium;

import java.util.Arrays;

public class RotateHiring_189 {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		rotate(a, 4);
		System.out.println(Arrays.toString(a));

	}

	public static void rotate(int[] nums, int k) {
		int[] last = new int[k];
		int j = nums.length - 1;
		for (int i = last.length-1; i >=0; i--) {
			last[i] = nums[j--];
		}
		j = nums.length - 1 - k;
		
		for (int i = nums.length-1; i >= 0; i--) {
			if (j >= 0) {
				nums[i] = nums[j--];
			} else {
				nums[i] = last[--k];
			}
		}
	}
}
