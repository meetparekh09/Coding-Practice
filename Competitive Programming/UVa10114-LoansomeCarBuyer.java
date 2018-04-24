import java.io.*;
import java.util.*;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		    String inputs[] = kin.readLine().split("\\s");
		    float d = Float.parseFloat(inputs[0]);
		    if(d < 0) break;
		    float down = Float.parseFloat(inputs[1]);
		    float loan = Float.parseFloat(inputs[2]);
		    int q = Integer.parseInt(inputs[3]);
		    float monpay = loan/d;
		    float val = loan + down;
		    float dep = 0;
		    int currmon = 0;
		    boolean flag = true;
		    int i = 0;
		    for(; i < q && flag; i++) {
		        inputs = kin.readLine().split("\\s");
		        int mon = Integer.parseInt(inputs[0]);
		        float dept = Float.parseFloat(inputs[1]);
		        if(i == 0) {
		            val -= val*dept;
		            dep = dept;
		        } else {
		            int j = currmon + 1;
		            while(j < mon) {
		                if(loan < val) {
		                    flag = false;
		                    break;
		                }
		                loan -= monpay;
		                val -= val*dep;
		                currmon++;
		                j++;
		            }
		            dep = dept;
		        }
		    }
		    while(i < q) {
		        kin.readLine();
		        i++;
		    }
		    int j = currmon + 1;
		    while(j <= d) {
	            if(loan < val) {
		          break;
		        }
                loan -= monpay;
		        val -= val*dep;
		        currmon++;
		        j++;
	        }
		    if(currmon == 1) System.out.println(currmon+" month");
		    else System.out.println(currmon+" months");
		}
	}	
}