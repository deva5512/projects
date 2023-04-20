package WeeklyAssignment;

public class DiagnolPattern {
	public static void main(String[] args) {
		printPattern("abcdefg");
	}

	public static void printPattern(String str) {
		if ((str.length() & 1) == 0) {
			System.out.println("Not posible ");
			return;
		}

		int space = str.length() / 2;
		int addspace = -1;
		int center_space = -1;
		int add_center_space = 2;

		int i = str.length() / 2;
		int j = 0;

		while (true) {

			for (int s = 1; s <= space; s++) {
				System.out.print("   ");
			}
			System.out.print(str.charAt(i - j) + "  ");
			boolean extend = false;

			for (int cs = 0; cs < center_space; cs++) {
				extend = true;
				System.out.print("   ");
			}
			if (extend) {
				System.out.print(str.charAt(i + j) + "  ");
			}
			if (j == i) {
				j--;
				break;
			}
			space += addspace;
			center_space += add_center_space;
			j++;
			System.out.println();
		}

		while (j >= 0) {
			
			space -= addspace;
			center_space -= add_center_space;
			System.out.println();

			for (int s = 1; s <= space; s++) {
				System.out.print("   ");
			}
			System.out.print(str.charAt(i - j) + "  ");
			boolean extend = false;

			for (int cs = 0; cs < center_space; cs++) {
				extend = true;
				System.out.print("   ");
			}
			if (extend) {
				System.out.print(str.charAt(i + j) + "  ");
			}
			j--;
		}
	}
}
