import java.io.*;
import java.util.*;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int val = (int)'`';
		while(true) {
			String s = reader.readLine();
			if(s == null) break;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '"') {
					System.out.print(""+(char)val+(char)val);
					if(val == (int)'`') val = (int)'\'';
					else val = (int) '`';
				} else {
				    System.out.print(s.charAt(i));
				}
			}
			System.out.print("\n");
		}
	}	
}