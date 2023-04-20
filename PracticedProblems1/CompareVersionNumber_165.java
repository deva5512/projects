package Medium;

public class CompareVersionNumber_165 {

	public static void main(String[] args) {

		System.out.println(Integer.parseInt("0001"));

		System.out.println(compareVersion1("1.01", "1.001"));
	}

	public static int compareVersion1(String version1, String version2) {

		if (version1.length() == 0 && version2.length() == 0) {
			return 0;
		}

		int a = 0, b = 0;
		int ind1 = version1.indexOf('.'), ind2 = version2.indexOf('.');

		if (ind1 > 0)
			a = Integer.parseInt(version1.substring(0, ind1));
		else if (ind1 == -1 && version1.length() != 0) {
			a = Integer.parseInt(version1.substring(0, version1.length()));
		}

		if (ind2 > 0)
			b = Integer.parseInt(version2.substring(0, ind2));
		else if (ind2 == -1 && version2.length() != 0) {
			b = Integer.parseInt(version2.substring(0, version2.length()));
		}

		if (a > b) {
			return 1;
		} else if (a < b) {
			return -1;
		}

		if (ind1 != -1)
			version1 = version1.substring(ind1 + 1);
		else {
			version1 = "";
		}
		
		if (ind2 != -1)
			version2 = version2.substring(ind2 + 1);
		else {
			version2 = "";
		}

		return compareVersion1(version1, version2);

	}

	public static int compareVersion(String version1, String version2) {

		StringBuilder a = new StringBuilder(version1);
		StringBuilder b = new StringBuilder(version2);

		int one = 0, two = 0;
		while (a.length() != 0 || b.length() != 0) {
			while (a.length() > 0 && a.charAt(0) == '0') {
				a.deleteCharAt(0);
			}

			while (b.length() > 0 && b.charAt(0) == '0') {
				b.deleteCharAt(0);
			}

			int index1 = a.indexOf(".");
			int index2 = b.indexOf(".");
			String word = "";

			if (index1 > 0) {
				word = a.substring(0, index1);
				one = Integer.parseInt(word);
			} else if (index1 == 0 || a.length() == 0)
				one = 0;
			else {
				if (b.length() > 0)
					one = Integer.parseInt(new String(a));
				else
					one = 0;
			}

			if (index2 > 0) {
				word = b.substring(0, index2);
				two = Integer.parseInt(word);
			} else if (index2 == 0 || b.length() == 0)
				two = 0;
			else {
				if (b.length() > 0)
					two = Integer.parseInt(new String(b));
				else
					two = 0;
			}

			if (one > two)
				return 1;
			if (one < two)
				return -1;

			if (index1 != -1)
				a.delete(0, index1 + 1);
			else
				a.delete(0, a.length());

			if (index2 != -1)
				b.delete(0, index2 + 1);
			else
				b.delete(0, b.length());
		}
		return 0;
	}

}
