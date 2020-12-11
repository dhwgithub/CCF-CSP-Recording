import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class csp_2017_09_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		n /= 10;
		
		int sum = 0;
		if (n / 5 > 0) {
			int t = n / 5;
			sum += t * 5 + t * 2;
			n -= t * 5;
		}
		if (n / 3 > 0) {
			int t = n / 3;
			sum += t * 3 + t;
			n -= t * 3;
		}
		sum += n;
		
		System.out.println(sum);
	}
}
