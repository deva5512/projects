package WeeklyAssignment;

public class StringWithSpace {
	public static void main(String[] args) {
		String s = "one";
		posible(s, "");
	}

	public static void posible(String s, String up) {
		if (s.length() <= 0) {
			System.out.println(up);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			up += s.substring(0, i + 1) + " ";
			posible(s.substring(i + 1), up);
		}
	}
}
