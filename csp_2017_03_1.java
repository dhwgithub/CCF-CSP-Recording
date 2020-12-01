import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;


public class csp_2017_03_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		
		cin.nextToken();
		int n = (int) cin.nval;
		
		cin.nextToken();
		int k = (int) cin.nval;
		
		int ans = 0;
		int i = 0;
		int sum = 0;
		while (i < n) {
			if (sum < k) {
				cin.nextToken();
				sum += (int) cin.nval;
				i ++;
			}
			if (sum >= k || i == n) {
				ans ++;
				sum = 0;
			}
		}
		
		System.out.println(ans);
	}

}
