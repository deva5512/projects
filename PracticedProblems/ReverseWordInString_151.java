package Medium;

public class ReverseWordInString_151 {
	public static void main(String[] args) {
		System.out.println(reverseWords("one two three"));
	}
	public static String reverseWords(String s) {
		s= s.trim();
		if(s.lastIndexOf(' ') == -1) return s;
		return s.substring(s.lastIndexOf(' ')+1)+" "+reverseWords(s.substring(0,s.lastIndexOf(' ')+1));
    }
}
