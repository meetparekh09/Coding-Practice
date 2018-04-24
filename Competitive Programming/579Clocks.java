/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static final int hcon = 30;
    static final int mcon = 6;
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		    float h, m, hangle, mangle, diff;
		    String inputs[] = kin.readLine().split(":");
		    h = Float.parseFloat(inputs[0]);
		    m = Float.parseFloat(inputs[1]);
		    if(h == 0.0 && m == 0.0) break;
		    h += m/60;
		    hangle = h*hcon;
		    mangle = m*mcon;
		    if(hangle > mangle) diff = hangle - mangle;
		    else diff = mangle - hangle;
		    if(diff > 180) diff = 360 - diff;
		    System.out.println(String.format("%.3f", diff));
		}
	}
}
