import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
/**
 * 方法：每次下降一格判断是否可以，直到下降到不能下降为止（最后一行是极限）
 * 注意：特殊的情况如方块为一条横线段且可以下降到最低位置
 * 
 * @author Administrator
 *
 */
public class csp_2016_04_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int[][] map = new int[15][10];
		int[][] block = new int[4][4];
		for (int i = 0; i < 15; i ++) {
			for (int j = 0; j < 10; j ++) {
				in.nextToken();
				map[i][j] = (int) in.nval;
			}
		}
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 4; j ++) {
				in.nextToken();
				block[i][j] = (int) in.nval;
			}
		}
		in.nextToken();
		int pos = (int) in.nval;
		pos --;  // 从0开始计数
		
		for (int i = 1; i < 15; i ++) {  // 最多下降14格
			if (!isDown(i, pos, map, block)) {
				printMap(i - 1, pos, map, block);
				break;
			}
			
			if (i == 14) {  // 当下降14格时需要直接输出结果，因为不可能会出现什么也没有的方块
				printMap(i, pos, map, block);
			}
		}
	}

	private static void printMap(int s, int pos, int[][] map, int[][] block) {
		// 修改map
		int t = s - 11 < 0 ? 0 : s - 11;  // 处理特殊情况
		int e1 = s + 3;
		int e2 = pos + 3;
		for (int i = s; i <= e1 - t; i ++) {
			for (int j = pos; j <= e2; j ++) {
				if (block[i - s][j - pos] == 1) {
					map[i][j] = 1;
				}
			}
		}
		
		// 输出
		for (int i = 0; i < 15; i ++) {
			System.out.print(map[i][0]);
			for (int j = 1; j < 10; j ++) {
				System.out.print(" " + map[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean isDown(int s, int pos, int[][] map, int[][] block) {
		int e1 = s + 3 > 14 ? 14 : s + 3;
		int e2 = pos + 3;
		for (int i = s; i <= e1; i ++) {
			for (int j = pos; j <= e2; j ++) {
				if (map[i][j] == 1 && block[i - s][j - pos] == 1) {
					return false;
				}
			}
		}
		if (s > 11) {  // 下降11步即4x4矩阵到达最底部，超过部分需要额外判断是否可以继续下降
			// 12 1 -> 3
			// 13 2 -> 2
			int t = s - 11;
			for (int i = 4 - t; i < 4; i ++) {
				for (int j = 0; j < 4; j ++) {
					if (block[i][j] == 1) {
						return false;
					}
				}
			}
		}
		return true;
	}
 
}
