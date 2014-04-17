public class p34 {

	private static int[] factorials = new int[100];
	static {
		factorials[(int)'0'] = 1;
		factorials[(int)'1'] = 1;
		factorials[(int)'2'] = 2;
		factorials[(int)'3'] = 6;
		factorials[(int)'4'] = 24;
		factorials[(int)'5'] = 120;
		factorials[(int)'6'] = 720;
		factorials[(int)'7'] = 540;
		factorials[(int)'8'] = 40320;
		factorials[(int)'9'] = 362880;

	}

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 3; i < Integer.MAX_VALUE; ++i) {
			String num = String.valueOf(i);
			int sumOfFactorials = 0;
			for (int k = 0; k < num.length(); ++k) {
				sumOfFactorials += factorials[(int)num.charAt(k)];
			}
			if (sumOfFactorials == i) {
				sum += i;
				System.out.println("Added " + i);
			}
		}
		System.out.println("Total sum: " + sum);
	}
}