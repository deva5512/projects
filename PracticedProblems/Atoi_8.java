package Medium;

public class Atoi_8 {
	public static void main(String[] args) {
		System.out.println(myAtoi2("-2147483647"));
		System.out.println(myAtoi1("-2147483647"));
	}

	public static int myAtoi2(String s) {

		s = s.trim();
		if (s.isEmpty()) {
			return 0;
		}
		int sign = 1;
		if (s.charAt(0) == '-' || s.charAt(0) == '+') {
			if (s.charAt(0) == '-') {
				sign = -1;
			}
			s = s.substring(1);
		}
		long res = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				break;
			}
			res = res * 10 + (s.charAt(i) - '0');
			if (res != 0)
				count++;
			if (res > Integer.MAX_VALUE && count >= 10) {
				if (sign == 1) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
			}
		}
		return sign * (int) res;
	}

	public static int myAtoi1(String s) {

		s = s.trim();
		String res = "";
		int min_count = 0, plus_count = 0, ver = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '-' && s.charAt(i) != '+' && (s.charAt(i) < '0' || s.charAt(i) > '9')) {
				if (res.equals(""))
					return 0;
				else
					break;
			}
			if ((min_count != 0 || plus_count != 0 || ver != 0) && (s.charAt(i) < '0' || s.charAt(i) > '9')) {
				if (res.equals(""))
					return 0;
				else
					break;
			}
			if (min_count == 0 && res.equals("") && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
				if (s.charAt(i) == '-')
					min_count++;
				else
					plus_count++;
			}
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				ver++;
				if (res.isEmpty() && s.charAt(i) == '0') {
					continue;
				}
				res += s.charAt(i);
			}
		}
		if (res.length() == 0 || res.length() > 11) {
			if (res.length() == 0) {
				return 0;
			}
			if (min_count == 0)
				return Integer.MAX_VALUE;
			else
				return Integer.MIN_VALUE;
		}
		long value;
		if (min_count == 0) {
			value = Long.parseLong(res);
			if (value > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
		} else {
			value = -1 * Long.parseLong(res);
			if (value < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}
		return (int) value;
	}

}
