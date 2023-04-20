package WeeklyAssignment;

public class Encripting {
	public static void main(String[] args) {
		System.out.println(encripted("mom", "dad"));
	}

	public static String encripted(String string1, String string2) {
		String res = "";
		for (int i = 0; i < string1.length(); i++) {
			int val = string1.charAt(i) + string2.charAt(i) - 192;
			if (val > 26) {
				val -= 26;
			}
			res += (char) (96 + val) + "";
		}
		return res;
	}
}
