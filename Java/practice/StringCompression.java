package practice;

public class StringCompression {
    public static void main(String []args) {
        if(args.length < 1) {
            System.out.println("Insufficient Inputs");
            return;
        }

        char []input = args[0].toCharArray();
        StringBuilder output = new StringBuilder();

        char lastChar = input[0];
        int lastCharCount = 1;

        for(int i = 1; i < input.length; i++) {
            if(input[i] == lastChar) {
                lastCharCount++;
            } else{
                output.append(lastChar);
                output.append(lastCharCount);
                lastChar = input[i];
                lastCharCount = 1;
            }
        }

        if(lastCharCount > 0) {
            output.append(lastChar);
            output.append(lastCharCount);
        }
        if(output.toString().length() > input.length) {
            System.out.println(args[0]);
        } else {
            System.out.println(output.toString());
        }
    }
}
