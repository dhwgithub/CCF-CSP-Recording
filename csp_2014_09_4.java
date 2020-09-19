package csp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 题意：每位客户都需要从分店之一出发到达，每到一次只能送一份。且送完之后人默认立即回到任意分店
 *
 */
public class csp_2014_09_4 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		cin.nextToken();
		int n = (int)cin.nval;
		cin.nextToken();
		int m = (int)cin.nval;
		cin.nextToken();
		int k = (int)cin.nval;
		cin.nextToken();
		int d = (int)cin.nval;
		
		int[][] graph = new int[n+5][n+5];  // 每个位置表示：=0表示可达 =-1表示不可达 >0 表示客户
		boolean[][] vis = new boolean[n+5][n+5];  // 标记是否走过
		Queue<Node> queue = new LinkedList<Node>();
		while (m-- > 0) {
			cin.nextToken();
			int x = (int)cin.nval;
			cin.nextToken();
			int y = (int)cin.nval;
			vis[x][y] = true;
			queue.add(new Node(x, y, 0));
		}
		while (k-- > 0) {
			cin.nextToken();
			int x = (int)cin.nval;
			cin.nextToken();
			int y = (int)cin.nval;
			cin.nextToken();
			int c = (int)cin.nval;
			graph[x][y] += c;
		}
		while (d-- > 0) {
			cin.nextToken();
			int x = (int)cin.nval;
			cin.nextToken();
			int y = (int)cin.nval;
			graph[x][y] = -1;
		}
		
		int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		long ans = 0;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (graph[node.x][node.y] > 0) {  // 该位置是客户
				ans += node.cnt * graph[node.x][node.y];
			}
			for (int i = 0; i < 4; i ++) {
				int x = node.x + dir[i][0];
				int y = node.y + dir[i][1];
				if (x <= 0 || x > n || y <= 0 || y > n) {
					continue;
				}
				if (graph[x][y] == -1 || vis[x][y]) {
					continue;
				}
				
				vis[x][y] = true;
				queue.add(new Node(x, y, node.cnt + 1));
			}
		}
		
		System.out.println(ans);
	}

	static class Node {
		int x;
		int y;
		int cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
