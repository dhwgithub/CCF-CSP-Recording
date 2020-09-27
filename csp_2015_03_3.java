import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2015_03_3 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int a = (int) in.nval;
		in.nextToken();
		int b = (int) in.nval;
		in.nextToken();
		int c = (int) in.nval;
		in.nextToken();
		int y1 = (int) in.nval;
		in.nextToken();
		int y2 = (int) in.nval;
		
		for (int i = y1; i <= y2; i ++) {
			int zhou = getZhou(i, a);  // 求出第i年a月1日是星期几
			int[] nyr = getFirst(i, a, zhou, c);  // 求出第i年a月的第一个星期c
			int[] ans = getAns(nyr, b);  // 求出第i年a月的第b个星期c
			if (isOk(ans, i)) {  // 判断日期是否合法
				printAns(ans);  // 格式化输出
			} else {
				System.out.println("none");
			}
		}
		
	}

	private static void printAns(int[] nyr) {
		System.out.print(nyr[0] + "/");
		
		if (nyr[1] < 10) {
			System.out.print("0" + nyr[1] + "/");
		} else {
			System.out.print(nyr[1] + "/");
		}
		
		if (nyr[2] < 10) {
			System.out.print("0" + nyr[2]);
		} else {
			System.out.print(nyr[2]);
		}
		
		System.out.println();
	}

	// 判断日期是否合法
	private static boolean isOk(int[] nyr, int year) {
		if (nyr[1] <= 12 && nyr[1] >= 1) {
			int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			// 闰年特殊处理
			if (nyr[1] == 2 
					&& (nyr[0] % 400 == 0 || (nyr[0] % 4 == 0 && nyr[0] % 100 != 0))) {
				days[2] = 29;
			}
			// 判断日期
			if (nyr[2] >= 1 && nyr[2] <= days[nyr[1]]) {
				return true;
			}
		}
		return false;
	}

	// 求出第i年a月的第b个星期c
	private static int[] getAns(int[] nyr, int b) {
		nyr[2] = nyr[2] + 7 * (b - 1);
		return nyr;
	}

	// 求出第i年a月的第一个星期c
	private static int[] getFirst(int year, int month, int zhou, int tar) {
		int c = tar - zhou;  // 相差几天 1 4 -> 3 相差3天；2 1 -> -1 相差6（7 + -1）天
		int days = 1;
		if (c >= 0) {
			days += c;
		} else {
			days += (7 + c);
		}
		return new int[] {year, month, days};
	}

	// 求出第i年a月1日是星期几，1表示周一
	private static int getZhou(int year, int month) {
		if (month == 1 || month == 2) {
			month += 12;
			year --;
		}
		// 基姆拉尔森星期计算公式
		int t = (1 + 2 * month + 3 * (month + 1) / 5 + year + year / 4
				- year / 100 + year / 400) % 7 + 1;
//		System.out.println(year + " " + month + " " + 1 + ": " + (t));
		return t;
	}

}
