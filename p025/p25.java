import java.math.BigInteger;

public class p25 {
	public static void main(String[] args) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		BigInteger fib = new BigInteger("2");

		long termCount = 2;
		while (fib.toString().length() < 1000) {
			BigInteger saveFib = fib;
			fib = b.add(a);
			a = b;
			b = fib;
			++termCount;
		}
		
		System.out.println(termCount);
		System.out.println(fib + "\t length:" + fib.toString().length());
		
	}
	

}