import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2019_09_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int m = (int) in.nval;
		
		long sum = 0;
		long drop = 0;
		int num = 0;
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			int t = (int) in.nval;
			sum += t;
			t = 0;
			for (int j = 0; j < m; j ++) {
				in.nextToken();
				int c = (int) in.nval;
				c = -c;
				t += c;
				sum -= c;
				if (t > drop) {
					drop = t;
					num = i + 1;
				}
			}
		}
		
		System.out.println(sum + " " + num + " " + drop);
	}

}
