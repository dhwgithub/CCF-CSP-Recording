package csp;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class csp_2014_03_3 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		String name = cin.next();
		Set<Character> have = new HashSet<Character>();
		Set<Character> no_have = new HashSet<Character>();
		char[] na = name.toCharArray();
		for (int i=0; i<na.length; i++) {
			if (i+1 < na.length && na[i+1] == ':') {
				have.add(na[i]);
				i ++;
			} else {
				no_have.add(na[i]);
			}
		}
		
		int num = cin.nextInt();
		cin.nextLine();  // 减去多余的空行
		
		for (int i=1; i<=num; i++) {
			String s = cin.nextLine();
			String[] es = s.split(" ");
			
			StringBuffer str = new StringBuffer();
			Map<String, String> map = new TreeMap<String, String>();
			
			for (int j=1; j<es.length; j++) {
				char[] arr = es[j].toCharArray();
				if (arr[0] == '-' && arr.length == 2) {
					char c = arr[1];
					if (no_have.contains(c)) {
						map.put("-" + c, "");
					} else if (have.contains(c)) {
						j ++;
						if (j == es.length)
							break;
						map.put("-" + c, es[j]);
					} else {
						break;
					}
				} else {
					break;
				}
			}
			
			for (String k : map.keySet()) {
				if (map.get(k) == "") {
					str.append(k);
				}
				else {
					str.append(k + " " + map.get(k));
				}
				str.append(" ");
			}
			if (str.length() > 0)
				str.deleteCharAt(str.length()-1);
			
			System.out.println("Case " + i + ": " + str.toString());
		}
	}

}
