package Medium;

import java.util.ArrayList;
import java.util.List;

public class Triangle_120 {
	public static void main(String[] args) {
		// [-1],[2,3],[1,-1,-3]

		List<List<Integer>> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		b.add(-1);
		a.add(b);
		List<Integer> c = new ArrayList<>();
		c.add(2);
		c.add(3);
		a.add(c);
		List<Integer> d = new ArrayList<>();
		d.add(1);
		d.add(-1);
		d.add(-3);
		a.add(d);
//		List<Integer> e = new ArrayList<>();
//		e.add(4);
//		e.add(1);
//		e.add(8);
//		e.add(3);
//		a.add(e);
//		minimumTotal1(a, a.get(0).get(0), 0, 0);
//		System.out.println("\n\n\n" + result);
		System.out.println(helper(a));

	}

	public static int helper(List<List<Integer>> triangle) {

		List<Integer> pre;
		List<Integer> curr;
		int val = 0;

		for (int i = 1; i < triangle.size(); i++) {

			pre = triangle.get(i - 1);
			curr = triangle.get(i);

			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (j == 0) {
					curr.set(j, curr.get(j) + pre.get(0));
				} else if (j == curr.size() - 1) {
					curr.set(j, curr.get(j) + pre.get(pre.size() - 1));
				} else {
					int one = pre.get(j - 1);
					int two = pre.get(j);
					val = one < two ? one : two;
					curr.set(j, curr.get(j) + val);
				}
			}
		}
		return triangle.get(triangle.size() - 1).stream().min(Integer::compare).get();
	}

	static int result = Integer.MAX_VALUE;

	public static void minimumTotal1(List<List<Integer>> triangle, int first, int rows, int col) {
		if (rows == triangle.size() - 2) {
			System.out.println(first + triangle.get(rows + 1).get(col));
			System.out.println(first + triangle.get(rows + 1).get(col + 1));
			int one = (first + triangle.get(rows + 1).get(col));
			int two = (first + triangle.get(rows + 1).get(col + 1));
			result = Math.min(result, Math.min(one, two));
			return;
		}

		minimumTotal1(triangle, first + triangle.get(rows + 1).get(col), rows + 1, col);
		minimumTotal1(triangle, first + triangle.get(rows + 1).get(col + 1), rows + 1, col + 1);

	}

}
