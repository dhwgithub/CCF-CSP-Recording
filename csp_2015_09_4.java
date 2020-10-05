import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
	方法：本质是求强连通分量，可以使用tarjan算法求出每一个强连通分量，之后再计算“便利城市对”

	tarjan算法：遍历每一个没有遍历过的节点，设置dfn和low数组分别记录遍历的时间点和最近父节点。
			之后遍历它能够到达的节点，并更新low数组；或当到达节点在栈中时直接更新low数组
			最后，若当前点low和dfn一样，表示没有其他点与其是强联通分量了，接着找出之前的所有强联通分量点
 *
 */
public class csp_2015_09_4 {
	
	static int ans = 0;
	static int time = 1;
	
	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int m = (int) in.nval;
		
		List<Integer>[] map = new ArrayList[n + 5];
		for (int i = 0; i <= n; i ++) {
			map[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i ++) {
			in.nextToken();
			int u = (int) in.nval;
			in.nextToken();
			int v = (int) in.nval;
			
			map[u].add(v);
		}
		
		tarjan(map, n);
		
		System.out.println(ans);
	}
	
	private static void tarjan(List<Integer>[] map, int n) {
		int[] dfn = new int[n + 5];  // 记录遍历的时间点
		int[] low = new int[n + 5];  // 记录最近可返回的父节点
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 1; i <= n; i ++) {
			if (dfn[i] == 0) { // 没有被遍历时
				tarjanDfs(i, dfn, low, n, stack, map);
			}
		}
	}

	private static void tarjanDfs(int x, int[] dfn, int[] low, int n,
								Stack<Integer> stack, List<Integer>[] map) {
		dfn[x] = low[x] = time ++;
		stack.push(x);
		
		int num = map[x].size();
		for (int i = 0; i < num; i ++) {  // 遍历x可达的所有节点
			int y = map[x].get(i);
			if (dfn[y] == 0) {  // 没有被遍历时
				tarjanDfs(y, dfn, low, n, stack, map);
				low[x] = Math.min(low[x], low[y]);
			} else if (stack.contains(y)) {  // 当y在栈中时
				low[x] = Math.min(low[x], dfn[y]);
			}
		}
		
		if (dfn[x] == low[x]) {  // 若一样，表示自己本身就是一个强连通分量（可能包含其他节点一起）
			int k;
			int sum = 0;
			do {
				k = stack.pop();
				sum ++;
			} while (k != x);  // 找到跟x同一个强连通分量
			
			ans += (sum * (sum - 1) / 2);
		}
	}

}