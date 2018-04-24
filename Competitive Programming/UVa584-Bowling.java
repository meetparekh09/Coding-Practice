import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			String input = in.readLine();
			if(input.equals("Game Over")) break;
			String inputs[] = input.split("\\s");
			int sum = 0;
			int frame = 0;
			for(int i = 0; i < inputs.length && frame < 10; i++) {
				if(inputs[i].equals("X")) {
					sum+=10;
					frame++;
					if(inputs[i+2].equals("/")) sum += getScore("/");
					else if(inputs[i+1].equals("X") && i+2 >= inputs.length) {
						sum += getScore(inputs[i+1]);
					}
					else {
						sum += getScore(inputs[i+1]) + getScore(inputs[i+2]);
					}
				} else if(inputs[i+1].equals("/")) {
					sum += 10;
					frame++;
					sum += getScore(inputs[i+2]);
					i++;
				} else {
					sum += getScore(inputs[i]) + getScore(inputs[i+1]);
					i++;
					frame++;
				}
			}
			out.println(sum);
		}
		out.close();
	}

	public static int getScore(String s) {
		if(s.equals("X")) return 10;
		else if(s.equals("/")) return 10;
		else return Integer.parseInt(s);
	}
}