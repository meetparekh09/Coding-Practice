import java.util.*;
import java.io.*;

class Main {

	static int r, c, n; 
	static char grid[][], temp[][];
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
		while(t > 0) {
			String inputs[] = in.readLine().split("\\s");
			r = Integer.parseInt(inputs[0]);
			c = Integer.parseInt(inputs[1]);
			n = Integer.parseInt(inputs[2]);
			if(r > 0 && c > 0) {
				grid = new char[r][c];
				for(int i = 0; i < r; i++) {
					grid[i] = in.readLine().trim().toCharArray();
				}
				initTemp();
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < r; j++) {
						for(int k = 0; k < c; k++) {
							char pass;
							if(grid[j][k] == 'R') pass = 'S';
							else if(grid[j][k] == 'S') pass = 'P';
							else pass = 'R';
							manip(j, k, grid[j][k], pass);
							if(temp[j][k] == '*') temp[j][k] = grid[j][k];
						}
					}
					grid = temp;
					initTemp();
				}
				for(int i = 0; i < r; i++) {
					for(int j = 0; j < c; j++) {
						out.write(grid[i][j]);
					}
					out.write("\n");
				}
			} else {
				in.readLine();
			}
			if(t != 1) out.write("\n");
			t--;
		}
		out.close();
	}

	static void initTemp() {
		temp = new char[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				temp[i][j] = '*';
			}
		}
	}

	static void manip(int row, int col, char a, char b) {
		if(row - 1 >= 0 && grid[row-1][col] == b) {
			temp[row-1][col] = a;
		}
		if(col - 1 >= 0 && grid[row][col-1] == b) {
			temp[row][col-1] = a;
		}
		if(row + 1 < r && grid[row+1][col] == b) {
			temp[row+1][col] = a;
		}
		if(col + 1 < c && grid[row][col+1] == b) {
			temp[row][col+1] = a;
		}
	}
}