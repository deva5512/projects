package WeeklyAssignment;

import java.util.Iterator;

public class PatternX {
	public static void main(String[] args) {
		pattern(9, 3);
	}

	public static void pattern(int n, int cnt) {

		if (n % 2 == 0) {
			System.out.println("Invalid");
			return;
		}
		int space = 0;
		int censpace = n;
		for (int i = 0; i < n; i++) {
			if (i <= n / 2) {
				censpace -= 2;
			} else {
				censpace += 2;
			}
			int temp = n;
			for (int j = 0; j < cnt; j++) {
				if (i == 0 || i == n - 1) {
					for (int a = 0; a < temp; a++)
						System.out.print("* ");
				} else {

					for (int s = 0; s < space; s++) {
						if (j == 1 && s == space - 1) {
							break;
						}
						System.out.print("  ");
					}
					System.out.print("* ");
					for (int s = 0; s < censpace; s++) {
						System.out.print("  ");
					}
					if (i != n / 2)
						System.out.print("* ");
					for (int s = 0; s < space; s++) {
						if (j == 1 && s == space - 1) {
							break;
						}
						System.out.print("  ");
					}

				}
				if (j == 0) {
					temp--;
				}
			}
			if (i < n / 2) {
				space++;
			} else {
				space--;
			}

			System.out.println();
		}
	}

	public static void pattern1(int n, int cnt) {

	}
}
