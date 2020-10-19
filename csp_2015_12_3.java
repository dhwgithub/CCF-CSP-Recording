package csp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class csp_2015_12_3 {
	
	static int n, m;
		
	public static void main(String[] args) throws IOException {
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		cin.nextToken();
		n = (int) cin.nval;
		cin.nextToken();
		m = (int) cin.nval;
		cin.nextToken();
		int q = (int) cin.nval;
		
		char[][] map = new char[n][m];
		for (int i = 0; i < n; i ++)
			Arrays.fill(map[i], '.');
		
		while (q-- > 0) {
			cin.nextToken();
			int type = (int) cin.nval;
			if (type == 0) {  //划线
				cin.nextToken();
				int x1 = (int) cin.nval;
				cin.nextToken();
				int y1 = (int) cin.nval;
				cin.nextToken();
				int x2 = (int) cin.nval;
				cin.nextToken();
				int y2 = (int) cin.nval;
				if (x1 == x2) {
					if (y1 > y2) {
						int t = y1;
						y1 = y2;
						y2 = t;
					}
					for (int i = y1; i <= y2; i ++) {
						if (map[x1][i] == '|' || map[x1][i] == '+') 
							map[x1][i] = '+';
						else 
							map[x1][i] = '-';
					}
				}
				if (y1 == y2) {
					if (x1 > x2) {
						int t = x1;
						x1 = x2;
						x2 = t;
					}
					for (int i = x1; i <= x2; i ++) {
						if (map[i][y1] == '-' || map[i][y1] == '+') 
							map[i][y1] = '+';
						else 
							map[i][y1] = '|';
					}
				}
			} else {
				cin.nextToken();
				int x = (int) cin.nval;
				cin.nextToken();
				int y = (int) cin.nval;
				cin.nextToken();
				char c = cin.sval.charAt(0);
				dfs(x, y, c, map);
			}
		}
		
		char[][] ans = new char[m][n];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				ans[j][i] = map[i][j];
				if (ans[j][i] == '|')
					ans[j][i] = '-';
				else if (ans[j][i] == '-')
					ans[j][i] = '|';
			}
		}
		
		for (int i = m - 1; i >= 0; i --) {
			for (int j = 0; j < n; j ++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	}

	private static void dfs(int x, int y, char c, char[][] map) {
		if (x < 0 || y < 0 || x >= n || y >= m) {
			return ;
		}
		if (map[x][y] == '-' || map[x][y] == '+' 
				|| map[x][y] == '|' || map[x][y] == c) {
			return ;
		}
		
		map[x][y] = c;
		dfs(x + 1, y, c, map);
		dfs(x - 1, y, c, map);
		dfs(x, y + 1, c, map);
		dfs(x, y - 1, c, map);
	}

}
