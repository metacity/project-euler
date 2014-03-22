import java.util.Arrays;
import java.util.stream.IntStream;

public class p52 {

	public static void main(String[] args) {
		IntStream.iterate(Integer.parseInt(args[0]), n -> n + 1).limit(Integer.parseInt(args[1])).parallel().forEach(n -> {
			final char[] sortedChars = getSortedNumbers(n);
			if (Arrays.equals(sortedChars, getSortedNumbers(n * 2))
			 && Arrays.equals(sortedChars, getSortedNumbers(n * 3))
			 && Arrays.equals(sortedChars, getSortedNumbers(n * 4))
			 && Arrays.equals(sortedChars, getSortedNumbers(n * 5))
			 && Arrays.equals(sortedChars, getSortedNumbers(n * 6))) {
			 
				System.out.println("Found smallest: " + n);
				System.exit(0);
			 }
		});
	}
	
	private static final char[] getSortedNumbers(int n) {
		final char[] numChars = String.valueOf(n).toCharArray();
		Arrays.sort(numChars);
		return numChars;
	}
}