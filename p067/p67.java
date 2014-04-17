import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class p67 {

	public static void main(String[] args) throws IOException {
		int[][] pyramid = getPyramid();
		countLineSums(pyramid);

		int[] bottomLine = pyramid[pyramid.length-1];
		Arrays.sort(bottomLine);
		System.out.println("Largest path sum: " + bottomLine[bottomLine.length-1]);
	}

	private static final int[][] getPyramid() throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("triangle.txt"));
		int numOfLines = lines.size();
		int[][] pyramid = new int[numOfLines][];

		for (int i = 0; i < numOfLines; ++i) {
			String[] strNums = lines.get(i).split(" ");
			pyramid[i] = new int[strNums.length];
			for (int k = 0; k < strNums.length; ++k) {
				pyramid[i][k] = Integer.parseInt(strNums[k]);
			}
		}

		return pyramid;
	}

	private static final void countLineSums(int[][] pyramid) {
		for (int i = 1; i < pyramid.length; ++i) {
			for (int k = 0; k < pyramid[i].length; ++k) {
				int node = pyramid[i][k];
				int sumWithLeftParent = (k == 0) ? node : node + pyramid[i-1][k-1];
				int sumWithRightParent = (k == pyramid[i].length-1) ? node : node + pyramid[i-1][k];
				pyramid[i][k] = Math.max(sumWithLeftParent, sumWithRightParent);
			}
		}
	}
}