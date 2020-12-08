import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2018_12_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int r = (int) in.nval;
		in.nextToken();
		int y = (int) in.nval;
		in.nextToken();
		int g = (int) in.nval;
		long sum = 0;
		
		in.nextToken();
		int n = (int) in.nval;
		while (n-- > 0) {
			in.nextToken();
			int f = (int) in.nval;
			in.nextToken();
			int t = (int) in.nval;
			if (f == 0) sum += t;
			else if (f== 1) sum += t;
			else if (f == 2) sum += t + r;
		}
		
		System.out.println(sum);
	}

}
