import java.math.BigInteger;

public class p188 {

	// I confess, I did not come up with the solution 
	// myself - just didn't have the mathematical prowess.

	public static void main(String[] args) {
		final BigInteger init = BigInteger.valueOf(1777L);
		final BigInteger mod = BigInteger.valueOf(100_000_000);
		
		BigInteger num = BigInteger.valueOf(1777L);
		BigInteger pow = BigInteger.valueOf(1855L);
		while (pow.compareTo(BigInteger.ZERO) != 0) {
			num = init.modPow(num, mod);
			pow = pow.subtract(BigInteger.ONE);
		}
		System.out.println(num.toString());
	}
}