package WeeklyAssignment;

import java.util.HashMap;
import java.util.Map;

public class NumberInWord {
	public static void main(String[] args) {
		int num = 901;
		numberToWord(num);
	}

	public static void numberToWord(int num) {

		if (num > 999) {
			System.out.println("Enter the value between 999 && 1");
			return;
		}

		Map<Integer, String> map = new HashMap<>();

		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		map.put(10, "Ten");
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Nineteen");
		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Fourty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eighty");
		map.put(90, "Ninty");
		map.put(100, "Hundred");
		map.put(200, "Two Hundred");
		map.put(300, "Three Hundred");
		map.put(400, "Four Hundred");
		map.put(500, "Five Hundred");
		map.put(600, "Six Hundred");
		map.put(700, "Seven Hundred");
		map.put(800, "Eight Hundred");
		map.put(900, "Nine Hundred");

		String res = "";

		while (num > 0) {

			if (num > 99) {
				res += map.get((num / 100) * 100);
				num = num % 100;
				if (num > 0)
					res += " and ";
			} else if (num > 9) {
				res += map.get((num / 10) * 10) + " ";
				num = num % 10;
			} else {
				res += map.get(num);
				num /= 10;
			}
		}

		System.out.println(res);

	}
}
