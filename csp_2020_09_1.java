import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;


public class csp_2020_09_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int x = (int) in.nval;
		in.nextToken();
		int y = (int) in.nval;
		
		Pos[] pos = new Pos[n];
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			int a = (int) in.nval;
			in.nextToken();
			int b = (int) in.nval;
			int dis = (a - x) * (a - x) + (b - y) * (b - y);
			pos[i] = new Pos(i + 1, dis);
		}
		
		Comparator<Pos> cmp = new Comparator<Pos>() {
			@Override
			public int compare(Pos p1, Pos p2) {
				if (p1.dis == p2.dis) {
					return p1.num - p2.num;
				}
				return p1.dis - p2.dis;
			}
		};
		
		Arrays.sort(pos, 0, n, cmp);
		
		for (int i = 0; i < 3; i ++) {
			System.out.println(pos[i].num);
		}
	}
	
	static class Pos{
		int num;
		int dis;
		public Pos(int num, int dis) {
			this.num = num;
			this.dis = dis;
		}
	}

}
