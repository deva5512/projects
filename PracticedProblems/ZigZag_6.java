package Medium;

public class ZigZag_6 {
	public static void main(String[] args) {
		String res = convert("ABC", 2);
		System.out.println("res : " + res);
//		char [] a = new char[] { ' ' , 'a' , ' ' , 'b' };
//		String v = String.valueOf(a);
//		System.out.println(v);
		
		char[] a = new char[] { ' ', 'a' , ' ' , 'b' };
		StringBuilder sb = new StringBuilder();
		for (char c : a) {
		    if (c != ' ') {
		        sb.append(c);
		    }
		}
		String v = sb.toString();
		System.out.println(v);

	}
	
	
	public static String convert1(String s, int n) {

		int down = n - 1;
		String res = "";
		int m = 0;
		char[][] a = new char[n][1+s.length() /2];
		
		one:
		for (int col = 0; col < a[0].length; col++) {
			for (int row = 0; row < a.length; row++) {
				if(m!=s.length()&&col %down == 0) {
					a[row][col] = s.charAt(m++);
				}else if (m!=s.length()&&(row+col)%down == 0) {
					a[row][col] = s.charAt(m++);
					
				}
				if(m == s.length()) {
					break one;
				}
			}
		}
		down = 0;
		two:
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if(a[i][j] >= '!' && a[i][j] <= 'z') {
					res += a[i][j];
					down++;
				}
				if(down == m) {
					break two;
				}
			}
		}
		
		return res;
	}

	public static String convert(String s, int n) {

		int down = n - 1;
		String res = "";
		int m = 0, i = 0, j = 0;
		char[][] a = new char[n][1+s.length() / 2];
		one: while (m < s.length() - 1) {
			if (m % down == 0) {
				while (i < n) {
					a[i++][j] = s.charAt(m++);
					if (m == s.length())
						break one;
				}
				j++;
				i -= down;
			} else {
				while (j != n - 1 && i != 0) {
					a[i--][j++] = s.charAt(m++);
					if (m == s.length())
						break one;
				}
			}
		}
		down = 0;
		cut:
		for (int k = 0; k < a.length; k++) {
			for (int k2 = 0; k2 < a[0].length; k2++) {
				if(a[k][k2] >= '!' && a[k][k2] <= 'z') {
					res += a[k][k2];
					down++;
				}
				if(down == m) {
					break cut;
				}
			}
		}
		return res;
	}
	public static String spaceremover(String b ) {
		if(b.indexOf(" ") == -1) return b;
		return b.replace(" ", "");
	} 
}
