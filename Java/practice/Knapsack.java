package practice;

public class Knapsack {
    public static void main(String []args) {
        if(args.length < 2) {
            System.out.println("Insufficient Inputs");
        }

        int W = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int []vals = new int[n];
        int []w = new int[n];

        int j = 2;
        while(j < n + 2) {
            vals[j-2] = Integer.parseInt(args[j]);
            j++;
        }

        while(j < n*2 + 2) {
            w[j - n - 2] = Integer.parseInt(args[j]);
            j++;
        }

        printArray(vals);
        printArray(w);

        int [][]dp = new int[W+1][n+1];

        for(int i = 0; i < W+1; i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i < vals.length+1; i++) {
            dp[0][i] = 0;
        }
        for(int i = 1; i < W+1; i++) {
            for(int k = 1; k < vals.length + 1; k++) {
                if(w[k-1] < i) {
                    dp[i][k] = Math.max(dp[i][k-1], dp[i-w[k-1]][k-1] + vals[k-1]);
                } else {
                    dp[i][k] = dp[i][k-1];
                }
            }
        }

        System.out.println(dp[W][n]);
    }

    static void printArray(int []arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
