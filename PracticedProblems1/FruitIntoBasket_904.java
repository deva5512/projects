package Medium;

import java.util.HashSet;
import java.util.Set;

public class FruitIntoBasket_904 {
	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 2, 1 };

		System.out.println(totalFruit(a));
	}

	public static int totalFruit(int[] fruits) {

		// Taken a set it will verify that are we taking similar kind
		Set<Integer> fruit = new HashSet<>();

		int res = 0;
		int taking = 0;

		boolean flag = true;
		int i = 0;
		while (i < fruits.length) {
			if (flag) {
				fruit.add(fruits[i]);
				taking++;
				i++;
			} else {

				// If the element is different it wont result true
				if (fruit.add(fruits[i])) {

					if (res < taking)
						res = taking;
					taking = 0;
					fruit.clear();
					fruit.add(fruits[i]);
					fruit.add(fruits[i - 1]);

					// Used to find the previous occurrence of the unique fruit
					for (int j = i - 2; j >= 0; j--) {
						if (fruit.add(fruits[j])) {
							fruit.remove(fruits[j]);
							i = j + 1;
							break;
						}
					}
				} else {
					taking++;
					i++;
				}
			}

			// Used to get the unique element then only the it will make the flag as false;
			if (fruit.size() == 2 && flag)
				flag = false;
		}

		return res > taking ? res : taking;
	}
}
