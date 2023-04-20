package Medium;

public class MultiplyString_43 {
	public static void main(String[] args) {

		String res = multiply("9", "415"); // 3,04,22,652
		System.out.println(res);
	}

	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		StringBuilder res = new StringBuilder("");
		StringBuilder steps = new StringBuilder();

		int carry = 0, addit = 0, zeros = 1;

		for (int i = num2.length() - 1; i >= 0; i--) {

			int num = num2.charAt(i) - '0';
			for (int j = num1.length() - 1; j >= 0; j--) {
				int val = num1.charAt(j) - '0';
				val = num * val + carry;
				if (val <= 9) {
					steps.insert(0, val);
					carry = 0;
				} else {
					carry = val / 10;
					steps.insert(0, val % 10);
				}
			}
			if (carry != 0) {
				steps.insert(0, carry);
				carry = 0;
			}
			if (i == num2.length() - 1) {
				res.append(steps);
				steps = new StringBuilder("");
				continue;
			}
			steps.insert(steps.length(), multiplyer(zeros++));

			int c = 0;
			for (int a = steps.length() - 1, b = res.length() - 1; a >= 0; a--) {
				if (b >= 0) {
					addit = steps.charAt(a) - '0' + res.charAt(b) - '0' + c;
				} else {
					addit = steps.charAt(a) - '0' + c;
				}
				if (addit <= 9) {
					if (b >= 0) {
						res.deleteCharAt(b);
						res.insert(b--, addit);
					} else
						res.insert(0, addit);
					c = 0;
				} else {
					c = addit / 10;
					if (b >= 0) {
						res.deleteCharAt(b);
						res.insert(b--, addit % 10);
					} else
						res.insert(0, addit % 10);
				}
			}
			if (c != 0) {
				res.insert(0, c);
			}
			steps = new StringBuilder("");

		}

		return new String(res);
	}

	public static String multiplyer(int num) {
		if (num == 0) {
			return "";
		}
		return "0" + multiplyer(num - 1);
	}
}
