package practice;

public class LeetCodeProblem63 {
    public static void main(String []args) {
        Solution63 sol = new Solution63();
        System.out.println(sol.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}

class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int [][]paths = new int[m][n];
        paths[0][0] = 1;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) continue;
                if(i > 0 && obstacleGrid[i-1][j] != 1) {
                    paths[i][j] += paths[i-1][j];
                    // System.out.println("i :: " + i + ", j :: " + j + ", path :: " + paths[i][j]);
                }
                if(j > 0 && obstacleGrid[i][j - 1] != 1) {
                    paths[i][j] += paths[i][j-1];
                    // System.out.println("i :: " + i + ", j :: " + j + ", path :: " + paths[i][j]);
                }
            }
        }

        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(paths[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        return paths[m-1][n-1];
    }
}
