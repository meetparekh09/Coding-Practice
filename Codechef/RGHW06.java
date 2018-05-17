/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int t;
		t = Integer.parseInt(kin.readLine());
		while(t > 0) {
		    int n = Integer.parseInt(kin.readLine());
		    int[] price = new int[n];
		    String[] inputs = kin.readLine().split("\\s+");
		    int min_elem = -1;
		    int max_till_now = 0;
		    for(int i = 0; i < n; i++) {
		        price[i] = Integer.parseInt(inputs[i]);
		        if(price[i] < min_elem || min_elem == -1) {
		            min_elem = price[i];
		        }
		        if(price[i] - min_elem > max_till_now) {
		            max_till_now = price[i] - min_elem;
		        }
		    }
		    System.out.println(max_till_now);
		    t--;
		}
	}
}
