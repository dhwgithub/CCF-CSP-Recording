import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/*
 * 双指针
 * 
 * 重合情况：
 * 		求交集
 * 		然后判断哪个区间不再被使用
 * 非重合情况：
 * 		判断哪个区间不再被使用
 */
public class csp_2018_09_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		
		int[][] a = new int[n][2];
		int[][] b = new int[n][2];
				
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			a[i][0] = (int) in.nval;
			in.nextToken();
			a[i][1] = (int) in.nval;
		}
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			b[i][0] = (int) in.nval;
			in.nextToken();
			b[i][1] = (int) in.nval;
		}
		
//		Arrays.sort(a, (a1, a2) -> a1[0] - a2[0]);
//		Arrays.sort(b, (b1, b2) -> b1[0] - b2[0]);
		
		int i = 0;
		int j = 0;
		long sum = 0;
		
		while (i < n && j < n) {
			// a0 b0 a1 b1 : 重合时
			if (a[i][0] < b[j][1] && a[i][1] > b[j][0]) {
				sum += Math.min(a[i][1], b[j][1]) - Math.max(a[i][0], b[j][0]);
				
				// a[i][1] 不可能再与 b 中区间重合了
				if (a[i][1] < b[j][1]) {
					i ++;
				} 
				else if (a[i][1] > b[j][1]) {
					j ++;
				}
				else {
					i ++;
					j ++;
				}
			}
			else if (a[i][1] <= b[j][0]) {
				i ++;
			}
			else if (a[i][0] >= b[j][1]) {
				j ++;
			}
		}
		
		System.out.println(sum);
	}

}
