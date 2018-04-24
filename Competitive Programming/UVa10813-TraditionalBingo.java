import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine());
		while(t > 0) {
			HashMap<Integer, Boolean> rows[] = new HashMap[5];
			HashMap<Integer, Boolean> cols[] = new HashMap[5];
			HashMap<Integer, Boolean> diag1 = new HashMap<>();
			HashMap<Integer, Boolean> diag2 = new HashMap<>();
			for(int i = 0; i < 5; i++) {
				rows[i] = new HashMap<>();
				cols[i] = new HashMap<>();
			}
			for(int i = 0; i < 5;) {
				String input = in.readLine();
				while(input.equals("")) {
					input = in.readLine();
				}
				input = input.trim();
				String inputs[] = input.split("\\s+");
				if(i == 2) {
					for(int j = 0; j < 4; j++) {
						int num = Integer.parseInt(inputs[j]);
						rows[i].put(num, true);
						if(j < 2) {
							cols[j].put(num, true);
						} else {
							cols[j+1].put(num, true);
						}
					}
				} else {
					for(int j = 0; j < 5; j++) {
						int num = Integer.parseInt(inputs[j]);
						rows[i].put(num, true);
						cols[j].put(num, true);
						if(i == j) diag1.put(num, true);
						if(i == (4-j)) diag2.put(num, true);
					}
				}
				i++;
			}
			int ans = 0;
			int n = 0;
			while(true) {
				String input = in.readLine();
				while(input.equals("")) {
					input = in.readLine();
				}
				input = input.trim();
				String inputs[] = input.split("\\s+");
				boolean flag = true;
				for(int i = 0; i < inputs.length; i++) {
					n++;
					if(flag) {
						int num = Integer.parseInt(inputs[i]);
						for(int j = 0; j < 5 && flag; j++) {
							rows[j].remove(num);
							if(rows[j].isEmpty()) flag = false;
							cols[j].remove(num);
							if(cols[j].isEmpty()) flag = false;
						}
						diag1.remove(num);
						if(diag1.isEmpty()) flag = false;
						diag2.remove(num);
						if(diag2.isEmpty()) flag = false;
						if(!flag) ans = n;
					}
				}
				if(!flag) break;
			}
			out.write("BINGO after "+ans+" numbers announced\n");
			while(n < 75) {
				String inputs[] = in.readLine().trim().split("\\s+");
				for(String s: inputs) {
					n++;
				}
			}
			t--;
		}
		out.close();
	}
}