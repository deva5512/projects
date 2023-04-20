package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_40 {
	public static void main(String[] args) {
		int[] a = { 10, 1, 2, 7, 6, 1, 5 };
		System.out.println(combinationSum2(a, 8));
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		helper1(candidates, target, new ArrayList<>(), result, 0, 0);
		return result;
	}

	public static void helper(int[] a, int target, List<Integer> ans, List<List<Integer>> result, int start) {
		if (target == 0) {
			System.out.println(ans);
			List<Integer> list = new ArrayList<>(ans);
			if (!result.contains(list))
				result.add(list);
			return;
		}

		for (int i = start; i < a.length; i++) {
			if (a[i] > target) {
				break;
			}
			if (target - a[i] >= 0) {
				ans.add(a[i]);
				helper(a, target - a[i], ans, result, i + 1);
				ans.remove(ans.size() - 1);
			}
		}
	}

	public static void helper1(int[] a, int target, List<Integer> ans, List<List<Integer>> result, int i, int sum) {
		if (target == sum) {
			System.out.println(ans);
			List<Integer> list = new ArrayList<>(ans);
			if (!result.contains(ans))
				result.add(list);
			return;
		}

		for (int j = i; j < a.length; j++) {
			if (j > i && a[j] == a[j - 1]) {
				continue;
			}
			sum += a[j];
			if (sum <= target) {
				ans.add(a[j]);
				helper1(a, target, ans, result, j + 1, sum);
				ans.remove(ans.size() - 1);
			}
			sum -= a[j];
		}
	}
}
