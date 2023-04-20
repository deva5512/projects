package Medium;

import java.util.ArrayList;

public class SetMatrix_73 {

	public static void main(String[] args) {
		int[][] a = { {0,1} };
		print(a);
		System.out.println();
		setZeroes(a);
//		jZero(a, 1);
//		iZero(a, 1);
		print(a);
	}

	public static void setZeroes(int[][] m) {
		if(m.length==0) {
			return ;
		}
		ArrayList<Integer> i_j = new ArrayList<>();
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == 0 ) {
					i_j.add(i);
					i_j.add(j);
				}
			}
		}
		for (int i = 0; i < i_j.size(); i++) {
			if(i%2==0) 
				iZero(m, i_j.get(i));
			 else 
				jZero(m, i_j.get(i));
		}
	}

	public static void jZero(int[][] a, int j1) {
		for (int i = 0; i < a.length; i++) {
			a[i][j1] = 0;
		}
	}

	public static void iZero(int[][] a, int i1) {
		for (int j = 0; j < a[i1].length; j++) {
			a[i1][j] = 0;
		}
	}

	public static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
