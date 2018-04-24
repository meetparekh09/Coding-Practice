import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in)); 
		PrintWriter out = new PrintWriter(System.out, true);
		while(true) {
			boolean start = false;
			LinkedList<Character> list = new LinkedList<>();
			LinkedList<Character> tempList = new LinkedList<>();
			String line = kin.readLine();
			int prev = 1;
			if(line == null) break;
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == '[') {
					start = true;
					if(prev == 0) {
						list.addAll(0, tempList);
						tempList = new LinkedList<>();	
					}
					prev = 0;
				} else if(line.charAt(i) == ']') {
					start = false;
					if(prev == 0) {
						list.addAll(0, tempList);
						tempList = new LinkedList<>();
					}
					prev = 1;
				} else {
					if(start) {
						tempList.add(line.charAt(i));
					} else {
						list.addLast(line.charAt(i));
					}
				}
			}
			if(tempList.size() > 0) {
				list.addAll(0, tempList);
			}
			int i = 0;
			for(char c: list) {
				out.write(c);
				i++;
			}
			out.write('\n');
		}
		out.close();
	}
}