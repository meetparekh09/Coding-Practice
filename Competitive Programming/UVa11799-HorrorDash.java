import java.io.*;
import java.util.*;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(kin.readLine());
		int c = 1;
		while(t > 0) {
		    String inputs[] = kin.readLine().split("\\s");
		    int max = 1;
		    int n = Integer.parseInt(inputs[0]);
		    for(int i = 1; i <= n; i++) {
		        max = Math.max(max, Integer.parseInt(inputs[i]));
		    }
		    System.out.println("Case "+(c++)+": "+max);
		    t--;
		}
	}	
}