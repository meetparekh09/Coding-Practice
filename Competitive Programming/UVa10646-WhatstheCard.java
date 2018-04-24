import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(kin.readLine());
		int c = 1;
		while(t > 0) {
			ArrayList<String> al = new ArrayList<>();
			String inputs[] = kin.readLine().split("\\s");
			for(String str: inputs) {
				al.add(str);
			}
			int index = 26;
			int y = 0;
			for(int i = 0; i < 3; i++) {
				String str = al.get(index);
				int x = getValue(str.charAt(0));
				y += x;
				al.remove(index--);
				for(int j = 0; j < 10-x; j++) {
					al.remove(index--);
				}
			}
			System.out.println("Case "+(c++)+": "+al.get(y-1));
			t--;
		}
	}

	static int getValue(char a) {
		if(a == 'T' || a == 'J' || a == 'A' || a == 'K' || a == 'Q') return 10;
		return Integer.parseInt(""+a);
	}
}