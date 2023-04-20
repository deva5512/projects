package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combinations_77 {

	public static void main(String[] args) {
		System.out.println(combine(1, 1));
		System.out.println(Integer.parseInt("11100", 2));
	}

	public static List<List<Integer>> combine(int n, int k) {
		Set<List<Integer>> result = new HashSet<>();
		helper(result, n, k, new ArrayList<>(), 1);
		return new ArrayList<>(result);
	}

	public static void helper(Set<List<Integer>> result, int n, int k, List<Integer> value, int s) {
		if (value.size() == k) {
			System.out.println(value);
			List<Integer> list = new ArrayList<>(value);
			result.add(list);
			return;
		}

		for (int i = s; i <= n; i++) {
			if (!value.contains(i)) {
				value.add(i);
				helper(result, n, k, value, i);
				value.remove(value.size() - 1);
			}
		}
	}
}
