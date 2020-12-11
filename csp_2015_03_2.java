import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class csp_2015_03_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		
		Num[] num = new Num[1001];
		for (int i = 0; i < 1001; i ++) {
			num[i] = new Num(i, 0);
		}
		
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			num[(int) in.nval].cnt ++;
		}
		
		Arrays.sort(num, (n1, n2) -> n2.cnt == n1.cnt ?
				n1.num - n2.num : n2.cnt - n1.cnt);
		
		for (int i = 0; i < 1001 && num[i].cnt > 0; i ++) {
			System.out.println(num[i].num + " " + num[i].cnt);
		}
	}
	
	static class Num{
		int num;
		int cnt;
		public Num(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}
