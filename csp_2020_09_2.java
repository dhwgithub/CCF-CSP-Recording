import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class csp_2020_09_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int k = (int) in.nval;
		in.nextToken();
		int t = (int) in.nval;
		in.nextToken();
		int x1 = (int) in.nval;
		in.nextToken();
		int y1 = (int) in.nval;
		in.nextToken();
		int x2 = (int) in.nval;
		in.nextToken();
		int y2 = (int) in.nval;
		
		int sum1 = 0;
		int sum2 = 0;
		
		while (n -- > 0) {
			int k_sum = 0;
			boolean sum1_f = false;
			boolean sum2_f = false;
			for (int i = 0; i < t; i ++) {
				in.nextToken();
				int x = (int) in.nval;
				in.nextToken();
				int y = (int) in.nval;
				if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
					sum1_f = true;
					k_sum ++;
					if (k_sum >= k) {
						sum2_f = true;
					}
				} else {
					k_sum = 0;
				}
			}
			if (sum1_f) sum1 ++;
			if (sum2_f) sum2 ++;
		}
		
		System.out.println(sum1);
		System.out.println(sum2);
	}

}
