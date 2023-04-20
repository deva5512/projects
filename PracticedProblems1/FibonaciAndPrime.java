package WeeklyAssignment;

public class FibonaciAndPrime {
	public static void main(String[] args) {
		fib(10);
	}

	public static void fib(int num) {

		int twopre = 0;
		int onepre = 1;
		int cur = 0;
		while (true) {
			if (num == 0) {
				break;
			}
			cur = onepre + twopre;
			if (prime(cur)) {
				System.out.println(cur);
				num--;
			}
			twopre = onepre;
			onepre = cur;
		}

	}

	public static boolean prime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
