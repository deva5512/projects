package WeeklyAssignment;

import java.util.Arrays;
import java.util.Comparator;

public class LexograficalSort {
	public static void main(String[] args) {
		String[] arr = { "3", "30", "3", "30", "1" };

		Comparator<String> comp = (a, b) -> {
			if (check(a + b, b + a) == 1) {
				return -1;
			} else
				return 1;
		};

		Comparator<String> comp1 = (a, b) -> {
			if ((a + b).compareTo(b + a) > 0) {
				return -1;
			} else
				return 1;
		};

		System.out.println(Arrays.toString(arr));

		Arrays.sort(arr, comp);

		int len = arr.length - 1;

		boolean check = true;
		do {
			check = false;
			for (int i = 0; i < len; i++) {
				if (check(arr[i] + arr[i + 1], arr[i + 1] + arr[i]) == -1) {
					String temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					check = true;
				}
			}
			len--;
		} while (check);

		System.out.println(Arrays.toString(arr));

	}

	public static int check(String a, String b) {

		if (a == b) {
			return 0;
		}
		int i = 0;
		for (; i < a.length() && i < b.length(); i++) {
			if (a.charAt(i) > b.charAt(i)) {
				return 1;
			} else if (a.charAt(i) < b.charAt(i)) {
				return -1;
			}
		}

		if (b.length() == i && a.length() > i) {
			return 1;
		}

		return -1;
	}
}
