package Medium;

public class Besttimetobuyandsell2_122 {
	public static void main(String[] args) {
		int price[] = { 1, 2, 3, 4, 5 };
		System.out.println(maxProfit(price));
	}

	public static int maxProfit(int[] prices) {
		int profit = 0;

		int buy_price = -1;
		int first = 0, second = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			first = prices[i];
			second = prices[i + 1];

			// If we want to buy a stock the next price has to be lesser then the current
			// price then only we can end up in profit
			if (buy_price == -1 && first < second)
				buy_price = first;

			// To sell a stock the next element has to be less then current element
			// That indicated the stock price is going to drop
			else if (buy_price != -1 && first > second) {
				profit += first - buy_price;
				buy_price = -1;
			}
		}

		first = prices[prices.length - 1];
		// If it reached the final and stock is not sold yet sell it and get profit
		if (buy_price != -1 && buy_price < first)
			profit += first - buy_price;

		return profit;
	}
}
