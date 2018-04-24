import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String inputs[] = kin.readLine().split("\\s");
			boolean a[] = new boolean[52];
			if(inputs[0].equals("0")) break;
			ArrayList<Integer> pr = new ArrayList<>();
			ArrayList<Integer> p = new ArrayList<>();
			int prp = 0;
			for(int i = 0; i < 3; i++) {
				pr.add(Integer.parseInt(inputs[i]));
				a[pr.get(i) - 1] = true;
			}
			int k = 3;
			for(int i = 0; i < 2; i++) {
				p.add(Integer.parseInt(inputs[k++]));
				a[p.get(i) - 1] = true;
			}
			Collections.sort(pr);
			Collections.sort(p, Collections.reverseOrder());
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 2; j++) {
					if(pr.get(i) > p.get(j)) {
						prp++;
						pr.set(i, 0);
						p.set(j, 53);
					}
				}
			}
			Collections.sort(pr, Collections.reverseOrder());
			if(prp == 0) {
				int val = 1;
				while(val <= 52 && a[val-1]) {
					val++;
				}
				System.out.println(val);
			} 
			else if(prp == 1) {
				int val = pr.get(0) + 1;
				while(val <= 52 && a[val - 1]) {
					val++;
				}
				if(val > 52) System.out.println(-1);
				else System.out.println(val);
			}
			else System.out.println(-1);
		}
	}
}