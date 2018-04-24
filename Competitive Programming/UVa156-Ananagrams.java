import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		HashMap<String, Boolean> map = new HashMap<>();
		ArrayList<String> words = new ArrayList<>();
		ArrayList<String> keys = new ArrayList<>();
		ArrayList<String> ans = new ArrayList<>();
		while(true) {
			String inputs[] = in.readLine().split("\\s+");
			if(inputs[0].equals("#")) break;
			for(String s: inputs) {
				words.add(s);
				char ar[] = s.toLowerCase().toCharArray();
				Arrays.sort(ar);
				s = new String(ar);
				keys.add(s);
				if(map.containsKey(s)) {
					map.put(s, false);
				} else {
					map.put(s, true);
				}
			}
		}
		for(int i = 0; i < words.size(); i++) {
			if(map.get(keys.get(i))) {
				ans.add(words.get(i));
			}
		}
		Collections.sort(ans);
		for(String s: ans) {
			out.write(s+"\n");
		}
		out.close();
	}
}