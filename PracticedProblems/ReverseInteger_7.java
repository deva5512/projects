package Medium;

public class ReverseInteger_7 {

	public static void main(String[] args) {
		int res = reverse(1534236469);
		System.out.println(res);
	}

	public static int reverse(int x) {
		if (x == 0)
			return 0;
		int num = x;
		int rem = 0;
		long rev = 0;
		System.out.println(num);
		if (num < 0) {
			while (num <= 0 ^ num == 0) {
				rem = num % 10;
				rev = rev * 10 + rem;
				num /= 10;
			}
		} else {
			while (num > 0) {
				rem = num % 10;
				rev = rev * 10 + rem;
				num /= 10;
			}
		}
		if (rev >= Integer.MAX_VALUE || rev <= Integer.MIN_VALUE) {
			return 0;
		}
		x = (int) rev;
		return x;
	}
}
