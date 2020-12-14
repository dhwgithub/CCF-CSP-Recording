import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class csp_2020_12_2 {

	/*
	 * 由于数值范围较大，直接求解会超时
	 * 因此需要简化求预测正确结果的计算过程，降低时间复杂度
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();

		// 记录每个y值包含所有0/1的个数
		Map<Integer, int[]> map = new HashMap<>();
		int sumNum = 0;  // 不同y值的个数
		for (int i = 0; i < n; i ++) {
			int a = cin.nextInt();
			int b = cin.nextInt();
			if (map.containsKey(a)) {
				int[] t = map.get(a);
				t[b] ++;
				map.put(a, t);
			} else {
				sumNum ++;
				int[] t = new int[2];
				t[b] ++;
				map.put(a, t);
			}
		}

		// 记录所有的y值并按升序排列
		int[] num = new int[sumNum];  
		int s = 0;
		for (int key : map.keySet()) {
			num[s ++] = key;
		}
		Arrays.sort(num);
		
		// 记录当前<= y值的0/1前缀和
		// 目的是简化计算预测结果，降低时间复杂度
		int[] add0 = new int[sumNum];  
		int[] add1 = new int[sumNum];  // <=i 
		add0[0] = map.get(num[0])[0];
		add1[0] = map.get(num[0])[1];
		for (int i = 1; i < sumNum; i ++) {
			int key = num[i];
			int[] n01 = map.get(key);  
			add0[i] = add0[i - 1] + n01[0];
			add1[i] = add1[i - 1] + n01[1];
		}
		
		int sum = add1[sumNum - 1];  // 最大正确预测
		int id = num[0];  // 最佳阈值
		for (int i = 1; i < sumNum; i ++) {
			// 针对每个 y 值进行计算，此时把y当做θ值（key=θ）
			int key = num[i];
			int ok = 0;

			// 只有当小于当前y且结果为0时 和
			// 大于等于当前y且结果为1时 表示预测正确
			ok += add0[i - 1];
			ok += (add1[sumNum - 1] - add1[i - 1]);
	
			// 更新最优解
			if (ok >= sum) {
				sum = ok;
				id = key;
			}
		}
		
		System.out.println(id);
	}
}