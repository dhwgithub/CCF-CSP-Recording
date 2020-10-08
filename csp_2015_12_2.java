package csp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2015_12_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int m = (int) in.nval;
		
		int[][] map = new int[n][m];
		boolean[][] vis = new boolean[n][m];
		for (int i = 0; i < n; i ++) {
			int sum = 1;
			in.nextToken();
			map[i][0] = (int) in.nval;
			int t = map[i][0];
			for (int j = 1; j < m; j ++) {
				in.nextToken();
				map[i][j] = (int) in.nval;
				if (t == map[i][j] && j != m-1) {
					sum ++;
				} else {
					int jx = j - 1;
					if (j == m - 1 && t == map[i][j]) {
						jx ++;
						sum ++;
					}
					if (sum >= 3) {
						while (sum-- > 0) {
							vis[i][jx] = true;
							jx --;
						}
					}
					sum = 1;
				}
				t = map[i][j];
			}
		}
		
//		for (int i = 0; i < n; i ++) {
//			System.out.print(vis[i][0]);
//			for (int j = 1; j < m; j ++) {
//				System.out.print(" " + vis[i][j]);
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < m; i ++) {
			int sum = 1;
			int t = map[0][i];
			for (int j = 1; j < n; j ++) {
				if (t == map[j][i] && j != n-1) {
					sum ++;
				} else {
					int jx = j - 1;
					if (j == n - 1 && t == map[j][i]) {
						jx ++;
						sum ++;
					}
					if (sum >= 3) {
						while (sum-- > 0) {
							vis[jx][i] = true;
							jx --;
						}
					}
					sum = 1;
				}
				t = map[j][i];
			}
		}
		
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				if (vis[i][j]) {
					map[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < n; i ++) {
			System.out.print(map[i][0]);
			for (int j = 1; j < m; j ++) {
				System.out.print(" " + map[i][j]);
			}
			System.out.println();
		}
	}

}
