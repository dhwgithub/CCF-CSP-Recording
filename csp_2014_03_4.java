package csp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * BFS，只要能到达某个路由器，由于其性质则一定是最短路
 * 首先记录下每个路由器的位置并计算两两路由器是否可达（双向）
 * 然后初始化每个路由器的节点状态，包括编号、是否使用、到达所用步数、已使用新增路由器数
 * 最后将第1个路由器放入队列中从第2个路由器开始循环判断（当可以到达该路由器且该路由器未被使用时）：
 * 		若能到达第2个路由器则直接输出结果；
 * 		若该路由器是新增路由器，判断是否可以使用（上限），可以则更新该路由器状态并放入队列中
 * 		否则，直接使用原有路由器，更新该路由器状态并放入队列中
 */
public class csp_2014_03_4 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		int k = cin.nextInt();
		int r = cin.nextInt();
		
		int[][] pos = new int[n + m][2];
		for (int i = 0; i < n+m; i ++) {
			pos[i][0] = cin.nextInt();
			pos[i][1] = cin.nextInt();
		}
		
		boolean[][] dis = new boolean[n+m+5][n+m+5];
		for (int i = 0; i < n+m; i ++) {
			for (int j = i+1; j < n+m; j ++) {
				if (getDist(pos[i], pos[j]) <= (long)r * r) {
					dis[i][j] = true;
					dis[j][i] = true;
				}
			}
		}
		
		Node[] nodes = new Node[n + m];
		for (int i = 0; i < n+m; i ++) {
			nodes[i] = new Node(i, false);
		}
		
		nodes[0].isUsed = true;
		nodes[0].useNum = 0;
		nodes[0].step = 0;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(nodes[0]);
		
		DOWN : while ( ! queue.isEmpty()) {
			Node t = queue.poll();
			for (int i = 1; i < n+m; i ++) {
				if (dis[t.id][i] == true && nodes[i].isUsed == false) {
					if (i == 1) {  // 目标路由器
						System.out.println(t.step);
						break DOWN;
					} else if (i >= n) {
						if (t.useNum + 1 <= k) {
							nodes[i].isUsed = true;
							nodes[i].useNum = t.useNum + 1;
							nodes[i].step = t.step + 1;
							queue.add(nodes[i]);
						}
					} else {
						nodes[i].isUsed = true;
						nodes[i].useNum = t.useNum;
						nodes[i].step = t.step + 1;
						queue.add(nodes[i]);
					}
				}
			}
		}
	}
	
	private static long getDist(int[] x, int[] y) {
		return (long)(x[0] - y[0]) * (x[0] - y[0]) + (long)(x[1] - y[1]) * (x[1] - y[1]);
	}

	public static class Node {
		int id;  // 路由器编号
		boolean isUsed;  // 是否被使用
		int useNum;  // 使用了多少新增路由器
		int step;  // 步数
		public Node(int id, boolean isUsed) {
			this.id = id;
			this.isUsed = isUsed;
			this.useNum = 0;
			this.step = 0;
		}
	}

}
