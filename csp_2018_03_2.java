import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class csp_2018_03_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int L = (int) in.nval;
		in.nextToken();
		int t = (int) in.nval;
		
		int[] num = new int[L + 1];  // 指示该位置有几个小球
		Ball[] balls = new Ball[n];
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			int p = (int) in.nval;
			balls[i] = new Ball(p, true);
			if (p == L) {
				balls[i].isRight = false;
			}
			num[p] ++;
		}
		
		while (t -- > 0) {
			// 同时移动（忽略其他球的存在）
			for (int i = 0; i < n; i ++) {
				// 下一步移动到的位置
				int nextPos = balls[i].isRight ? 1 : -1;
				nextPos = balls[i].pos + nextPos; 
				
				// 进行移动
				num[balls[i].pos] --;
				num[nextPos] ++;
				balls[i].pos = nextPos;
			}
			
			// 判断是否碰撞以及纠正方向
			for (int i = 0; i < n; i ++) {
				int pos = balls[i].pos;
				
				// 发生碰撞
				if (num[pos] > 1) {
					balls[i].isRight = ! balls[i].isRight;
				}
				
				// 到端点处
				if (pos == 0 || pos == L) {
					balls[i].isRight = ! balls[i].isRight;
				}
			}
			
//			// 查看每秒过程
//			System.out.print(balls[0].pos);
//			for (int i = 1; i < n; i ++) {
//				System.out.print(" " + balls[i].pos);
//			}
//			System.out.println();
		}
		
		System.out.print(balls[0].pos);
		for (int i = 1; i < n; i ++) {
			System.out.print(" " + balls[i].pos);
		}
		System.out.println();
	}
	
	static class Ball{
		int pos;
		boolean isRight;
		public Ball(int pos, boolean isRight) {
			this.pos = pos;
			this.isRight = isRight;
		}
	}

}
