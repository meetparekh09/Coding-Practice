import java.io.*;
import java.util.*;

class Main {

	static Map<Character, Character> map = new HashMap<>();
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		initMap();
		while(true) {
			String s = in.readLine();
			if(s == null || s.equals("")) break;
			int i = 0, j = s.length() - 1;
			boolean rev = true;
			boolean pal = true;
			while(j >= i) {				
				if(rev && (map.get(s.charAt(i)) == null || map.get(s.charAt(i)) != s.charAt(j))) rev = false;
				if(pal && s.charAt(i) != s.charAt(j)) pal = false;
				j--;
				i++;
			}
			out.print(s + " -- is ");
			if(!pal && !rev) out.println("not a palindrome.");
			else if(pal && !rev) out.println("a regular palindrome.");
			else if(!pal && rev) out.println("a mirrored string.");
			else out.println("a mirrored palindrome.");
			out.println();
		}
		out.close();
	}

	static void initMap() {
		map.put('A', 'A');
		map.put('E', '3');
		map.put('H', 'H');
		map.put('I', 'I');
		map.put('J', 'L');
		map.put('L', 'J');
		map.put('M', 'M');
		map.put('O', 'O');
		map.put('S', '2');
		map.put('T', 'T');
		map.put('U', 'U');
		map.put('V', 'V');
		map.put('W', 'W');
		map.put('X', 'X');
		map.put('Y', 'Y');
		map.put('Z', '5');
		map.put('1', '1');
		map.put('2', 'S');
		map.put('3', 'E');
		map.put('5', 'Z');
		map.put('8', '8');
	}
}