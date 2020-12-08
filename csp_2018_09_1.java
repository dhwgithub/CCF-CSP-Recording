import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2018_09_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;

		int[] num = new int[n];
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			num[i] = (int) in.nval;
		}
		
		System.out.print((num[0] + num[1]) / 2);
		for (int i = 1; i < n - 1; i ++) {
			int t = num[i - 1] + num[i] + num[i + 1];
			System.out.print(" " + t / 3);
		}
		System.out.println(" " + (num[n - 2] + num[n - 1]) / 2);
	}

}
