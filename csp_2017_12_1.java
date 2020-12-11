import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class csp_2017_12_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		
		int[] num = new int[n];
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			num[i] = (int) in.nval;
		}
		Arrays.sort(num);
		
		int ans = Integer.MAX_VALUE;
		int pre = num[0];
		for (int i = 1; i < n; i ++) {
			ans = Math.min(ans, 
					Math.abs(pre - num[i]));
			pre = num[i];
		}
		
		System.out.println(ans);
	}

}
