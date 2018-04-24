import java.io.*;
import java.util.*;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(kin.readLine());
		int c = 1;
		while(t > 0) {
		    String inputs[] = kin.readLine().split("\\s");
		    int n1 = Integer.parseInt(inputs[0]);
		    int n2 = Integer.parseInt(inputs[1]);
		    int n3 = Integer.parseInt(inputs[2]);
		    System.out.println("Case "+(c++)+": "+mid(n1, n2, n3));
		    t--;
		}
	}	
	
	static int mid(int n1, int n2, int n3) {
	    if(n1 < n2) {
	        if(n1 < n3) {
	            if(n2 < n3) return n2;
	            else return n3;
	        } else {
	            return n1;
	        }
	    } else {
	        if(n1 < n3) {
	            return n1;
	        } else {
	            if(n2 < n3) return n3;
	            else return n2;
	        }
	    }
	}
}