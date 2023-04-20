package WeeklyAssignment;

public class Pattern_borderStars {
	public static void main(String[] args) {
		pattern(4);
	}

	public static void pattern(int n) {
		int size = 1;
		for (int i = 0; i <= n * 2; i++) {
			int num = 1;
			for (int j = 1; j <= size; j++) {
				if (j == 1 || j == size) {
					System.out.print("*");
				} else {
					System.out.print(num);

					if (j <= size / 2) {
						num++;
					} else {
						num--;
					}
				}
			}
			System.out.println();
			if (i < n)
				size += 2;
			else
				size -= 2;

		}
	}
}
