import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class csp_2020_12_1 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		
		int sum = 0;
		while(n > 0) {
			n --;
			int w = cin.nextInt();
			int s = cin.nextInt();
			sum +=  w * s;
		}
		
		if (sum < 0) 
			sum = 0;
		
		System.out.println(sum);
	}
}