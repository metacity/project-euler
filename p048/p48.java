import java.math.BigInteger;

public class p48 {

	public static void main(String[] args) {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 1; i < 1001; ++i) {
			BigInteger selfPower = new BigInteger(String.valueOf(i));
			selfPower = selfPower.pow(i);
			sum = sum.add(selfPower);
		}
		System.out.println(sum.toString());
	}
}