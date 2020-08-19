package csp;

import java.util.Scanner;

/**
 * 根据题意，组合只能以2开头，如下共6种情况（只包含关系）：
 * 0 -> 2
 * 1 -> 2 0
 * 		x -> 2 1 // 不能在后续组合中包含0，排除
 * 2 -> 2 3
 * 3 -> 2 0 1
 * 4 -> 2 0 3
 * 5 -> 2 0 1 3
 * 
 * 根据以上关系，可分析转化关系（前者是转换目标状态，较后者位数大一）：
 * 	状态0 <-  状态0（等于1）
 * 	状态1 <- 状态0（+2） 状态1（+0/2）
 * 	状态2 <- 状态0（+3） 状态2（+3） // 不能由状态2（+2）转换得到，因为2必须在3前面，状态2已存在3
 * 	状态3 <- 状态1（+1） 状态3（+2/1）  // 不能由状态0转换得到，因为当前状态位数比上一个状态恰好大1
 * 	状态4 <- 状态1（+3） 状态2（+0） 状态4（+0/3）
 * 	状态5 <- 状态3（+3） 状态4（+1） 状态5（+1/3）
 * 
 * 以上只要有多个+则需要乘以对应的倍数，设置数组 f[N][6] 表示N位时的6种状态，递推得到最终的解
 * 参考题解：https://blog.csdn.net/Sm_77/article/details/104608084?utm_medium=distribute.pc_relevant.none-task-blog-baidulandingword-3&spm=1001.2101.3001.4242
 *
 */
public class csp_2013_12_4 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		
		int MOD = 1000000007;
		
		long[][] f = new long[n+5][6];
		for (int i = 1; i <= n; i ++) {
			f[i][0] = 1;
			f[i][1] = (f[i-1][0] + f[i-1][1] * 2) % MOD;
			f[i][2] = (f[i-1][0] + f[i-1][2]) % MOD;
			f[i][3] = (f[i-1][1] + f[i-1][3] * 2) % MOD;
			f[i][4] = (f[i-1][1] + f[i-1][2] + f[i-1][4] * 2) % MOD;
			f[i][5] = (f[i-1][3] + f[i-1][4] + f[i-1][5] * 2) % MOD; 
		}
		
		System.out.println(f[n][5]);
	}

}
