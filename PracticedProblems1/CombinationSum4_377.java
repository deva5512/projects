package Medium;

import java.util.Arrays;
import java.util.HashMap;

public class CombinationSum4_377 {

	public static void main(String[] args) {
		int[] a = {1,2,3};
		System.out.println(combinationSum41(a, 5));
	}

	public static int combinationSum41(int[] nums, int target) {
		int[] comb = new int[target + 1];
		comb[0] = 1;
		for (int i = 1; i < comb.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i - nums[j] >= 0) {
					comb[i] += comb[i - nums[j]];
				}
			}
		}
		return comb[target];
	}

	// Using hashMap
	public static int combinationSum4(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);
		int cnt = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++)
			cnt += dfs(nums, i, nums[i], target, hm);
		return cnt;
	}

	static int dfs(int[] nums, int ind, int currSum, int target, HashMap<Integer, Integer> hm) {
		if (hm.containsKey(currSum))
			return hm.get(currSum);
		if (currSum == target) {
			hm.put(currSum, 1);
			return 1;
		}
		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (currSum + nums[i] > target)
				break;
			cnt += dfs(nums, i, currSum + nums[i], target, hm);
		}
		hm.put(currSum, cnt);
		return cnt;
	}

//	public static int combinationSum4(int[] nums, int target) {
//		helper(nums, target);
//		return count;
//
//	}
//
//	static int count = 0;
//
//	public static void helper(int[] nums, int target) {
//		if (target == 0) {
//			count += 1;
//			return;
//		}
//		for (int i = 0; i < nums.length; i++) {
//			target -= nums[i];
//			if (target >= 0) {
//				helper(nums, target);
//			}
//			target += nums[i];
//		}
//	}
}
