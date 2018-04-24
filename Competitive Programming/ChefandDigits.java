import java.io.*;
import java.util.*;


class Codechef {
	
	public static void main(String[] args) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(kin.readLine());
		while(t > 0) {
		    int num0 = 0, num1 = 0;
		    String s = kin.readLine();
		    int i = 0;
		    int j = s.length() - 1;
		    while(i <= j) {
		        if(num0 > 1 && num1 > 1) break;
		        if(s.charAt(i) == '1') num1++;
		        else num0++;
		        if(j > i) {
		        	if (s.charAt(j) == '1') num1++;
		        	else num0++;
		        }
		        i++; j--;
		    }
		    if(num0 == 1 || num1 == 1) System.out.println("Yes");
		    else System.out.println("No");
		    t--;
		}
	}	
}