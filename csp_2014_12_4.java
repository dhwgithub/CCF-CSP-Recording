import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class csp_2014_12_4 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int m = (int) in.nval;
		
		Tri[] tris = new Tri[m];
		int num = 0;
		while (num != m) {
			in.nextToken();
			int u = (int) in.nval;
			in.nextToken();
			int v = (int) in.nval;
			in.nextToken();
			int w = (int) in.nval;
			tris[num ++] = new Tri(u, v, w);
		}
		
		Comparator<Tri> cmp = new Comparator<Tri>() {
			public int compare(Tri t1, Tri t2) {
				return t1.val - t2.val;
			}
		};
		Arrays.sort(tris, 0, m, cmp);
		
		Unionx uset = new Unionx(n);
		int cost = 0;
		num = 0;
		for (int i = 0; i < m; i ++) {
			int x = uset.find(tris[i].begin);
			int y = uset.find(tris[i].end);
			if (x != y) {
				num ++;
				uset.unionx(x, y);
				cost += tris[i].val;
			}
			if (num == n) {
				break;
			}
		}
		System.out.println(cost);
	}
	
	static class Unionx {
		int[] f;
		public Unionx(int n) {
			this.f = new int[n + 5];
			for (int i = 1; i <= n; i ++) {
				f[i] = i;
			}
		}
		
		public int find(int x) {
			return f[x] == x ? x : find(f[x]);
		}
		
		public void unionx(int x, int y) {
			x = find(x);
			y = find(y);
			if (x != y) {
				f[x] = y;
			}
		}
	}
	
	static class Tri {
		int begin;
		int end;
		int val;
		public Tri(int begin, int end, int val) {
			this.begin = begin;
			this.end = end;
			this.val = val;
		}
	}

}
