package csp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2013_12_1 {
	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		
		in.nextToken();
		int n = (int)in.nval;
		
		int[] num = new int[10005];
		int sum = 0;
		
		for (int i=0; i<n; i++) {
			in.nextToken();
			int t = (int)in.nval;
			num[t] ++;
			sum = num[t] > sum ? num[t] : sum;
		}
		
		for (int i=1; i<=10000; i++) {
			if (num[i] == sum) {
				System.out.println(i);
				break;
			}
		}
	}
	
}
