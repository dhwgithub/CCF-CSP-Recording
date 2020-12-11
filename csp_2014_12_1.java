import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class csp_2014_12_1 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		
		Map<Integer, Integer> map = new HashMap<>();
		in.nextToken();
		int t = (int) in.nval;
		map.put(t, map.getOrDefault(t, 0) + 1);
		System.out.print(1);
		for (int i = 1; i < n; i ++) {
			in.nextToken();
			t = (int) in.nval;
			map.put(t, map.getOrDefault(t, 0) + 1);
			System.out.print(" " + map.get(t));
		}
		System.out.println();
	}
}
