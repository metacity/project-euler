import java.math.BigInteger;

public class p16 {
	public static void main(String[] args) {
		BigInteger number = new BigInteger("2");
		number = number.pow(1000);
		
		String[] arr = number.toString().split("");
		int sum = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i].length() != 0)
				sum += Integer.parseInt(arr[i]);
		}
		
		System.out.println(sum);
	}
	

}