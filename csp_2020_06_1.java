import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2020_06_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int m = (int) in.nval;
		
		Pos[] pos = new Pos[n];
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			int x = (int) in.nval;
			in.nextToken();
			int y = (int) in.nval;
			in.nextToken();
			String c = in.sval;
			pos[i] = new Pos(x, y, c);
		}
		
		while (m-- > 0) {
			in.nextToken();
			int x0 = (int) in.nval;
			in.nextToken();
			int x1 = (int) in.nval;
			in.nextToken();
			int x2 = (int) in.nval;
			
			int f = 0;
			String k = "";
			boolean ok = true;
			for (int i = 0; i < n; i ++) {
				int t = x0 + x1 * pos[i].x + x2 * pos[i].y;
				if (i == 0) {
					f = t;
					k = pos[i].c;
				} else if (ok){
					if (t < 0) {
						if (f < 0) {
							ok = k.equals(pos[i].c) ? true : false;
						} else {
							ok = !k.equals(pos[i].c) ? true : false;
						}
					} else {
						if (f > 0) {
							ok = k.equals(pos[i].c) ? true : false;
						} else {
							ok = !k.equals(pos[i].c) ? true : false;
						}
					}
				}
			}
			System.out.println(ok ? "Yes" : "No");
		}
	}

	static class Pos{
		int x;
		int y;
		String c;
		public Pos(int x, int y, String c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
/*
9 3
1 1 A
1 0 A
1 -1 A
2 2 B
2 3 B
0 1 A
3 1 B
1 3 B
2 0 A
0 2 -3
-3 0 2
-3 1 1
*/