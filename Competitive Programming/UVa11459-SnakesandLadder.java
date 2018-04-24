import java.util.*;
import java.io.*;

class Main {

	static int b[], p[];
	public static void main(String args[]) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(kin.readLine());
		while(t > 0) {
			String inputs[] = kin.readLine().split("\\s");
			int N = Integer.parseInt(inputs[0]);
			int n = Integer.parseInt(inputs[1]);
			int d = Integer.parseInt(inputs[2]);
			b = new int[101];
			Arrays.fill(b, -1);
			p = new int[N];
			Arrays.fill(p, 1);
			for(int i = 0; i < n; i++) {
				inputs = kin.readLine().split("\\s");
				int i1 = Integer.parseInt(inputs[0]);
				int i2 = Integer.parseInt(inputs[1]);
				b[i1] = i2;
			}
			int i = 0;
			for(;i < d; i++) {
				int player = i%N;
				int index = p[player];
				int roll = Integer.parseInt(kin.readLine());
				if(index < 100) {
					index += roll;
					if(index >= 100) {
						p[player] = 100;
					} 
					else if(b[index] == -1) {
						p[player] = index;
					} else {
						p[player] = b[index];
					}

					if(p[player] == 100) break;
				}
			}
			i++;
			for(; i < d; i++) {
				kin.readLine();
			}
			for(int j = 0; j < N; j++) {
				System.out.println("Position of player "+(j+1)+" is "+p[j]+".");
			}
			t--;
		}
	}
}