package Medium;

public class DivideTwoInteger_29 {
	public static void main(String[] args) {
		int num = 7;
		int i = -3;
		divide(num, i);
	}

	public static int divide(int dividend, int divisor) {
		int num = 0;
		if (divisor > 0) {
			while (dividend > divisor) {
				dividend -= divisor;
				num++;
			}
		} else {
			while (dividend > divisor) {
				dividend += divisor;
				num++;
			}
		}
		System.out.println(num);
		return num;
	}
}
