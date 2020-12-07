import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;


public class csp_2019_03_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		
		int[] num = new int[n];
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			num[i] = (int) in.nval;
		}
		
		int a = num[0];
		int b = num[n - 1];
		double c = num[n / 2];
		if (n % 2 == 0) {
			c = (num[n / 2 - 1] + num[n / 2]) / 2.0;
		}
		
		if (a < b) {
			a = a ^ b;
			b = a ^ b;
			a = a ^ b;
		}
		
		if ((c * 10) % 10 > 0) {  // 小数
			System.out.printf("%d %.1f %d\n", a, c, b); 
		} else {
			System.out.println(a + " " + (int)c + " " + b); 
		}
	}

}