package WeeklyAssignment;

public class SubString {
	public static void main(String[] args) {
		System.out.println(substring("gopinath", "nath"));
	}

	public static boolean substring(String org, String subs) {
		if (subs.equals(org.substring(0, subs.length()))) {
			return true;
		}
		if (org.length() < subs.length()) {
			return false;
		}
		return substring(org.substring(1), subs);
	}
}
