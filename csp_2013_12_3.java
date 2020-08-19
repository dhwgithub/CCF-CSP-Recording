package csp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2013_12_3 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int)in.nval;
		int[] num = new int[n+5];
		int ans = 0;
		for (int i=0; i<n; i++) {
			in.nextToken();
			num[i] = (int)in.nval;
			ans = Math.max(ans, num[i]);
		}
		
		for (int i=0; i<n; i++) {
			int t = num[i];
			for (int j=i+1; j<n; j++) {
				t = Math.min(t, num[j]);
				ans = Math.max(ans, t * (j-i+1));
			}
		}
		
		System.out.println(ans);
	}

}
