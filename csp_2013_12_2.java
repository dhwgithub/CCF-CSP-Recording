package csp;

import java.util.Scanner;

public class csp_2013_12_2 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String s = cin.next();
		int ans = 0;
		char[] arr = s.toCharArray();
		int len = arr.length;
		for (int i=0, j=1; i<=10; i++, j++) {
			if (i == 1 || i == 5) {
				j --;
				continue;
			}
			ans = ans + (arr[i] - '0') * j;
		}
		ans %= 11;
		char c = ans == 10 ? 'X' : (char)(ans + '0');
		if (c != arr[len-1]) {
			for (int i=0; i<len-1; i++) {
				System.out.print(arr[i]);
			}
			System.out.println(c);
		} else {
			System.out.println("Right");
		}
	}

}
