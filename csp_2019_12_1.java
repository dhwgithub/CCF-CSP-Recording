import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class csp_2019_12_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		int[] p = new int[4];
		
		int id = -1;
		int num = 0;
		int sum = 0;
		while (sum < n) {
			num ++;
			id ++;
			id %= 4;
			if (num % 7 == 0 || checkHave7(num)) {
				p[id] ++;
				continue;
			}
			sum ++;
		}
		
		for (int i = 0; i < 4; i ++) {
			System.out.println(p[i]);
		}
	}

	private static boolean checkHave7(int num) {
		while (num != 0) {
			if (num % 10 == 7) {
				return true;
			}
			num /= 10;
		}
		return false;
	}

}
