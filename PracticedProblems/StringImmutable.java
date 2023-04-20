package WeeklyAssignment;

public class StringImmutable {

	public static void main(String[] args) {

		String one = "One";

		System.out.println("First String is : " + one);

		String two = "One";

		System.out.println("Second String is : " + two);

		System.out.println("\nComparing the address of the two String using double equals operator : " + (one == two));

	}

}
