import java.io.*;
import java.util.*;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		    String inputs[] = kin.readLine().split("\\s");
		    float h = Float.parseFloat(inputs[0]);
		    if(h == 0) break;
		    float u = Float.parseFloat(inputs[1]);
		    float d = Float.parseFloat(inputs[2]);
		    float f = Float.parseFloat(inputs[3])/100;
		    f = u*f;
		    float sh = 0;
		    int i = 1;
		    boolean suc = false, fail = false;
		    for(;!suc && !fail; i++) {
		        sh += u;
		        if(h < sh) {
		            suc = true;
                    break;
		        }
		        u -= f;
		        if(u < 0) u = 0;
		        sh -= d;
		        if(sh < 0) {
		            fail = true;
		            break;
		        }
		    }
		    if(suc) System.out.println("success on day "+i);
		    else System.out.println("failure on day "+i);
		}
	}	
}