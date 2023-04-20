package WeeklyAssignment;

public class LastDigitOfNthFibonacci {
	public static void main(String[] args) {
		System.out.println(lastDigit(5));
	}

	public static int lastDigit(int num) {
		if (num < 2) {
			return num;
		}
		int pre = 0;
		int curr = 1;
		for (int i = 2; i <= num; i++) {
			int got = pre + curr;
			pre = curr;
			curr = got;
		}
		return curr % 10;
	}
}
