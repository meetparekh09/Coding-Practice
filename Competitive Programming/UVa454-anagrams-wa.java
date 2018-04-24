import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine());
		in.readLine();
		StringBuilder sb = new StringBuilder();
		while(t > 0) {
			HashMap<String, ArrayList<String>> map = new HashMap<>();
			while(true) {
				String s = in.readLine();
				if(s == null || s.equals("")) break;
				String str = s.replaceAll("\\s", "");
				char a[] = str.toCharArray();
				Arrays.sort(a);
				str = new String(a);
				if(map.containsKey(str)) {
					map.get(str).add(s);
				} else {
					map.put(str, new ArrayList<>());
					map.get(str).add(s);
				}
			}
			Set<String> keys = map.keySet();
			ArrayList<ArrayList<String>> output = new ArrayList<>();
			for(String str: keys) {
				if(map.get(str).size() > 1) {
					ArrayList<String> al = map.get(str);
					Collections.sort(al, new Comparator<String>() {
						@Override
						public int compare(String a, String b) {
							a.replace("\\s", "");
							b.replace("\\s", "");
							return a.compareTo(b);
						}
					});
					int ind = 0;
					for( ;ind < output.size(); ind++) {
						if(al.get(0).compareTo(output.get(ind).get(0)) < 0) break;
					}
					output.add(ind, al);
				}
			}
			for(int k = 0; k < output.size(); k++) {
				ArrayList<String> al = output.get(k);
				for(int i = 0; i < al.size(); i++) {
					for(int j = i+1; j < al.size(); j++) {
						sb.append(al.get(i)+" = "+al.get(j)+"\n");
					}
				}
			}
			sb.append("\n");
			t--;
		}
		sb.deleteCharAt(sb.lastIndexOf("\n"));
		sb.deleteCharAt(sb.lastIndexOf("\n"));
		out.print(sb);
		out.close();
	}
}