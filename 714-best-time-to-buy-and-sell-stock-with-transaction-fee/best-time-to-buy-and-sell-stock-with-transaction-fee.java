class Solution {
    // We have to use dp based on constraints as recursive approach is not working on these stcok based problems
    private static int solve(int[] prices, int idx, int canBuy, int fee, int[][] dp){
        int n=prices.length;

        if(idx==n){
            return 0;
        }
        if(dp[idx][canBuy]!=-1){
            return dp[idx][canBuy];
        }
        int maxProfit=0;
        if(canBuy==1){
            int buy= -prices[idx] + solve(prices, idx+1, 0, fee, dp);
            int skip= solve(prices, idx+1, 1, fee, dp);
            return dp[idx][canBuy]= Math.max(buy, skip);
        }

        int sell= prices[idx] - fee + solve(prices, idx+1, 1, fee, dp);
        int hold= solve(prices, idx+1, 0, fee, dp);
        return dp[idx][canBuy]= Math.max(sell, hold);
    }
    public int maxProfit(int[] prices, int fee) {
        int n= prices.length;
        int[][]dp= new int[n][2];

        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return solve(prices, 0, 1, fee, dp);
    }
}