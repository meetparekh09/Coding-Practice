import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(kin.readLine());
		while(t > 0) {
			HashMap<Character, Long> hm = new HashMap<>();
			int k = Integer.parseInt(kin.readLine());
			for(int i = 0; i < k; i++) {
				String line = kin.readLine().trim();
				char a = line.charAt(0);
				long val = Long.parseLong(line.substring(2, line.length()));
				hm.put(a, val);
			}
			int m = Integer.parseInt(kin.readLine());
			double value = 0;
			for(int i = 0; i < m; i++) {
				String line = kin.readLine();
				for(int j = 0; j < line.length(); j++) {
					if(hm.containsKey(line.charAt(j))) {
						value += hm.get(line.charAt(j));
					}
				}
			}
			System.out.println(String.format("%.2f", (value/100))+"$");
			t--;
		}
	}
}