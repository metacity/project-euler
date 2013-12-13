import java.util.*;

public class p30 {
	
	private static final ArrayList<Integer> fifthPowers = new ArrayList<Integer>();

	public static void main(String[] args) {
		for (int i = 2; i <= 355000; ++i) {
			if (hasFifthPowerDigits(i)) {
				fifthPowers.add(i);
			}
		}
		int sum = 0;
		for (Integer number : fifthPowers) {
			sum += number;
		}
		System.out.println(sum + "");
		System.exit(0);
	}
	
	private static boolean hasFifthPowerDigits(int number) {
		int sum = 0;
		String numberStr = String.valueOf(number);
		for (int i = 0; i < numberStr.length(); ++i) {
			int digit = Character.getNumericValue(numberStr.charAt(i));
			sum += (int)Math.pow(digit, 5);
		}
		return (sum == number) ? true : false;
	}
}