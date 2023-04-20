package WeeklyAssignment;

public class RotateStringFromIndex {
	public static void main(String[] args) {
		reverse("hello world", 8);
	}

	public static void reverse(String str, int ind) {
		String res = "";
		String reverse = "";
		for (int i = 0; i < str.length(); i++) {
			if (i < ind) {
				res += str.charAt(i);
			} else {
				reverse += str.charAt(i);
			}
		}
		for (int i = reverse.length() - 1; i >= 0; i--) {
			res += reverse.charAt(i);
		}
		System.out.println("Result is :  " + res);
	}
}
