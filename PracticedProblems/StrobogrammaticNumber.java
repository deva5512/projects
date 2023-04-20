package WeeklyAssignment;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
	public static void main(String[] args) {
		if (function(6889)) {
			System.out.println("Strobogrammatic Number");
		} else {
			System.out.println("No its not ");
		}
	}

	public static boolean function(int num) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(8, 8);
		map.put(6, 9);
		map.put(9, 6);
		map.put(0, 0);

		String compare = "";
		String number = String.valueOf(num);
		for (int i = 0; i < number.length(); i++) {
			compare = map.get(number.charAt(i) - '0') + compare;
		}

		return number.equals(compare);
	}
}
