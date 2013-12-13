import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Comparator;

public class p22 {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new FileReader("names.txt"));
		String line = br.readLine();
		br.close();
		String[] names = line.replace("\"", "").split(",");
		Arrays.sort(names, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		long totalSum = 0;
		for (int i = 0; i < names.length; ++i) {
			totalSum += (alphabeticValue(names[i]) * (i+1));
		}
		System.out.println(totalSum + "");
	}
	
	private static final int alphabeticValue(String name) {
		name = name.toUpperCase();
		int value = 0;
		for (int i = 0, len = name.length(); i < len; ++i) {
			value += ((int)(name.charAt(i)) - 64);
		}
		return value;
	}
}