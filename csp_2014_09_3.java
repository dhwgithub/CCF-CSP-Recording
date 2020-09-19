package csp;

import java.util.Scanner;

public class csp_2014_09_3 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String str = cin.next();
		int num = cin.nextInt();
		int n = cin.nextInt();
		if (num == 0) {
			str = str.toLowerCase();
		}
		int m = str.length();
		int[] next = getNext(str, m);
		
		while (n-- > 0) {
			String t = cin.next();
			String temp = t;
			if (num == 0) {
				t = t.toLowerCase();
			}
//			if (t.contains(str)) {
//				System.out.println(temp);
//			}
			if (isOk(t, str, m, next)) {
				System.out.println(temp);
			} 
		}
	}
	
	private static boolean isOk(String s, String t, int m, int[] next) {
		int n = s.length();
		if (m > n) {
			return false;
		}
		
		int i = 0;
		int j = 0;
		while (i < n) {
			while (j != -1 && s.charAt(i) != t.charAt(j)) {
				j = next[j];
			}
			i ++;
			j ++;
			if (j == m) {
				return true;
			}
		}
		return false;
	}

	private static int[] getNext(String t, int m) {
		int i = 0;
		int j = -1;
		int[] next = new int[m + 1];
		next[0] = -1;
		while (i < m) {
			while (j != -1 && t.charAt(i) != t.charAt(j)) {
				j = next[j];
			}
			next[++i] = ++j;
		}
		return next;
	}

}
