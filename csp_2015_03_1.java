import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2015_03_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int m = (int) in.nval;
		int[][] num = new int[m][n];
		for (int i = 0; i < n; i ++) {
			for (int j = m - 1; j >= 0; j --) {
				in.nextToken();
				num[j][i] = (int) in.nval;
			}
		}
		
		for (int i = 0; i < m; i ++) {
			System.out.print(num[i][0]);
			for (int j = 1; j < n; j ++) {
				System.out.print(" " + num[i][j]);
			}
			System.out.println();
		}
	}

}
