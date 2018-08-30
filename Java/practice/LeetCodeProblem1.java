package practice;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}

public class LeetCodeProblem1 {
    public static void main(String []args) {
        Solution1 sol = new Solution1();
        int []ans = sol.twoSum(new int[]{2, 7, 11, 15}, 9);
        for(int i: ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
