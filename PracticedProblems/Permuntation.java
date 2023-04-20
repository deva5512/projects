package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permuntation {

	// Final result list
	static List<List<Integer>> res = new ArrayList<>();
	// Adding list
	static List<Integer> adder = new ArrayList<>();

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
//		System.out.println(permute(a));
		permutation1(a , new ArrayList<>());
	}

	// With boolean array
	public static void perm(int[] a) {
		boolean check[] = new boolean[a.length];
		tracking(a, check);

	}

	private static void tracking(int[] a, boolean[] check) {
		if (adder.size() == a.length) {
			List<Integer> insert = new ArrayList<Integer>(adder);
			if (!res.contains(insert))
				res.add(insert);
			return;
		}

		for (int i = 0; i < a.length; i++) {
			if (!check[i]) {
				adder.add(a[i]);
				check[i] = true;
				tracking(a, check);
				check[i] = false;
				adder.remove(adder.size() - 1);
			}
		}
	}

	// Without boolean array
	static List<List<Integer>> permres = new ArrayList<>();

	public static void permutation1(int[] a, ArrayList<Integer> ans) {
		if (ans.size() == a.length) {
			System.out.println(ans);
			ArrayList<Integer> found = new ArrayList<>(ans);
			permres.add(found);
			return;
		}

		for (int i = 0; i < a.length; i++) {
			if (!ans.contains(a[i])) {
				ans.add(a[i]);
				permutation1(a, ans);
				ans.remove(ans.size() - 1);
			}
		}
	}

	// Neetcode solution
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Integer[] a = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			a[i] = nums[i];
		}
		function(ans, a, 0);
		return ans;
	}

	public static void function(List<List<Integer>> ans, Integer[] arr, int start) {
		if (start == arr.length) {
			List<Integer> list = new ArrayList<>(Arrays.asList(arr));
			System.out.println(list);
			ans.add(list);
			return;
		}

		for (int i = start; i < arr.length; i++) {
			swap(arr, start, i);
			function(ans, arr, start + 1);
			swap(arr, start, i);
		}
	}

	public static void swap(Integer[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
