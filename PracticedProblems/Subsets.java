package WeeklyAssignment;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static void main(String[] args) {
		subset(new int[] { 1, 2, 3 }, 0, new ArrayList<>());
	}

	public static void subset(int[] a, int ind, List<Integer> res) {
		if (a.length == ind) {
			System.out.println(res);
			return;
		}
		res.add(a[ind]);
		subset(a, ind + 1, res);
		res.remove(res.size() - 1);
		subset(a, ind + 1, res);
	}
}
