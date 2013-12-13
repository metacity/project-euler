public class p4 {
	public static void main(String args[]) {
		int max = 0;
		for (int i = 999; i > 99; --i) {
			for (int j = 999; j > 99; --j) {
				if (isPalindrome(Integer.toString(i*j)) && i*j > max) {
					max = i * j;
				}
			}
		}
		System.out.println(max);
	}
	
	private static boolean isPalindrome(String word) {
		for (int i = 0; i < word.length(); ++i) {
			if (word.charAt(i) != word.charAt(word.length()-1-i))
				return false;
		}
		return true;
	}
}