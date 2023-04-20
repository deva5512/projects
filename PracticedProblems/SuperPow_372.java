package Medium;

public class SuperPow_372 {

	public static void main(String[] args) {
		int a[] = { 3 };
		System.out.println(superPow(2, a));
	}

	public static int superPow(int a, int[] b) {
		a %= 1337;
		int res = 1;
		for (int i : b) {
			res = (power(res, 10) * power(a, i)) % 1337;
		}
		return res;
	}

	public static int power(int a, int pow) {
		int res = 1;
		while (pow > 0) {

			res *= a;
			res %= 1337;
			pow--;
		}
		return res % 1337;
	}

}
