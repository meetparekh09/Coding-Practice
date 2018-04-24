import java.io.*;
import java.util.*;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int q;
		while(true) {
		    q = Integer.parseInt(kin.readLine());
		    if(q == 0) break;
		    int n, m;
		    String inputs[] = kin.readLine().split("\\s");
		    n = Integer.parseInt(inputs[0]);
		    m = Integer.parseInt(inputs[1]);
		    for(int i = 0; i < q; i++) {
		        inputs = kin.readLine().split("\\s");
		        int x = Integer.parseInt(inputs[0]);
		        int y = Integer.parseInt(inputs[1]);
		        int xdiff = x - n;
		        int ydiff = y - m;
		        if(xdiff == 0 || ydiff == 0) {
		            System.out.println("divisa");
		        } else if(xdiff > 0) {
		            if(ydiff > 0) System.out.println("NE");
		            else System.out.println("SE");
		        } else {
		            if(ydiff > 0) System.out.println("NO");
		            else System.out.println("SO");
		        }
		    }
		}
	}	
}