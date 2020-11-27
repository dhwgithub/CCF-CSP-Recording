import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;


public class csp_2016_12_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		cin.nextToken();
		
		int n = (int) cin.nval;
		
		int[] num = new int[n];
		for (int i = 0; i < n; i ++) {
			cin.nextToken();
			num[i] = (int) cin.nval;
		}
		
		Arrays.sort(num);
		
		boolean find = false;
		
		for (int i = 0; i < n; i ++) {
			int start_index = i;  // 等于该数的最前下标
			int end_index = i;  // 等于该数的最后下标
			
			while (start_index - 1 >= 0 && num[i] == num[start_index - 1]) {
				start_index --;
			}
			while (end_index + 1 < n && num[i] == num[end_index + 1]) {
				end_index ++;
			}
			
			if (start_index == n - end_index - 1) {
				find = true;
				System.out.println(num[i]);
			}
			
			i = end_index;  // 跳过当前数
		}
		
		if (! find) {
			System.out.println(-1);
		}
	}

}
