import java.io.*;
import java.util.*;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		    String input = kin.readLine();
		    if(input == null) break;
		    String inputs[] = input.split("\\s");
		    int n = Integer.parseInt(inputs[0]);
		    int b = Integer.parseInt(inputs[1]);
		    int h = Integer.parseInt(inputs[2]);
		    int w = Integer.parseInt(inputs[3]);
		    int cost = Integer.MAX_VALUE;
		    for(int i = 0; i < h; i++) {
		        int ct = Integer.parseInt(kin.readLine());
		        if(n*ct <= b) {
		            inputs = kin.readLine().split("\\s");
		            boolean flag = false;
		            for(int j = 0; j < w; j++) {
		                int avail = Integer.parseInt(inputs[j]);
		                if(avail >= n) {
		                    flag = true;
		                    break;
		                }
		            }
		            if(flag) cost = Math.min(cost, n*ct);
		        } else {
		            kin.readLine();
		        }
		    }
		    if(cost == Integer.MAX_VALUE) System.out.println("stay home");
		    else System.out.println(cost);
		}
	}	
}