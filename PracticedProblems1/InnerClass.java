package WeeklyAssignment;

public class InnerClass extends Demo {
	{
		System.out.println("non");
	}

	public static void main(String[] args) {
		Demo d = new InnerClass();
	}

	InnerClass() {
		super();
		
		System.out.println("Innercons");
	}
}

class Demo {
	static void print() {
		System.out.println("Print");
	}

	Demo() {
		System.out.println("Democons");
	}
}
