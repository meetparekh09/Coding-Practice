import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Integer> al = new ArrayList<>();
		while(true) {
			String input = in.readLine();
			if(input == null || input.equals("")) break;
			al.add(Integer.parseInt(input.replaceAll("\\s", "")));
			Collections.sort(al);
			int ind = al.size() / 2;
			if(al.size() % 2 == 0) {
				BigInteger bi = new BigInteger(al.get(ind).toString());
				bi = bi.add(new BigInteger(al.get(ind-1).toString()));
				bi = bi.divide(new BigInteger("2"));
				out.println(bi.toString());
			} else {
				out.println(al.get(ind));
			}
		}
		out.close();
	}
}