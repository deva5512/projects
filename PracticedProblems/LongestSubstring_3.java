package Medium;

import java.util.HashSet;

public class LongestSubstring_3 {
	public static void main(String[] args) {
		// int res = lengthOfLongestSubstring("abcabcabcabc");
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		int num = 21;
		System.out.println((num&1)==0);
	}

	public static int lengthOfLongestSubstring1(String s) {

		StringBuilder sb = new StringBuilder(s);
		int i = 0, j = 1;
		String check;
		int len = 0;
		while (i <= s.length() - 1 && j <= s.length()) {

			check = sb.substring(i, j);
			if (j == s.length()) {
				i++;
			}
			if (j < s.length() && check.indexOf(sb.charAt(j)) == -1) {
				j++;
			} else if (j < s.length() && check.indexOf(sb.charAt(j)) != -1) {
				i++;
				j = i + 1;

			}
			len = Math.max(len, check.length());

			if (len >= s.length() - i) {
				break;
			}
		}
		return len;
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int a = 0;
		int b = 0;
		int max = 0;
		
		HashSet<Character> one = new HashSet<>();
		
		while(b<s.length()) {
			if(!one.contains(s.charAt(b))) {
				one.add(s.charAt(b));
				b++;
				max = Math.max(one.size() , max);
			} else {
				one.remove(s.charAt(a));
				a++;
			}
		}
		return max;
	}

}

//public int lengthOfLongestSubstring(String s) {
//char[] ch = s.toCharArray();
//int fir_len = 0;
//int up_len = 0;
//String comp = "";
//for (int i = 0; i < ch.length; i++) {
//	if (comp.indexOf(ch[i]) == -1) {
//		comp += ch[i];
//		up_len++;
//	} else {
//		if (fir_len < up_len) {
//			fir_len = up_len;
//		}
//		up_len = 0;
//		comp = "";
//        for (int j = i; j >= 0; j--) {
//			if (comp.indexOf(ch[i]) == -1) {
//				comp += ch[i];
//				i--;
//			} else {
//				break;
//			}
//		}
//		comp = "";
//	}
//}
//return (fir_len<up_len) ? up_len : fir_len;
//}
