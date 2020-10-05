import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2015_09_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int y = (int) in.nval;
		in.nextToken();
		int d = (int) in.nval;
		
		int sum = 0;
		for (int m = 1; m <= 12; m ++) {
			int t = getDays(y, m);
			sum += t;
			if (sum >= d) {
				sum = t - (sum - d);
				System.out.println(m);
				System.out.println(sum);
				break;
			}
		}
	}

	private static int getDays(int y, int m) {
		int[] d = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (m == 2 && ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)) {
			d[m] ++;
		}
		return d[m];
	}

}
