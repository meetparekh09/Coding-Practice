import java.io.*;
import java.util.*;


class Codechef {
	
	public static void main(String[] args) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(kin.readLine());
		while(t > 0) {
			String s = kin.readLine();
		    char[] str = s.toCharArray();
		    int i = 0;
		    int j = s.length() - 1;
		    boolean notPossible = false;
		    while(i <= j) {
		    	if(i < j) {
		        	if(str[i] == '.' && str[j] != '.') {
		        		str[i] = str[j];
		        	} else if(str[j] == '.' && str[i] != '.') {
		        		str[j] = str[i];
		        	} else if(str[i] == '.' && str[j] == '.') {
		        		str[i] = str[j] = 'a';
		        	} else if(str[i] != str[j]) {
		    			notPossible = true;
		        		break;
		        	}
		        } else if(i == j) {
		        	if(str[i] == '.') str[i] = 'a';
		        }
		        i++;
		        j--;
		    }
		    if(notPossible) System.out.println("-1");
		    else System.out.println(new String(str));
		    t--;
		}
	}	
}