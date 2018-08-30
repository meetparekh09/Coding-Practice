package practice;

import java.util.Arrays;

public class IsUnique {
    public static void main(String args[]) {
        //System.out.println(args.length);
        if(args.length < 1) {
            System.out.println("Not enough input arguments");
            return;
        }
        System.out.println(args[0]);
        String input = args[0];
        char []inputArray = input.toCharArray();
        Arrays.sort(inputArray);

        for(int i = 1; i < inputArray.length; i++) {
            if(inputArray[i-1] == inputArray[i]) {
                System.out.println("Not Unique");
                return;
            }
        }
        System.out.println("Unique");
    }
}
