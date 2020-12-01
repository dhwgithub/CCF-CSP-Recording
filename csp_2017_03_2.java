import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;


public class csp_2017_03_2 {
	/*
	 * 对需要变换的区间进行覆盖变换，同时保存每个学号对应的下标
	 */

	public static void main(String[] args) throws IOException {
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		
		cin.nextToken();
		int n = (int) cin.nval;
		
		cin.nextToken();
		int m = (int) cin.nval;
		
		Map<Integer, Integer> map = new HashMap<>();  // num : index
		int[] nums = new int[n + 1];
		for (int i = 1; i <= n; i ++) {
			nums[i] = i;
			map.put(i, i);
		}
		
		while (m -- > 0) {
			cin.nextToken();
			int num = (int) cin.nval;
			cin.nextToken();
			int rel = (int) cin.nval;
			
			int cur_index = map.get(num);
			int i;
			int end;
			
			if (rel > 0) {
				i = cur_index + 1;
				end = cur_index + rel;
			} else {
				i = cur_index - 1;
				end = cur_index + rel;
			}
			
			for (; rel > 0 ? i <= end : i >= end; ) {
				if (rel > 0) {
					nums[i - 1] = nums[i];
					map.put(nums[i], i - 1);
					i ++;
				}
				else {
					nums[i + 1] = nums[i];
					map.put(nums[i], i + 1);
					i --;
				}
			}
			
			nums[end] = num;
			map.put(num, end);
		}
		
		// 输出
		System.out.print(nums[1]);
		for (int j = 2; j <= n; j ++) {
			System.out.print(" " + nums[j]);
		}
		System.out.println();
	}
}
