package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.List;

public class DeleteAndEarn_740 {
	public static void main(String[] args) {
		int[] a = { 2, 2, 3, 3, 3, 4 };

		Arrays.sort(a);

		System.out.println(deleteAndEarn(a));
	}

	public static int deleteAndEarn(int[] nums) {
		HashMap<Integer, Integer> container = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			if (container.containsKey(val)) {
				container.put(val, container.get(val) + val);
			} else {
				container.put(val, val);
			}
		}
		System.out.println(container);
		return 5;
	}

	public static int deleteAndEarn1(int[] nums) {
		HashMap<Integer, Integer> container = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			if (container.containsKey(val)) {
				container.put(val, container.get(val) + val);
			} else {
				container.put(val, val);
			}
		}
		System.out.println(container);

		int canttake1 = 0;
		int canttake2 = 0;
		int cur = 0;
		int sum = 0;

		List<Integer> numbers = new ArrayList<>(container.keySet());

		int i = 0;
		while (i < numbers.size()) {
			int num = numbers.get(i);
			canttake1 = num - 1;
			canttake2 = num + 1;

			cur = container.get(num);
			if (!container.containsKey(canttake1) && !container.containsKey(canttake2)) {
				sum += cur;
				i++;
				continue;
			} else if (container.containsKey(canttake1) && container.containsKey(canttake2)) {
				int val = container.get(canttake1) + container.get(canttake2);
				if (val > cur) {
					sum += val;
					i = numbers.indexOf(canttake2);
				} else {
					i++;
				}
			} else if (!container.containsKey(canttake1) && container.containsKey(canttake2)) {
				if (cur < container.get(canttake2)) {
					i++;
				} else {
					sum += cur;
				}
			}
		}

		return sum;
	}
}
