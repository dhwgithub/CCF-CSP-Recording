import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class csp_2016_09_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		cin.nextToken();
		
		int n = (int) cin.nval;
		
		cin.nextToken();
		int pre = (int) cin.nval;
		int ans = 0;
		for (int i = 1; i < n; i ++) {
			cin.nextToken();
			int t = (int) cin.nval;
			ans = Math.max(ans, Math.abs(t - pre));
			pre = t;
		}
		
		System.out.println(ans);
	}

}
