import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class csp_2015_03_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int m = (int) in.nval;
		
		int[][] mtr = new int[n][m];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				in.nextToken();
				mtr[i][j] = (int) in.nval;
			}
		}
		
		for (int i = m - 1; i >= 0; i --) {
			System.out.print(mtr[0][i]);
			for (int j = 1; j < n; j ++) {
				System.out.print(" " + mtr[j][i]);
			}
			System.out.println();
		}
	}
}
