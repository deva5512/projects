package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combination_39 {

	public static void main(String[] args) {
		int[] c = { 2, 3, 6, 7 };
		System.out.println(combinationSum(c, 7));

	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
//		helper(candidates, 0, new ArrayList<Integer>(), target, result);
		combination(0, 0, candidates, target, new ArrayList<>(), result);

		return result;

	}

	public static void helper(int[] c, int sum, ArrayList<Integer> ans, int target, List<List<Integer>> result) {
		if (sum == target) {
			System.out.println(ans + "found");
			List<Integer> fount = new ArrayList<>(ans);
			Collections.sort(fount);
			if (!result.contains(fount))
				result.add(fount);
			return;
		}

		for (int i = 0; i < c.length; i++) {
			if (sum + c[i] <= target) {
				ans.add(c[i]);
				helper(c, sum + c[i], ans, target, result);
				ans.remove(ans.size() - 1);
			}
		}

	}

	// Neetcode Solution
	public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		backtrack(candidates, target, ans, cur, 0);
		return ans;
	}

	public static void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> cur, int index) {
		if (target == 0) {
			ans.add(new ArrayList<>(cur));
		} else if (target < 0 || index >= candidates.length) {
			return;
		} else {
			cur.add(candidates[index]);
			backtrack(candidates, target - candidates[index], ans, cur, index);

			cur.remove(cur.get(cur.size() - 1));
			backtrack(candidates, target, ans, cur, index + 1);
		}
	}

	static void combination(int i, int sum, int[] candidates, int target, List<Integer> list, List<List<Integer>> listoflist) {
		if (sum == target) {
			if (!listoflist.contains(list))
				listoflist.add(new ArrayList<>(list));
		}
		if (i < 0 || i >= candidates.length || sum > target)
			return;
		list.add(candidates[i]);
		sum = sum + candidates[i];
		combination(i, sum, candidates, target, list, listoflist);
		sum = sum - candidates[i];
		list.remove(list.size() - 1);
		combination(i + 1, sum, candidates, target, list, listoflist);
	}
}
