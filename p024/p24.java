import java.util.*;

public class p24 {
	
	private static final ArrayList<String> permutations = new ArrayList<String>();

	public static void main(String[] args) {
		perm("", "0123456789");
		Collections.sort(permutations);
		System.out.println(permutations.get(999999));
	}
	
	public static final void perm(String prefix, String s) {
		int len = s.length();
		if (len == 0) {
			permutations.add(prefix);
		} else {
			for (int i = 0; i < len; ++i) {
				perm(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, len));
			}
		}
	}
}