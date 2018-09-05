package practice;

import java.util.Scanner;

public class UVa108 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int [][]a = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i > 0) a[i][j] += a[i-1][j];
                if(j > 0) a[i][j] += a[i][j-1];
                if(i > 0 && j > 0) a[i][j] -= a[i-1][j-1];
            }
        }

        int maxSubRect = a[0][0];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = i; k < n; k++) {
                    for(int l = j; l < n; l++) {
                        int subRect = a[k][l];
                        if(i > 0) subRect -= a[i-1][l];
                        if(j > 0) subRect -= a[k][j-1];
                        if(i > 0 && j > 0) subRect += a[i-1][j-1];
                        maxSubRect = Math.max(subRect, maxSubRect);
                    }
                }
            }
        }

        System.out.println(maxSubRect);
    }
}
