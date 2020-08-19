package csp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class csp_2014_03_2 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		Win[] wins = new Win[n];
		
		int x1, y1, x2, y2;
		for (int i=0; i<n; i++) {
			x1 = cin.nextInt();
			y1 = cin.nextInt();
			x2 = cin.nextInt();
			y2 = cin.nextInt();
			wins[i] = new Win(i+1, i+1, x1, y1, x2, y2);
		}
		
		Comparator<Win> cmp = new Comparator<Win>() {
			@Override
			public int compare(Win w1, Win w2) {
				if (w1.layer > w2.layer) {
					return 1;
				} else if (w1.layer < w2.layer) {
					return -1;
				} else {
					return 0;
				}
			}
		};
		
		for (int i=0; i<m; i++) {
			int x = cin.nextInt();
			int y = cin.nextInt();
			boolean find = false;
			for (int j=n-1; j>=0; j--) {
				x1 = wins[j].x1;
				y1 = wins[j].y1;
				x2 = wins[j].x2;
				y2 = wins[j].y2;
				if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
					find = true;
					System.out.println(wins[j].id);
					wins[j].layer = n;
					for (int k=j+1; k<n; k++) {
						wins[k].layer -= 1;
					}
					Arrays.sort(wins, 0, n, cmp);
					
					break;
				}
			}

			if (find == false) {
				System.out.println("IGNORED");
			}
		}
	}

	static class Win{
		int id;
		int layer;
		int x1, y1, x2, y2;
		public Win(int id, int layer, int x1, int y1, int x2, int y2) {
			this.id = id;
			this.layer = layer;
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
}
