import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class csp_2018_12_2 {

	public static int[] wait = new int[4];  // 记录灯的时长
	
	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int r = (int) in.nval;
		in.nextToken();
		int y = (int) in.nval;
		in.nextToken();
		int g = (int) in.nval;
		wait[1] = r;
		wait[2] = y;
		wait[3] = g;
		
		long time = 0;
		
		in.nextToken();
		int n = (int) in.nval;
		while (n-- > 0) {
			in.nextToken();
			int k = (int) in.nval;
			in.nextToken();
			int t = (int) in.nval;
			
			if (k == 0) time += t;
			else {
				int[] now = getRYG(time, k, t);
				if (now[0] == 1) time += now[1];
				else if (now[0] == 2) time += wait[1] + now[1];
			}
		}
		
		System.out.println(time);
	}
	
	// 过了 time 时间后，L是什么灯，即到达该路口是什么灯以及剩余时间
	public static int[] getRYG(long time, int L, int st) {
		if (time <= st) 
			return new int[] {L, (int) (st - time)};
		
		L = getNextL(L);
		time -= st;
		
		time = time % (wait[1] + wait[2] + wait[3]);
		
		while (time > 0) {
			time -= wait[L];
			if (time > 0) L = getNextL(L);
		}
		return new int[] {L, (int) Math.abs(time)};
	}
	
	// 获取下一个红绿灯状态
	public static int getNextL(int L) {
		if (L == 1) return 3;  // r - g
		else if (L == 2) return 1;  // y - r
		else if (L == 3) return 2;  // g - y
		else return 0;
	}

}
