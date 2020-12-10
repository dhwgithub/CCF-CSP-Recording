import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2018_03_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int sum = 0;
		int add = 2;
		while (true) {
			in.nextToken();
			int t = (int) in.nval;
			
			if (t == 0) break;
			else if (t == 1) {
				sum += 1;
				add = 2;
			}
			else if (t == 2) {
				sum += add;
				add += 2;
			}
		}
		
		System.out.println(sum);
	}

}
