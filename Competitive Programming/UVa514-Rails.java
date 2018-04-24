import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			int n = Integer.parseInt(in.readLine());
			if(n == 0) break;
			int a[] = new int[n];
			while(true) {
				Stack<Integer> stk = new Stack<>();
				String inputs[] = in.readLine().split("\\s");
				if(inputs[0].equals("0")) break;
				for(int i = 0; i < n; i++) {
					a[i] = Integer.parseInt(inputs[i]);
				}
				int j = 0;
				for(int i = 1; i <= n; i++) {
					stk.push(i);
					while(j < n && !stk.empty() && a[j] == stk.peek()) {
						j++;
						stk.pop();
					}
				}
				if(stk.empty()) out.write("Yes\n");
				else out.write("No\n");
			}
			out.write("\n");
		}
		out.close();
	}
}