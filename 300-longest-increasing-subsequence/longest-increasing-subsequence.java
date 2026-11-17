class Solution {
    private static int solve(int[] nums, int idx, int prev, int[][] dp){
        int n= nums.length;

        if(idx==n){
            return 0;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
        int take=0;
        int notTake= solve(nums, idx+1, prev, dp);
        if(prev==-1 || nums[idx] > nums[prev]){
            take= 1+ solve(nums, idx+1, idx, dp);
        }

        return dp[idx][prev+1]=Math.max(take, notTake);

        
    }
    public int lengthOfLIS(int[] nums) {
        // So we have to use DP here, lets go with memoization first and then the tabulation aprt

        int n= nums.length;
        int[][] dp = new int[n][n+1];
        for(int[]i: dp){
            Arrays.fill(i, -1);
        }
        return solve(nums,0, -1, dp);
    }
}