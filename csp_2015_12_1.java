package csp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2015_12_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int s = (int) in.nval;
		String t = "" + s;
		int sum = 0;
		for (int i = 0; i < t.length(); i ++) {
			sum += (t.charAt(i) - '0');
		}
		System.out.println(sum);
	}

}
