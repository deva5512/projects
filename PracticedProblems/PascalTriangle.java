package WeeklyAssignment;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static void main(String[] args) {
		pascalTriangle(5);
	}

	public static void pascalTriangle(int num) {

		if (num == 0) {
			return;
		}

		List<Integer> list = new ArrayList<>();
		list.add(1);

		System.out.println(list);

		for (int i = 2; i <= num; i++) {

			List<Integer> found = new ArrayList<>();
			for (int j = 1; j <= i; j++) {
				if (j == 1 || j == i) {
					found.add(1);
				} else {
					int val = list.get(j - 2) + list.get(j - 1);
					found.add(val);
				}
			}
			System.out.println(found);
			list = found;
		}

	}
}
