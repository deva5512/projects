package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subset2_90 {

	public static void main(String[] args) {
		int[] a = { 1, 2, 2 };
		List<List<Integer>> result = new ArrayList<>();
		helper(a, new ArrayList<>(), result, 0);
		System.out.println(result);
	}

	public static void helper(int[] nums, List<Integer> ans, List<List<Integer>> result, int index) {
		if (index == nums.length) {
			System.out.println(ans);
			List<Integer> list = new ArrayList<>(ans);
			Collections.sort(list);
			if (!result.contains(list))
				result.add(list);
			return;
		}
		helper(nums, ans, result, index + 1);
		ans.add(nums[index]);
		helper(nums, ans, result, index + 1);
		ans.remove(ans.size() - 1);
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());

		int s = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				s = res.size() / 2;
			else
				s = 0;
			int e = res.size();
			for (int j = s; j < e; j++) {
				ArrayList<Integer> needed = new ArrayList<>(res.get(j));
				needed.add(nums[i]);
				if (!res.contains(needed))
					res.add(needed);
			}
		}
		return res;
	}
}
