import java.util.stream.IntStream;

public class p36 {

	public static void main(String[] args) {
		int sum = IntStream.iterate(1, n -> n + 1)
				.limit(1_000_000)
				.parallel()
				.filter(n -> isPalindrome(Integer.toString(n)) && isPalindrome(Integer.toBinaryString(n)))
				.sum();
		System.out.println("Sum: " + sum);
	}
	
	private static final boolean isPalindrome(final String string) {
		final int len = string.length();
		final int halfway = len / 2;
		
		for (int i = 0; i < halfway; ++i) {
			if (string.charAt(i) != string.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}
}