import java.io.*;
import java.util.*;

class Main {
	public static final String JOLLY = "Jolly";
	public static final String NOT_JOLLY = "Not jolly";

	public static void main(String args[]) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String line = kin.readLine();
			if(line == null) break;
			String inputs[] = line.split("\\s");
			int N = Integer.parseInt(inputs[0]);
			if(N > 1) {
				ArrayList<Integer> al = new ArrayList<>();
				for(int i = 0; i < N; i++) {
					al.add(Integer.parseInt(inputs[i+1]));
				}
				BitSet bs = new BitSet(N-1);
				for(int i = 0; i < N-1; i++) {
					bs.set(i, false);
				}
				for(int i = 0; i < N -1; i++) {
					int abs = Math.abs(al.get(i) - al.get(i+1));
					if(abs <= N-1 && abs >= 1) {
						if(bs.get(abs)) {
							System.out.println(NOT_JOLLY);
							break;
						}
						else {
							bs.set(abs);
						}
					} else {
						System.out.println(NOT_JOLLY);
						break;
					}
				}
				if(bs.cardinality() == N-1) System.out.println(JOLLY);
			} else {
				System.out.println(JOLLY);
			}
		}
	}
}