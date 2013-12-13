import java.math.BigInteger;

public class p20 {
	public static void main(String[] args) {
		BigInteger factorial = new BigInteger("1");
		for (int i = 2; i < 101; ++i) {
			factorial = factorial.multiply(new BigInteger(Integer.toString(i)));
		}
		
		System.out.println(factorial.toString());
		String[] sFac = factorial.toString().split("");
		long sum = 0;
		for (int i = 0; i < sFac.length; ++i) {
			if (sFac[i].length() != 0)
				sum += Integer.parseInt(sFac[i]);
		}
		
		System.out.println(sum);
	}
	

}