class Solution {
    private int stairs(int n,int[] dp){
        if (n==0 || n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ones= stairs(n-1,dp);
        int twos= stairs(n-2, dp);
        return dp[n]=ones+twos;
        
    }
    public int climbStairs(int n) {
        int[] dp =new int[n+1];
        Arrays.fill(dp, -1);
        return stairs(n,dp);
    }
}