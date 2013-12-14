import java.util.*;
import java.math.BigInteger;

public class p29 {

	private static final Set<BigInteger> terms = new HashSet<BigInteger>();

	public static void main(String[] args) {
		for (int a = 2; a <= 100; ++a) {
			for (int b = 2; b <= 100; ++b) {
				BigInteger bigA = BigInteger.valueOf(a);
				BigInteger powAB = bigA.pow(b);
				terms.add(powAB);
			}
		}
		System.out.println("Size: " + terms.size());
	}
}