import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2015_09_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int pre = (int) in.nval;
		int sum = 1;
		for (int i = 1; i < n; i ++) {
			in.nextToken();
			int t = (int) in.nval;
			if (t != pre) {
				sum ++;
				pre = t;
			}
		}
		System.out.println(sum);
	}

}
