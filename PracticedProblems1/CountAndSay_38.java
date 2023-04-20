package Medium;

public class CountAndSay_38 {
	public static void main(String[] args) {
		System.out.println(countAndSay(6));
	}

	public static String countAndSay(int n) {
		String[] res = new String[n];
		res[0] = "1";
		for (int i = 1; i < n; i++) {
			String previous = res[i - 1];
			StringBuilder current = new StringBuilder();
			int count = 0, a = 0, b = 0;
			while (a < previous.length()) {
				if (previous.charAt(a) == previous.charAt(b)) {
					count++;
					a++;
				} else {
					current.append(count + "" + previous.charAt(b));
					b = a;
					count = 0;
				}
			}
			current.append(count + "" + previous.charAt(b));
			res[i] = new String(current);
		}
		return res[n - 1];
	}
}
