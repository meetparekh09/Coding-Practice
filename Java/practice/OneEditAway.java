package practice;

import java.util.Arrays;

public class OneEditAway {
    public static void main(String []args) {
        if(args.length < 2) {
            System.out.println("Insufficient Inputs");
            return;
        }

        char []input1 = args[0].toCharArray();
        char []input2 = args[1].toCharArray();

        Arrays.sort(input1);
        Arrays.sort(input2);

        int i = 0, j = 0;
        int dist = 0;

        while(i < input1.length && j < input2.length) {
            if(input1[i] != input2[j]) {
                dist++;
                if(input1[i] > input2[j]) {
                    j++;
                } else {
                    i++;
                }
            } else {
                i++;
                j++;
            }
        }

        while(i < input1.length) {
            dist++;
            i++;
        }

        while(j < input2.length) {
            dist++;
            j++;
        }

        if(dist > 1) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
}
