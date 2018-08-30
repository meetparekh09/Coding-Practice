package practice;

import java.util.HashMap;
import java.util.Set;

public class PalindromePermutation {
    public static void main(String args[]) {
        if(args.length < 1) {
            System.out.println("Insufficient Inputs");
            return;
        }
        String str = args[0];
        str = str.toLowerCase();
        str = str.replaceAll("\\s+", "");
        System.out.println(str);

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            Character c = new Character(str.charAt(i));
            if(map.containsKey(c)) {
                map.put(c, new Integer(map.get(c).intValue() + 1));
            } else {
                map.put(c, new Integer(1));
            }
        }

        int oneCount = 0;
        Set<Character> keys = map.keySet();
        for(Character c: keys) {
            if((map.get(c).intValue() % 2) == 1) {
                oneCount++;
                if(oneCount > 1) {
                    System.out.println("False");
                    return;
                }
            } else {
                continue;
            }
        }

        System.out.println("True");

    }
}
