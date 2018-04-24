import java.util.*;
import java.io.*;

class Main {
	public static void main(String []args) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(kin.readLine());
		while(t > 0) {
			int n = Integer.parseInt(kin.readLine());
			int points[] = new int[n];
			int type[][] = new int[n][6];
			int max = 0, maxInd = -1;
			boolean tie = false;
			for(int i = 0; i < n; i++) {
				String inputs[] = kin.readLine().split("\\s");
				points[i] = Integer.parseInt(inputs[0]);
				int tc = 0;
				for(int j = 1; j <= points[i]; j++) {
					int ty = Integer.parseInt(inputs[j]);
					if(type[i][ty-1] == 0) {
						tc++;
					}
					type[i][ty-1]++;
				}
				while(tc == 6) {
					points[i] += 4;
					tc = 0;
					for(int k = 0; k < 6; k++) {
						type[i][k]--;
						if(type[i][k] > 0) tc++;
					}
				}
				while(tc == 5) {
					points[i] += 2;
					tc = 0;
					for(int k = 0; k < 6; k++) {
						if(type[i][k] > 0) type[i][k]--;
						if(type[i][k] > 0) tc++;
					}
				}
				while(tc == 4) {
					points[i] += 1;
					tc = 0;
					for(int k = 0; k < 6; k++) {
						if(type[i][k] > 0) type[i][k]--;
						if(type[i][k] > 0) tc++;
					}
				}
				if(max < points[i]) {
					tie = false;
					max = points[i];
					maxInd = i;
				} else if(max == points[i]) {
					tie = true;
				}
			}
			if(tie) {
				System.out.println("tie");
			} else if(maxInd == 0) {
				System.out.println("chef");
			} else {
				System.out.println(maxInd+1);
			}
			t--;
		}
	}
}