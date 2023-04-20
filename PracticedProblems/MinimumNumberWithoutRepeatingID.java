package WeeklyAssignment;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberWithoutRepeatingID {
	public static void main(String[] args) {
		sequence("D");
	}

	public static void sequence(String seq) {

		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= seq.length() + 1; i++) {
			list.add(i);
		}

		String res = "";

		for (int i = 0; i < seq.length(); i++) {
			if (seq.charAt(i) == 'I') {
				res += list.remove(0);
			} else if (seq.charAt(i) == 'D') {
				int move = 0;

				boolean check = false;
				while (true) {
					if (i > seq.length() - 1 || seq.charAt(i) == 'I') {
						break;
					}
					check = true;
					move++;
					i++;
				}

				for (; move > 0; move--) {
					res += list.remove(move);
				}
				if (check)
					i--;
			}
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			res += list.get(i);
		}

		System.out.println(res);
	}
}
