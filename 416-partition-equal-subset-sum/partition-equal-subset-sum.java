class Solution {
    private static boolean solve(int[] nums, int idx, int target, int[][] dp){
        int n= nums.length;
        if(target==0){
            return true;
        }
        if(idx==0){
            return false;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1;
        }
        boolean notTake= solve(nums, idx-1, target, dp);

        boolean take= false;
        if(nums[idx]<=target){
            take= solve(nums, idx-1, target- nums[idx], dp);
        }
        dp[idx][target]= take|| notTake ? 1: 0;

        return dp[idx][target]==1;
    }
    public boolean canPartition(int[] nums) {
        int n= nums.length;
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0){
            return false;
        }
        int target= sum/2;
        int[][] dp= new int[n][target+1];
        for(int[]i : dp){
            Arrays.fill(i, -1);
        }
        return solve(nums, n-1, target, dp);
        
    }
}