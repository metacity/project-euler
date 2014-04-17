import java.util.stream.LongStream;

public class p36 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		long sum = LongStream.rangeClosed(1, 200_000_000)
				.parallel()
				.filter(n -> isPalindrome(Long.toString(n)) && isPalindrome(Long.toBinaryString(n)))
				.sum();
		System.out.println("Time: " + (System.nanoTime() - start)/1e6 + " ms");
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