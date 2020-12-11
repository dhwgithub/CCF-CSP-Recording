import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class csp_2017_12_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int k = (int) in.nval;
		
		Stu[] stus = new Stu[n];
		for (int i = 0; i < n; i ++) {
			stus[i] = new Stu(i + 1);
		}
		
		int at = 0;
		int num = 1;  // 报数值
		int last = n;  // 还剩下
		while (last > 1) {
			// 排除淘汰的
			if (! stus[at].here) {
				at = (at + 1) % n;
				continue;
			}
			
			// 被淘汰
			if (num % k == 0 || num % 10 == k) {
				stus[at].here = false;
				last --;
			}
			
			num ++;
			at = (at + 1) % n;
		}

		for (int i = 0; i < n; i ++) {
			if (stus[i].here) {
				System.out.println(stus[i].id);
				break;
			}
		}
	}
	
	static class Stu{
		int id;
		boolean here;
		public Stu(int id) {
			this.id = id;
			this.here = true;
		}
	}

}
