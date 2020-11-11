import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 不用让坐标进行加法操作，否则会越界
 *
 */
public class csp_2019_12_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		
		int[][] pos = new int[n][2];
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			pos[i][0] = (int) in.nval;
			in.nextToken();
			pos[i][1] = (int) in.nval;
		}
		
		int[] score = new int[5];
		for (int i = 0; i < n; i ++) {
			int curr = 0;
			int sum = 0;
			for (int j = 0; j < n; j ++) {
				if (subAbs(i, j, pos) == 1) curr ++;
				if (Math.abs(pos[i][0] - pos[j][0]) == 1 && Math.abs(pos[i][1] - pos[j][1]) == 1) sum ++;
			}
			if (curr == 4) score[sum] ++;
		}
		
		for (int i : score) {
			System.out.println(i);
		}
	}

	private static int subAbs(int i, int j, int[][] pos) {
		return Math.abs(pos[i][0] - pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]);
	}


}
/*
11
9 10
10 10
11 10
12 10
13 10
11 9
11 8
12 9
10 9
10 11
12 11
*/
