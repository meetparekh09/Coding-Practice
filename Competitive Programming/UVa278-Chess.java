import java.util.*;
import java.io.*;

class Main {
	public static void main(String []args) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(kin.readLine());
		while(t > 0) {
			String s = kin.readLine();
			if(s.equals("")) continue;
			String inputs[] = s.split("\\s");
			char ch = inputs[0].charAt(0);
			int m = Integer.parseInt(inputs[1]);
			int n = Integer.parseInt(inputs[2]);
			if(ch == 'r' || ch == 'Q') {
				if(m < n) System.out.println(m);
				else System.out.println(n);
			}
			if(ch == 'K') {
				int a, b;
				if(m%2 != 0) m++;
				if(n%2 != 0) n++;
				a = m/2;
				b = n/2;
				System.out.println(a*b);
			}
			if(ch == 'k') {
				int a = m*n;
				if((a%2) != 0) a++;
				System.out.println(a/2);
			}
			t--;
		}
	}
}