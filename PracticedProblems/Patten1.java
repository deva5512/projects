package WeeklyAssignment;

public class Patten1 {
	public static void main(String[] args) {
		patten(11);
	}

	public static void patten(int num) {

		int val = 1;
		int temp = val;

		for (int i = 0; i < num; i++) {
			if (temp == 0) {
				temp = ++val;
			}
			for (int j = 0; j <= i; j++) {
				System.out.print(val + " ");
			}
			temp--;
			System.out.println();
		}
	}
}
