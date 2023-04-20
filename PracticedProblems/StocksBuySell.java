package WeeklyAssignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StocksBuySell {
	public static void main(String[] args) {
		List<int[]> res = stockBuyingAndSelling(new int [] {100,180,260,310,40,535,695});
		
		for(int [] a : res) {
			System.out.println(Arrays.toString(a));
		}
	}

	public static List<int[]> stockBuyingAndSelling(int[] price) {
		List<int[]> res = new LinkedList<>();

		int i = 0;
		int buyind = -1;

		while (i < price.length - 1) {
			if (buyind == -1 && price[i] < price[i + 1]) {
				buyind = i;
			}

			if (buyind != -1 && price[i] > price[i + 1]) {
				res.add(new int[] { buyind, i });
				buyind = -1;
			}
			i++;
		}

		if (buyind != -1) {
			res.add(new int[] { buyind, i });
		}
		return res;
	}
}
