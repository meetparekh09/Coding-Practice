import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String inputs[] = kin.readLine().split("\\s");
			int m = Integer.parseInt(inputs[0]);
			int n = Integer.parseInt(inputs[1]);
			String output = " knights may be placed on a "+m+" row "+n+" column board.";
			if(m == 0 && n == 0) break;
			else if(m == 0 || n == 0) {
				System.out.println(0+output);
			}
			else if(m == 1 || n == 1) {
				if(m == 1) System.out.println(n+output);
				else System.out.println(m+output);
			}
			else if(m == 2 || n == 2) {
				if(m == 2) {
					if(n%2 == 0) {
						int a = n/2;
						if(a%2 != 0) a++;
						a/=2;
						a*=4;
						System.out.println(a+output);
					} else {
						float a = n+1;
						a/=2;
						a/=2;
						a*=4;
						System.out.println(((int)a)+output);
					}
				} else {
					if(m%2 == 0) {
						int a = m/2;
						if(a%2 != 0) a++;
						a/=2;
						a*=4;
						System.out.println(a+output);
					} else {
						float a = m+1;
						a/=2;
						a/=2;
						a*=4;
						System.out.println(((int)a)+output);
					}
				}
			} else {
				int a = m*n;
				if(a%2 != 0) a++;
				System.out.println((a/2)+output);
			}
		}
	}
}