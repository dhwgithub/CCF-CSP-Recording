package csp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2014_09_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int)in.nval;
		int[] num = new int[n];
		
		int sum = 0;
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			num[i] = (int)in.nval;
			for (int j = 0; j < i; j ++) {
				if (Math.abs(num[i] - num[j]) == 1) {
					sum ++;
				}
			}
		}
		
		System.out.println(sum);
	}

}
