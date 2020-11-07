import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class csp_2020_06_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int x1 = (int) in.nval;
		in.nextToken();
		int x2 = (int) in.nval;
		
		Pos[] p1 = new Pos[x1];
		Pos[] p2 = new Pos[x2];
		
		for (int i = 0; i < x1 + x2; i ++) {
			in.nextToken();
			int x = (int) in.nval;
			in.nextToken();
			int y = (int) in.nval;
			if (i < x1) {
				p1[i] = new Pos(x, y);
			} else {
				p2[i - x1] = new Pos(x, y);
			}
		}
		
		Comparator<Pos> cmp = new Comparator<Pos>() {
			@Override
			public int compare(Pos p1, Pos p2) {
				return p1.index - p2.index;
			}
		};
		
		Arrays.sort(p1, 0, x1, cmp);
		Arrays.sort(p2, 0, x2, cmp);
		
		long ans = 0;
		int j = 0;
		for (int i = 0; i < x1 && j < x2; i ++) {
			int index = p1[i].index;
			while (j < x2 && p2[j].index < index) {
				j ++;
			}
			if (j < x2 && index == p2[j].index) {
				ans += (long)p1[i].val * p2[j].val;
			}
		}
		
		System.out.println(ans);
	}
	
	static class Pos{
		int index;
		int val;
		public Pos(int index, int val) {
			this.index = index;
			this.val = val;
		}
	}

}
/*
10 3 4
4 5
7 -3
10 1
1 10
4 20
5 30
7 40
*/