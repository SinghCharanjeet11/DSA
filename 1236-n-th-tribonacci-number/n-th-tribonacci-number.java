class Solution {
    private int triplet(int n, int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        if(n==1 || n==2){
            return 1;
        }

        int ones= triplet(n-1,dp);
        int twos= triplet(n-2,dp);
        int threes= triplet(n-3,dp);
        
        return dp[n]= ones + twos + threes;
    }
    public int tribonacci(int n) {
        int[] dp =new int[n+1];
        Arrays.fill(dp, -1);
        return triplet(n,dp);
        
    }
}