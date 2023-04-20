package WeeklyAssignment;

public class VarArgs {
	public static void main(String[] args) {
		print("sdfsdf", "sdf");
	}

	public static void print(String... a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}
}
