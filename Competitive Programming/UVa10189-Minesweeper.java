import java.util.*;
import java.io.*;

class Main {

	static int field[][], n, m;
	public static void main(String args[]) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int c = 1;
		while(true) {
			String in = kin.readLine();
			if(in.equals("")) continue;
			String inputs[] = in.split("\\s");
			n = Integer.parseInt(inputs[0]);
			m = Integer.parseInt(inputs[1]);
			if(n == 0) break;
			if(c != 1) System.out.println();
			field = new int[n][m];
			for(int i = 0; i < n; i++) {
				String str = kin.readLine();
				for(int j = 0; j < m; j++) {
					if(str.charAt(j) == '*') field[i][j] = -1;
					else field[i][j] = 0;
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(field[i][j] == -1) mine(i, j);
				}
			}
			System.out.println("Field #"+(c++)+":");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(field[i][j] == -1) System.out.print("*");
					else System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}
	}

	static void mine(int r, int c) {
		for(int i = 0; i < 3; i++) {
			int row = r - 1 + i;
			for(int j = 0; j < 3; j++) {
				int col = c - 1 + j;
				if(row >= 0 && col >= 0 && row < n && col < m && field[row][col] != -1) {
					field[row][col]++;
				}
			}
		}
	}
}