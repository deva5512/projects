package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation2_47 {
	public static void main(String[] args) {
		Permutation2_47 p = new Permutation2_47();
		System.out.println(p.permuteUnique(new int[] { 1, 1, 2 }));
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> output = new HashSet<>();

//		Integer[] num = new Integer[nums.length];
//		
//		for(int i = 0;i<nums.length;i++) {
//			num[i] = nums[i];
//		}
//
//		perms(output, num, 0);

		permutats(output, nums, new boolean[nums.length], new ArrayList<>());

		return new ArrayList(output);
	}

	public void perms(Set<List<Integer>> output, Integer[] nums, int ind) {
		if (ind == nums.length) {
			System.out.println(Arrays.toString(nums));
			List<Integer> list = new ArrayList<>(Arrays.asList(nums));
			output.add(list);
			return;
		}

		for (int i = ind; i < nums.length; i++) {
			swap(nums, i, ind);
			perms(output, nums, ind + 1);
			swap(nums, i, ind);
		}
	}

	public void swap(Integer[] nums, int i, int j) {
		nums[i] = (nums[i] + nums[j]) - (nums[j] = nums[i]);
	}

	public static void permutats(Set<List<Integer>> output, int[] nums, boolean visited[], List<Integer> res) {
		if (res.size() == nums.length) {
			List<Integer> list = new ArrayList<>(res);
			output.add(list);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (res.size() == 0 && (i > 0 && nums[i] == nums[i - 1])) {
				continue;
			}
			if (!visited[i]) {
				visited[i] = true;
				res.add(nums[i]);
				permutats(output, nums, visited, res);
				res.remove(res.size() - 1);
				visited[i] = false;
			}
		}
	}
}
