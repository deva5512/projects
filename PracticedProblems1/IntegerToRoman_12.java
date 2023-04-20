package Medium;

import java.util.HashMap;

public class IntegerToRoman_12 {
	public static void main(String[] args) {
		System.out.println(intToRoman(47));
	}

	public static String intToRoman(int num) {
		HashMap<Integer, String> roman = new HashMap<>();
		roman.put(1, "I");
		roman.put(4, "IV");
		roman.put(5, "V");
		roman.put(9, "IX");
		roman.put(10, "X");
		roman.put(40, "XL");
		roman.put(50, "L");
		roman.put(90, "XC");
		roman.put(100, "C");
		roman.put(400, "CD");
		roman.put(500, "D");
		roman.put(900, "CM");
		roman.put(1000, "M");

		String res = "";
		int digits = 1;

		while (num > 0) {

			int val = num % 10;
			val *= digits;
			num /= 10;
			digits *= 10;

			if (roman.containsKey(val)) {
				res = roman.get(val) + res;
				continue;
			}

			while (val > 0) {
				if (roman.containsKey(val)) {
					res = roman.get(val) + res;
					break;
				}
				res = roman.get(digits/10) + res;
				val -= digits/10;
			}
		}

		return res;
	}
}
