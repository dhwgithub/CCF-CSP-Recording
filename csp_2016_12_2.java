import java.util.Scanner;

/*
 * 参考：https://blog.csdn.net/richenyunqi/article/details/79642414
 * 
 * 1） 个人所得税起征点为3500元，若S不超过3500，则不交税，3500元以上的部分才计算个人所得税，令A=S-3500元；
　　2） A中不超过1500元的部分，税率3%；
　　3） A中超过1500元未超过4500元的部分，税率10%；
　　4） A中超过4500元未超过9000元的部分，税率20%；
　　5） A中超过9000元未超过35000元的部分，税率25%；
　　6） A中超过35000元未超过55000元的部分，税率30%；
　　7） A中超过55000元未超过80000元的部分，税率35%；
　　8） A中超过80000元的部分，税率45%；
 */
public class csp_2016_12_2 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int tax_last = cin.nextInt();
		
		// 各纳税区间上限，即小于等于该区间（税前）需要纳税计算的金额
		double[] tax_top = {0, 3500, 5000, 8000, 12500, 38500,
				58500, 83500, Integer.MAX_VALUE};
		// 税率
		double[] rate = {0.0, 0.0, 0.03, 0.1, 0.2, 0.25, 0.3,
				0.35, 0.45};
		// 各纳税节点税后工资
		double[] tax_after = new double[tax_top.length];
		for (int i = 1; i < tax_top.length; i ++) {
			tax_after[i] = tax_after[i - 1] + 
					(tax_top[i] - tax_top[i - 1]) * (1 - rate[i]);
		}
		
		// 查找指定税后工资所在区间
		int i = tax_top.length - 1;
		for ( ; i >= 0; i --) {
			if (tax_last > tax_after[i]) break;
		}
		i ++;

		double ans = tax_top[i - 1] + (tax_last - tax_after[i - 1]) / (1 - rate[i]);
		System.out.println((int) ans);
	}

}
