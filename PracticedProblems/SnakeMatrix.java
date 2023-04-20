package WeeklyAssignment;

public class SnakeMatrix {
	public static void main(String[] args) {
		snakeMatrix(4);
	}

	public static void snakeMatrix(int num) {
		int temp = num;
		for (int i = 0; i < num; i += 2) {
			temp--;
			for(int j = 0;j<temp;j++) {
				System.out.print("  ");
			}
			int a = i * num + 1;
			for (int j = 0; j < num; j++) {
				System.out.print(a++ + " ");
			}
			System.out.println();
			temp--;
			for(int j = 0;j<temp;j++) {
				System.out.print("  ");
			}
			a = a + num - 1;
			for (int j = num; j > 0; j--) {
				System.out.print(a-- + " ");
			}
			System.out.println();
		}
	}
}
