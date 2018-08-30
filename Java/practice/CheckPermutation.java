package practice;

import java.util.HashMap;

public class CheckPermutation {
    public static void main(String []args) {
        if(args.length < 2) {
            System.out.println("Insufficient inputs");
            return;
        }
        char []input1 = args[0].toCharArray();
        char []input2 = args[1].toCharArray();

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < input1.length; i++) {
            Character c = new Character(input1[i]);
            if(map1.containsKey(c)) {
                map1.put(c, new Integer(map1.get(c).intValue() + 1));
            } else {
                map1.put(c, new Integer(1));
            }
        }

        for(int i = 0; i < input2.length; i++) {
            Character c = new Character(input2[i]);
            if(map2.containsKey(c)) {
                map2.put(c, new Integer(map2.get(c).intValue() + 1));
            } else {
                map2.put(c, new Integer(1));
            }
        }

        if(map1.equals(map2)) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }
}
