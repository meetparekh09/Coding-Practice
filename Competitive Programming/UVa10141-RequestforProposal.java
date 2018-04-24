import java.io.*;
import java.util.*;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int c = 1;
		while(true) {
		    String inputs[] = kin.readLine().split("\\s");
		    int n = Integer.parseInt(inputs[0]);
		    if(n == 0) break;
		    if(c!=1) System.out.println();
		    int p = Integer.parseInt(inputs[1]);
		    //HashMap<String, Float> map = new HashMap<>();
		    float maxCom = 0;
		    String best = null;
		    float bstprice = Float.MAX_VALUE;
		    for(int i = 0; i < n; i++) kin.readLine();
		    for(int i = 0; i < p; i++) {
		        String s1 = kin.readLine();
		        inputs = kin.readLine().split("\\s");
		        float price = Float.parseFloat(inputs[0]);
		        float com = Float.parseFloat(inputs[1]);
		        //map.add(s1, price);
		        if(com > maxCom) {
		            maxCom = com;
		            best = s1;
		            bstprice = price;
		        } else if(com == maxCom) {
		            if(price < bstprice) {
		                maxCom = com;
		                best = s1;
		                bstprice = price;
		            }
		        }
		        for(int j = 0; j < com; j++) kin.readLine();
		    }
		    System.out.println("RFP #"+(c++));
		    System.out.println(best);
		}
	}	
}