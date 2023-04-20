package WeeklyAssignment;

import java.util.Scanner;

public class RhombusPattern {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the board Size : ");
		int board = s.nextInt();
		System.out.print("Enter the center point : ");
		int center = s.nextInt();
		System.out.print("Enter the sides : ");
		int side = s.nextInt();
		pattern(board, center, side);
	}

	public static void pattern(int board, int center, int side) {

		int top = --center - side;
		int bottom = top + (side * 2);
		if (top < 0 || bottom < 0) {
			System.out.println("Invalid ");
			return;
		}
		boolean t = false;
		boolean b = false;
		int jlside = center - 1;
		int jrside = center + 1;
		int ilside = 0;
		int irside = 0;

		int ls = (board - 2) / 2;

		for (int i = 0; i < board; i++) {
			System.out.print("*");
			for (int j = 1; j < board - 1; j++) {

				if (i == 0 || i == board - 1) {
					System.out.print("*");
				} else if ((i == bottom && j == center)) {
					System.out.print("X");
				} else if ((j == top && i == center) || (j == bottom && i == center)) {
					System.out.print("X");
				} else if (t && i == ilside && j == jlside) {
					System.out.print("/");
					ilside++;
					jlside--;
				} else if (t && i == irside && j == jrside) {
					System.out.print("\\");
					irside++;
					jrside++;
				} else if (b && i == ilside && j == jlside) {
					System.out.print("\\");
					ilside++;
					jlside++;
				} else if (b && i == irside && j == jrside) {
					System.out.print("/");
					irside++;
					jrside--;
				} else if ((i == top && j == center)) {
					System.out.print("X");
					t = true;
					ilside = i + 1;
					irside = i + 1;
				} else {
					System.out.print(" ");
				}

			}
			if (i == center) {
				b = true;
				ilside++;
				irside++;
				jlside++;
				jrside--;
				t = false;
			}
			System.out.print("*");
			System.out.println();
		}

	}
	
//	public static void pattern1(int board, int center, int side) {
//
//		int top = --center - side;
//		int bottom = top + (side * 2);
//		if (top < 0 || bottom < 0) {
//			System.out.println("Invalid ");
//			return;
//		}
//		boolean t = false;
//		boolean b = false;
//		int jlside = center - 1;
//		int jrside = center + 1;
//		int ilside = 0;
//		int irside = 0;
//
//		int ls = (board - 2) / 2;
//
//		for (int i = 0; i < board; i++) {
//			System.out.print("*");
//			for (int j = 1; j < board - 1; j++) {
//
//				if (i == 0 || i == board - 1) {
//					System.out.print("*");
//				} else if ((i == bottom && j == center)) {
//					System.out.print("X");
//				} else if ((j == top && i == center) || (j == bottom && i == center)) {
//					System.out.print("X");
//				} else if (t && i == ilside && j == jlside) {
//					System.out.print("/");
//					ilside++;
//					jlside--;
//				} else if (t && i == irside && j == jrside) {
//					System.out.print("\\");
//					irside++;
//					jrside++;
//				} else if (b && i == ilside && j == jlside) {
//					System.out.print("\\");
//					ilside++;
//					jlside++;
//				} else if (b && i == irside && j == jrside) {
//					System.out.print("/");
//					irside++;
//					jrside--;
//				} else if ((i == top && j == center)) {
//					System.out.print("X");
//					t = true;
//					ilside = i + 1;
//					irside = i + 1;
//				} else {
//					System.out.print(" ");
//				}
//
//			}
//			if (i == center) {
//				b = true;
//				ilside++;
//				irside++;
//				jlside++;
//				jrside--;
//				t = false;
//			}
//			System.out.print("*");
//			System.out.println();
//		}
//
//	}
}