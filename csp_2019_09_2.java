import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;


public class csp_2019_09_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		
		long sum = 0;  // 剩余苹果总数
		int sumT = 0;  // 掉落苹果树棵数
		int sumE = 0;  // 相邻3课树掉落的组数
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			int nn = (int) in.nval;
			
			in.nextToken();
			int curP = (int) in.nval;  // 当前苹果总数
			for (int j = 1; j < nn; j ++) {
				in.nextToken();
				int t = (int) in.nval;
				if (t > 0) {  // 重新统计
					if (curP != t && !ans.contains(i + 1)) {
						ans.add(i + 1);
						sumT ++;
					}
					curP = t;
				} else {
					t = -t;
					curP -= t;
				}
			}
			sum += curP;
		}
		
		for (int i = 0; i < sumT; i ++) {
			int a = ans.get(i % sumT);
			int b = ans.get((i + 1) % sumT);
			int c = ans.get((i + 2) % sumT);
			if (a == b - 1 && a == c - 2) {
				sumE ++;
			} else if (a == b - 1 && c == 1) {
				sumE ++;
			} else if (a == n && b == 1 && c == 2) {
				sumE ++;
			}
		}
		
		System.out.println(sum + " " + sumT + " " + sumE);
	}

}
/*
5
4 10 0 9 0
4 10 -2 7 0
2 10 0
4 10 -3 5 0
4 10 -1 8 0

4
4 74 -7 -12 -5
5 73 -8 -6 59 -4
5 76 -5 -10 60 -2
5 80 -6 -15 59 0
*/
