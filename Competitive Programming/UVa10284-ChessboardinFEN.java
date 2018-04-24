import java.util.*;
import java.io.*;

class Main {

	static boolean open[][], occupied[][];
	static int board[][];
	public static void main(String []args) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = kin.readLine();
			if(s == null) break;
			String inputs[] = s.split("/");
			open = new boolean[8][8];
			occupied = new boolean[8][8];
			board = new int[8][8];
			for(int i = 0; i < 8; i++) {
				Arrays.fill(open[i], true);
				Arrays.fill(occupied[i], true);
			}
			int row = 0;
			for(String str: inputs) {
				int col = 0;
				for(int i = 0; i < str.length(); i++) {
					if(str.charAt(i) >= '1' && str.charAt(i) <= '8') {
						int j = Integer.parseInt(str.substring(i, i+1));
						while(j > 0) {
							board[row][col] = col;
							col++;
							j--;
						}
					} else {
						if(str.charAt(i) == 'p' || str.charAt(i) == 'P') {
							if(str.charAt(i) == 'p') board[row][col] = 8;
							else board[row][col] = 14;
						} else if(str.charAt(i) == 'b' || str.charAt(i) == 'B') {
							board[row][col] = 9;
						} else if(str.charAt(i) == 'n' || str.charAt(i) == 'N') {
							board[row][col] = 10;
						} else if(str.charAt(i) == 'r' || str.charAt(i) == 'R') {
							board[row][col] = 11;
						} else if(str.charAt(i) == 'k' || str.charAt(i) == 'K') {
							board[row][col] = 12;
						} else if(str.charAt(i) == 'q' || str.charAt(i) == 'Q') {
							board[row][col] = 13;
						}
						open[row][col] = false;
						occupied[row][col] = false;
						col++;
					}
				}
				row++;
			}
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					if(board[i][j] == 8) {
						pawn(i, j, true);
					} else if(board[i][j] == 14) {
						pawn(i, j, false);
					} else if(board[i][j] == 9) {
						bishop(i, j);
					} else if(board[i][j] == 10) {
						knight(i, j);
					} else if(board[i][j] == 11) {
						rook(i, j);
					} else if(board[i][j] == 12) {
						king(i, j);
					} else if(board[i][j] == 13) {
						queen(i, j);
					}
				}
			}
			int count = 0;
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					if(open[i][j]) count++;
				}
			}
			System.out.println(count);
		}
	}

	static void pawn(int i, int j, boolean isBlack) {
		if(isBlack) {
			if(i+1 < 8 && j - 1 >= 0) open[i+1][j-1] = false;
			if(i+1 < 8 && j + 1 < 8) open[i+1][j+1] = false;
		} else {
			if(i-1 >= 0 && j - 1 >= 0) open[i-1][j-1] = false;
			if(i-1 >= 0 && j + 1 < 8) open[i-1][j+1] = false;
		}
	}

	static void bishop(int i, int j) {
		int a = i+1;
		int b = j+1;
		while(a < 8 && b < 8 && occupied[a][b]) {
			open[a++][b++] = false;
		}
		a = i+1;
		b = j-1;
		while(a < 8 && b >= 0 && occupied[a][b]) {
			open[a++][b--] = false;
		}
		a = i-1;
		b = j-1;
		while(a >= 0 && b >= 0 && occupied[a][b]) {
			open[a--][b--] = false;
		}
		a = i-1;
		b = j+1;
		while(a >= 0 && b < 8 && occupied[a][b]) {
			open[a--][b++] = false;
		}
	}

	static void rook(int i, int j) {
		int a = i+1;
		int b = j;
		while(a < 8 && occupied[a][b]) {
			open[a++][b] = false;
		}
		a = i-1;
		b = j;
		while(a >= 0 && occupied[a][b]) {
			open[a--][b] = false;
		}
		a = i;
		b = j+1;
		while(b < 8 && occupied[a][b]) {
			open[a][b++] = false;
		}
		a = i;
		b = j-1;
		while(b >= 0 && occupied[a][b]) {
			open[a][b--] = false;
		}
	}

	static void queen(int i, int j) {
		bishop(i, j);
		rook(i, j);
	}

	static void king(int r, int c) {
		for(int i = 0; i < 3; i++) {
			int a = r - 1 + i;
			for(int j = 0; j < 3; j++) {
				int b = c - 1 + j;
				if(a >= 0 && b >= 0 && a < 8 && b < 8) {
					open[a][b] = false;
				}
			}
		}
	}

	static void knight(int i, int j) {
		if(i-2 >= 0 && j-1 >= 0) open[i-2][j-1] = false;
		if(i-2 >= 0 && j+1 < 8) open[i-2][j+1] = false;
		if(i-1 >= 0 && j-2 >= 0) open[i-1][j-2] = false;
		if(i-1 >= 0 && j+2 < 8) open[i-1][j+2] = false;
		if(i+1 < 8 && j-2 >= 0) open[i+1][j-2] = false;
		if(i+1 < 8 && j+2 < 8) open[i+1][j+2] = false;
		if(i+2 < 8 && j-1 >= 0) open[i+2][j-1] = false;
		if(i+2 < 8 && j+1 < 8) open[i+2][j+1] = false;
	}

	static void printboard(int [][]a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

	static void printopen(boolean [][]a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}