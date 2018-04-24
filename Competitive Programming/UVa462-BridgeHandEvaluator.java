import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int point = 0;
			boolean stoppedH = false, stoppedS = false, stoppedD = false, stoppedC = false;
			HashMap<Character, Integer> points = new HashMap<>();
			HashMap<Character, Boolean> s, h, d, c;
			s = new HashMap<>();
			h = new HashMap<>();
			d = new HashMap<>();
			c = new HashMap<>();
			HashMap<Character, Integer> suit = new HashMap<>();
			String in = kin.readLine();
			if(in == null) break;
			String inputs[] = in.split("\\s");
			initArrays(s);
			initArrays(h);
			initArrays(d);
			initArrays(c);
			initPoints(points);
			initSuit(suit);
			for(String str: inputs) {
				char card = str.charAt(0);
				char su = str.charAt(1);
				point += points.get(card);
				suit.put(su, suit.get(su)+1);
				if(su == 'S') s.put(card, true);
				else if(su == 'H') h.put(card, true);
				else if(su == 'D') d.put(card, true);
				else c.put(card, true);
			}
			if(s.get('K') && suit.get('S') <= 1) point--;
			if(s.get('Q') && suit.get('S') <= 2) point--;
			if(s.get('J') && suit.get('S') <= 3) point--;
			if(h.get('K') && suit.get('H') <= 1) point--;
			if(h.get('Q') && suit.get('H') <= 2) point--;
			if(h.get('J') && suit.get('H') <= 3) point--;
			if(c.get('K') && suit.get('C') <= 1) point--;
			if(c.get('Q') && suit.get('C') <= 2) point--;
			if(c.get('J') && suit.get('C') <= 3) point--;
			if(d.get('K') && suit.get('D') <= 1) point--;
			if(d.get('Q') && suit.get('D') <= 2) point--;
			if(d.get('J') && suit.get('D') <= 3) point--;
			if(s.get('A') || (s.get('K') && suit.get('S') > 1) || (s.get('Q') && suit.get('S') > 2)) {
				stoppedS = true;
			}
			if(h.get('A') || (h.get('K') && suit.get('H') > 1) || (h.get('Q') && suit.get('H') > 2)) {
				stoppedH = true;
			}
			if(d.get('A') || (d.get('K') && suit.get('D') > 1) || (d.get('Q') && suit.get('D') > 2)) {
				stoppedD = true;
			}
			if(c.get('A') || (c.get('K') && suit.get('C') > 1) || (c.get('Q') && suit.get('C') > 2)) {
				stoppedC = true;
			}
			if(point >= 16 && stoppedS && stoppedH && stoppedD && stoppedC) {
				System.out.println("BID NO-TRUMP");
				continue;
			} else {
				if(suit.get('S') == 2) point++;
				else if(suit.get('S') == 1) point+=2;
				else if(suit.get('S') == 0) point+=2;
				if(suit.get('H') == 2) point++;
				else if(suit.get('H') == 1) point+=2;
				else if(suit.get('H') == 0) point+=2;
				if(suit.get('D') == 2) point++;
				else if(suit.get('D') == 1) point+=2;
				else if(suit.get('D') == 0) point+=2;
				if(suit.get('C') == 2) point++;
				else if(suit.get('C') == 1) point+=2;
				else if(suit.get('C') == 0) point+=2;
				int max = suit.get('S');
				char maxSuit = 'S';
				if(max < suit.get('H')) {
					max = suit.get('H');
					maxSuit = 'H';
				}
				if(max < suit.get('D')) {
					max = suit.get('D');
					maxSuit = 'D';
				}
				if(max < suit.get('C')) {
					max = suit.get('C');
					maxSuit = 'C';
				}
				if(point >= 14) {
					System.out.println("BID "+maxSuit);
					continue;
				}
			}
			System.out.println("PASS");
		}
	}

	static void initSuit(HashMap<Character, Integer> suit) {
		suit.put('S', 0);
		suit.put('H', 0);
		suit.put('C', 0);
		suit.put('D', 0);
	}

	static void initPoints(HashMap<Character, Integer> points) {
		points.put('A', 4);
		points.put('K', 3);
		points.put('Q', 2);
		points.put('J', 1);
		points.put('T', 0);
		points.put('2', 0);
		points.put('3', 0);
		points.put('4', 0);
		points.put('5', 0);
		points.put('6', 0);
		points.put('7', 0);
		points.put('8', 0);
		points.put('9', 0);
	}

	static void initArrays(HashMap<Character, Boolean> arr) {
		arr.put('A', false);
		arr.put('K', false);
		arr.put('Q', false);
		arr.put('J', false);
		arr.put('T', false);
		arr.put('2', false);
		arr.put('3', false);
		arr.put('4', false);
		arr.put('5', false);
		arr.put('6', false);
		arr.put('7', false);
		arr.put('8', false);
		arr.put('9', false);	
	}
}