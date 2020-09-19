package csp;

import java.util.Scanner;

public class csp_2014_09_2 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int ans = 0;
		int n = cin.nextInt();
		boolean[][] tri = new boolean[105][105];
		while (n-- > 0) {
			int t10 = cin.nextInt();
			int t11 = cin.nextInt();
			int t20 = cin.nextInt();
			int t21 = cin.nextInt();
			for (int i = t10; i < t20; i ++) {
				for (int j = t11; j < t21; j ++) {
					if (!tri[i][j]) {
						tri[i][j] = true;
						ans ++;
					}
				}
			} 
		}
		System.out.println(ans);
	}

}
