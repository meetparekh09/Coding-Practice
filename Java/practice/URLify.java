package practice;

public class URLify {
    public static void main(String []args) {
        if(args.length < 2) {
            System.out.println("Insufficient Inputs");
            return;
        }
        char []input = args[0].toCharArray();
        int len = Integer.parseInt(args[1]);

        int dist = input.length - len;

        for(int i = len - 1; i > 0; i--) {
            if(input[i] != ' ') {
                input[i+dist] = input[i];
            } else {
                input[i+dist] = '0';
                input[i+dist-1] = '2';
                input[i+dist-2] = '%';
                dist -= 2;
            }

            if(dist == 0) {
                break;
            }
        }

        String str = new String(input);
        System.out.println(str);
    }
}
