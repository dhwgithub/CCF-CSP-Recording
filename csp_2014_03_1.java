package csp;

import java.util.Scanner;

public class csp_2014_03_1 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[] z = new int[1005];
		int[] f = new int[1005];
		int ans = 0;
		for (int i = 0; i < n; i ++) {
			int t = cin.nextInt();
			if (t > 0) {
				if (f[t] > 0) {
					f[t] --;
					ans ++;
				} else {
					z[t] ++;
				}
			} else {
				t = -t;
				if (z[t] > 0) {
					z[t] --;
					ans ++;
				} else {
					f[t] ++;
				}
			}
		}
		System.out.println(ans);
	}

}
