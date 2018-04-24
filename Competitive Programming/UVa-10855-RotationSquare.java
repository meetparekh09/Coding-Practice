import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int N, n;
			String inputs[] = kin.readLine().split("\\s");
			N = Integer.parseInt(inputs[0]);
			n = Integer.parseInt(inputs[1]);
			if(N == 0 && n == 0) break;
			String large[] = new String[N];
			String small[] = new String[n];
			for(int i = 0; i < N; i++) {
				large[i] = kin.readLine();
			}
			for(int i = 0; i < n; i++) {
				small[i] = kin.readLine();
			}
			for(int k = 0; k < 4; k++) {
				if(k != 0) small = rotate(small);
				int count = 0;
				for(int i = 0; i < N-n+1; i++) {
					boolean flag = true;
					int ind = -1;
					while(flag) {
						ind = large[i].indexOf(small[0], ind+1);
						if(ind != -1) {
							int j = 1;
							boolean inc = true;
							while(j < n) {
								if(ind == large[i+j].indexOf(small[j], ind)) {
									j++;
								} else {
									inc = false;
									break;
								}
							}
							if(inc) count++;
						} else {
							flag = false;
						}
					}
				}
				if(k != 3) System.out.print(count+" ");
				else System.out.print(count);
			}
			System.out.println();
		}
	}

	static String[] rotate(String arr[]) {
		String temp[] = new String[arr.length];
		for(int i = 0; i < temp.length; i++) {
			temp[i] = new String();
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = arr.length - 1; j >= 0; j--) {
				temp[i] += arr[j].charAt(i);
			}
		}
		return temp;
	}
}