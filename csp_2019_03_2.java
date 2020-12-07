import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/*
 * 先乘除后加减，把减法转变为加法运算
 */
public class csp_2019_03_2 {

	public static void main(String[] args) throws IOException {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		
		while(n -- > 0) {
			Stack<Integer> num = new Stack<>();

			char[] s = cin.next().toCharArray();
			
			num.push(s[0] - '0');
			int flag = 1;
			for (int i = 1; i < 7; i ++) {
				if (s[i] == '+') {
					continue;
				} else if (s[i] == '-') {  // 将减法转变为加法
					flag = -1;
				} else if (s[i] == 'x') {
					int t = num.pop() * (s[i + 1] - '0');
					num.push(t);
					i ++;
				} else if (s[i] == '/') {
					int t = num.pop() / (s[i + 1] - '0');
					num.push(t);
					i ++;
				} else {
					num.push((s[i] - '0') * flag);
					flag = 1;
				}
			}
			
			while (num.size() > 1) {
				int b = num.pop();
				int a = num.pop();
				num.push(a + b);
			}
			
			System.out.println(num.pop() == 24 ? "Yes" : "No");
		}
	}

}
/*
11
9+3+4x3
5+4x5x5
7-9-9+8
5x6/5x4
3+5+7+9
1x1+9-9
1x9-5/9
8/5+6x9
6x7-3x6
6x4+4/5
5-6-6-6
*/