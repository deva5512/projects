package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumCloset_16 {

	public static void main(String[] args) {
		int[] a = { -1,2,1,-4 };
		int res = threeSumClosest(a, 1);
		int ans = threeSumClosest1(a, 1);
		System.out.println(res);
		System.out.println(ans);
	}
	
	public static int threeSumClosest1(int[] nums, int target) {
		Arrays.sort(nums);
		int res = Integer.MAX_VALUE;
		int val = 0;
		int variable = 0;
		int a = 0, b = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				a = i + 1;
				b = nums.length - 1;
				while (a < b) {
					val = nums[a] + nums[b] + nums[i];
					int diff = val - target;
					if (Math.abs(diff) < res) {
						res = Math.abs(diff);
						variable = val;
					}
					if (nums[a] + nums[b] + nums[i] < target) {
						a++;
					} else {
						b--;
					}
				}
			}
		}
		return variable;
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int val = 0;
		int a = 0, b = 0;
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				a = i + 1;
				b = nums.length - 1;
				while (a < b) {
					val = nums[a] + nums[b] + nums[i];
					res.add(val);
					if (nums[a] + nums[b] + nums[i] < target) {
						a++;
					} else {
						b--;
					}
				}
			}
		}
		System.out.println(res);

		return bs(res, target);
	}

	public static int bs(ArrayList<Integer> a, int key) {
		Collections.sort(a);
		int s = 0, e = a.size() - 1, mid = 0;
		while (s <= e) {
			mid = (s + e) / 2;
			if (key == a.get(mid))
				return a.get(mid);
			else if (key < a.get(mid))
				e = mid - 1;
			else
				s = mid + 1;
		}
		return a.get(mid);
	}
}
