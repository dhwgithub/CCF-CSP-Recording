import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class csp_2016_09_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		cin.nextToken();
		
		int n = (int) cin.nval;
		int[] num = new int[20];  // 表示某行有多少位置被占
				
		while (n -- > 0) {
			cin.nextToken();
			int i = (int) cin.nval;
			
			boolean find = true;  // 没有找到位置
			for (int j = 0; j < 20; j ++) {
				if (5 - num[j] >= i) {
					find = false;
					
					num[j] += 1;
					int key = j * 5 + num[j];
					System.out.print(key);
					
					for (int m = 0; m < i - 1; m ++) {
						num[j] += 1;
						System.out.print(" " + ++key);
					}
					
					break;
				}
			}
			
			if (find) {
				int t = 0;
				
				for (int j = 0; j < 20 && t < i; j ++) {
					while (num[j] < 5 && t < i) {
						num[j] ++;
						int key = j * 5 + num[j];
						
						if (t == 0) {
							System.out.print(key);
						} else {
							System.out.print(" " + key);
						}
						
						t ++;
					}
				}
			} 
			
			System.out.println();
		}
	}

}
