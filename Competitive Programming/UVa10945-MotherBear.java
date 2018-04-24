import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			String str = in.readLine();
			if(str.equals("DONE")) break;
			str = str.toLowerCase();
			int i = 0;
			int j = str.length() - 1;
			boolean flag = true;
			while(i < j) {
				if(isPunctuation(str.charAt(i))) i++;
				else if(isPunctuation(str.charAt(j))) j--;
				else {
					if(str.charAt(i) == str.charAt(j)) {
						i++;
						j--;
					} else {
						flag = false;
						break;
					}
				}
			}
			if(flag) out.write("You won't be eaten!\n");
			else out.write("Uh oh..\n");
		}
		out.close();
	}

	static boolean isPunctuation(char a) {
		return (a == '.' || a == ',' || a ==  '!' || a == '?' || a == ' ');
	}
}