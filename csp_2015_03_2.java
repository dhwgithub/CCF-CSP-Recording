import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class csp_2015_03_2 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		
		in.nextToken();
		int n = (int) in.nval;
		
		Num[] nums = new Num[1005];
		int sum = 0;  // 记录num下标
		Map<Integer, Integer> map = new HashMap<>();  // 存储数字,下标
		
		for (int i = 0; i < n; i ++) {
			in.nextToken();
			int t = (int) in.nval;
			
			if (map.containsKey(t)) {
				nums[map.get(t)].sum ++;
			} else {
				map.put(t, sum);
				nums[sum] = new Num(t);
				sum ++;
			}
		}
		
		Comparator<Num> cmp = new Comparator<Num>() {
			@Override
			public int compare(Num n1, Num n2) {
				if (n1.sum == n2.sum) {
					return n1.num - n2.num;
				}
				else {
					return n2.sum - n1.sum;
				}
			}
		};
		Arrays.sort(nums, 0, sum, cmp);
		
		for (int i = 0; i < sum; i ++) {
			System.out.println(nums[i].num + " " + nums[i].sum);
		}
	}
	
	static class Num {
		int num;
		int sum;
		public Num(int num) {
			this.num = num;
			this.sum = 1;
		}
	}
}
