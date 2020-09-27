import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2014_12_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				in.nextToken();
				map[i][j] = (int) in.nval;
			}
		}
		
		int i = 0;
		int j = 0;
		int[] ij = new int[2];
		System.out.print(map[i][j]);
		while (true) {
			/**
			 * 右移一位
			 */
			if (j + 1 < n) {
				ij = toRight(i, j, map);
				i = ij[0];
				j = ij[1];
			} else {
				if (i + 1 < n) {
					ij = toDown(i, j, map);
					i = ij[0];
					j = ij[1];
				} else {
					break;
				}
			}
			/**
			 * 左下方移动，直到边界
			 */
			while (i + 1 < n && j - 1 >= 0) {
				ij = toLeftDown(i, j, map);
				i = ij[0];
				j = ij[1];
			} 
			/**
			 * 下移一位
			 */
			if (i + 1 < n) {
				ij = toDown(i, j, map);
				i = ij[0];
				j = ij[1];
			} else {
				if (j + 1 < n) {
					ij = toRight(i, j, map);
					i = ij[0];
					j = ij[1];
				} else {
					break;
				}
			}
			/**
			 * 右上方移动，直到边界
			 */
			while (i - 1 >= 0 && j + 1 < n) {
				ij = toRightUp(i, j, map);
				i = ij[0];
				j = ij[1];
			}
		}
		System.out.println();
	}
	
	private static int[] toRight(int i, int j, int[][] map) {
		System.out.print(" " + map[i][j + 1]);
		return new int[] {i, j + 1};
	}
	
	private static int[] toLeftDown(int i, int j, int[][] map) {
		System.out.print(" " + map[i + 1][j - 1]);
		return new int[] {i + 1, j - 1};
	}
	
	private static int[] toDown(int i, int j, int[][] map) {
		System.out.print(" " + map[i + 1][j]);
		return new int[] {i + 1, j};
	}
	
	private static int[] toRightUp(int i, int j, int[][] map) {
		System.out.print(" " + map[i - 1][j + 1]);
		return new int[] {i - 1, j + 1};
	}

}
