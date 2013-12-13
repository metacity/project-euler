public class p17 {

	private static final String[] sOnes = {
		"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
		};
	private static final String[] sTeens = {
		"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
	};
	private static final String[] sTens = {
		"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
	};
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(1000);
		for (int i = 1; i < 1000; ++i) {
			appendAsLetters(i, sb);
		}
		sb.append("onethousand");
		System.out.println(sb.toString());
		System.out.println(String.valueOf(sb.length()));
	}
	
	public static void appendAsLetters(int number, StringBuffer sb) {
		int hundreds = number / 100;
		int tens = (number >= 100) ? (number%100)/10 : number/10;
		int ones = number % 10;
		
		if (hundreds > 0) {
			sb.append(sOnes[hundreds-1]);
			sb.append("hundred");
			if (tens > 0 || ones > 0) {
				sb.append("and");
			}
		}

		if (tens > 1) {
			sb.append(sTens[tens-1]);
		} else if (tens == 1 && ones > 0) {
			sb.append(sTeens[ones-1]);
		} else if (tens == 1) {
			sb.append(sTens[tens-1]);
		} 
	
		if (tens != 1 && ones > 0) {
			sb.append(sOnes[ones-1]);
		}
	}
}