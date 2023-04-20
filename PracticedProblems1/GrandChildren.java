package WeeklyAssignment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GrandChildren {
	public static void main(String[] args) {
		String[][] family = { { "luke", "shaw" }, { "wayne", "rooney" }, { "rooney", "ronaldo" },
				{ "shaw", "rooney" } };

		findGrandChild(family, "ronaldo");
	}

	private static void findGrandChild(String[][] family, String name) {

		Map<String, List<String>> sonlist = new HashMap<>();

		for (int i = 0; i < family.length; i++) {
			String father = family[i][1];
			if (sonlist.containsKey(father)) {
				sonlist.get(father).add(family[i][0]);
			} else {
				List<String> a = new LinkedList<>();
				a.add(family[i][0]);
				sonlist.put(father, a);
			}
		}

		List<String> son = sonlist.get(name);
		for (int i = 0; i < son.size(); i++) {
			System.out.println(sonlist.get(son.get(i)));
		}
	}
}
