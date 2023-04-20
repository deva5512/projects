package Medium;

public class MinimumCostForTicket_983 {
	
	public static void main(String[] args) {
		int [] days = {1,4,6,7,8,20};
		int [] cost = {2,7,15};
		System.out.println(mincostTickets(days, cost));
	}
	
	public static int mincostTickets(int[] days, int[] costs) {
		return helper(days, 0, costs, 0);
	}

	public static int helper(int[] days, int cost, int[] costs, int i) {
		if (i == days.length - 1) {
			return cost;
		}
		int a = helper(days, cost + costs[0], costs, i + 1);
		int cantravel = days[i] + 7;
		int j = i + 1;
		for (; j < days.length; i++) {
			if (days[j] >= cantravel) {
				break;
			}
		}
		int b = helper(days, cost + costs[1], costs, j);
		cantravel = days[i] + 30;
		j = i + 1;
		for (; j < days.length; i++) {
			if (days[j] >= cantravel) {
				break;
			}
		}
		int c = helper(days, cost + costs[2], costs, j);
		return Math.min(a, Math.min(b, c));
	}
}
