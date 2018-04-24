import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int c = Integer.parseInt(kin.readLine());
			if(c == -1) break;
			String s = kin.readLine();
			boolean guessed[] = new boolean[26];
			char a[] = kin.readLine().toCharArray();
			int count = 0;
			for(int i = 0; i < a.length; i++) {
				if(!guessed[a[i]-'a']) {
					guessed[a[i] - 'a'] = true;
					if(s.contains(""+a[i])) {
						s = s.replace(""+a[i], "");
						if(s.length() == 0) break;
					} else {
						count++;
						if(count == 7) break;
					}
				}
			}
			System.out.println("Round "+c);
			if(s.length() == 0) System.out.println("You win.");
			else if(count == 7) System.out.println("You lose.");
			else System.out.println("You chickened out.");
		}
	}
}