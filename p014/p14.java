public class p14 {
	public static void main(String[] args) {
		long maxChain = 0;
		long maxStart = 0;
		
		for (long i = 1; i < 1000000; ++i) {
			long n = i;
			long chainLength = 1;
			while (n != 1) {
				if (n % 2 == 0)
					n = n / 2;
				else
					n = 3 * n + 1;
				
				++chainLength;
				if (chainLength > maxChain) {
					maxChain = chainLength;
					maxStart = i;
					//System.out.println("New max: " + i + " with length of " + chainLength);
				}
			}		
		}
		
		System.out.println("Max: " + maxStart);
	}
	

}