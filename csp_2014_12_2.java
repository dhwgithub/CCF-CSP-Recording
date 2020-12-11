import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2014_12_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		
		int[][] num = new int[n][n];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				in.nextToken();
				num[i][j] = (int) in.nval;
			}
		}
		
		int[] pos = new int[2];
		System.out.print(num[0][0]);
		while (!(pos[0] == n - 1 && pos[1] == n - 1)) {
			// 右移 或 下移
			if (pos[1] + 1 == n) {
				down_one(pos);
			} 
			else {
				right_one(pos);
			}
			System.out.print(" " + num[pos[0]][pos[1]]);
						
			// 左下移动
			while (pos[0] + 1 < n && pos[1] - 1 >= 0) {
				left_one(pos);
				down_one(pos);
				System.out.print(" " + num[pos[0]][pos[1]]);
			}
			
			// 下移 或右移
			if (pos[0] + 1 == n) {
				right_one(pos);
			}
			else {
				down_one(pos);
			}
			System.out.print(" " + num[pos[0]][pos[1]]);
			
			// 右上移动
			while (pos[0] - 1 >= 0 && pos[1] + 1 < n) {
				right_one(pos);
				up_one(pos);
				System.out.print(" " + num[pos[0]][pos[1]]);
			}
		}
	}

	private static void up_one(int[] pos) {
		pos[0] --;
	}

	private static void right_one(int[] pos) {
		pos[1] ++;
	}

	private static void down_one(int[] pos) {
		pos[0] ++;
	}

	private static void left_one(int[] pos) {
		pos[1] --;
	}
}
