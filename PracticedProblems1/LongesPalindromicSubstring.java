package WeeklyAssignment;

public class LongesPalindromicSubstring {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("acbbca"));
	}
	
	public static String longestPalindrome(String s) {
		
		String res= "";
		
		for(int i = 0;i<s.length();i++) {
			int a = i;
			int b = i;
			while(a >=0 && b < s.length() && s.charAt(a) == s.charAt(b)) {
				a--;
				b++;
			}
			String got = s.substring(a+1 , b);
			if(res.length() < got.length()) {
				res = got;
			}
			
			a = i-1;
			b = i;
			while(a >=0 && b < s.length() && s.charAt(a) == s.charAt(b)) {
				a--;
				b++;
			}
			got = s.substring(a+1 , b);
			if(res.length() < got.length()) {
				res = got;
			}
		}
		return res;
	}
}
