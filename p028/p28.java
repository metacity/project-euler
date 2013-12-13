public class p28 {

	public static void main(String[] args) {
		int sideWidth = Integer.parseInt(args[0]);
		long sum = sideWidth * sideWidth;
		
		int rounds = (sideWidth - 1) / 2;
		int prev = sideWidth * sideWidth;
		for (int i = 0; i < rounds; ++i) {
			for (int j = 1; j <= 4; ++j) {
				int number = (prev - (sideWidth - 1 - i*2));
				sum += number;
				prev = number;
			}			
		}
		System.out.println(sum + "");
	}
}