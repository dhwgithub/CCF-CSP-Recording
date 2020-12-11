import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class csp_2017_09_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int k = (int) in.nval;
		
		// 存放钥匙初始化
		int[] num = new int[n];  
		for (int i = 0; i < n; i ++) {
			num[i] = i + 1;
		}
		
		// 时间序列，放钥匙用负数，用钥匙用正数
		ArrayList<Integer>[] keyOp = new ArrayList[10101];
		for (int i = 0; i <= 10100; i ++) {
			keyOp[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < k; i ++) {
			in.nextToken();
			int key = (int) in.nval;
			in.nextToken();
			int s = (int) in.nval;
			in.nextToken();
			int t = (int) in.nval;
			
			keyOp[s].add(key);
			keyOp[s + t].add(-key);
		}
		
		for (int i = 1; i < 10101; i ++) {
			if (keyOp[i].size() == 0) {
				continue;
			}
			// 排序
			keyOp[i].sort((k1, k2) -> k1 - k2);
			// 找到正数的第一个位置
			int t = 0;
			while (t < keyOp[i].size() && keyOp[i].get(t) < 0) {
				t ++;
			}
			
			// 负数，放钥匙
			for (int j = t - 1; j >= 0; j --) {
				int key = keyOp[i].get(j);  // 钥匙
				for (int z = 0; z < n; z ++) {
					if (num[z] == -1) {
						num[z] = -key;
						break;
					}
				}
			}
			// 正数，取钥匙
			for (int j = t; j < keyOp[i].size(); j ++) {
				int key = keyOp[i].get(j);  // 钥匙
				for (int z = 0; z < n; z ++) {
					if (num[z] == key) {
						num[z] = -1;
						break;
					}
				}
			}
			
//			// 显示中间过程
//			for (int temp : num) {
//				System.out.print(temp + " ");
//			}
//			System.out.println();
		}
		
		System.out.print(num[0]);
		for (int i = 1; i < n; i ++) {
			System.out.print(" " + num[i]);
		}
		System.out.println();
	}
}
