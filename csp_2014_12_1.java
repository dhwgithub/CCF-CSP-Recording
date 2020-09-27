import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2014_12_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int)in.nval;
		int[] num = new int[n + 5];
		
		in.nextToken();
		int t = (int) in.nval;
		System.out.print(1);
		num[t] ++;
		for (int i = 1; i < n; i ++) {
			in.nextToken();
			t = (int) in.nval;
			num[t] ++;
			System.out.print(" " + num[t]);
		}
		System.out.println();
	}

}
