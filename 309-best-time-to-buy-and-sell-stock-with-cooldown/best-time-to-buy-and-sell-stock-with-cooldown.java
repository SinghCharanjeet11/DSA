class Solution {
    private static int solve(int[] prices, int idx, int canBuy, int[][] dp){
        int n= prices.length;
        if(idx>=n){
            return 0;
        }
        if(dp[idx][canBuy]!=-1){
            return dp[idx][canBuy];
        }
        int profit=0;

        if(canBuy==1){
            int buy= -prices[idx] + solve(prices, idx+1, 0, dp);
            int skip= solve(prices, idx+1, 1, dp);
            return dp[idx][canBuy]= Math.max(buy, skip);
        }

        int sell= prices[idx]+ solve(prices, idx+2, 1, dp);
        int hold= solve(prices, idx+1, 0, dp);
        return dp[idx][canBuy]= Math.max(sell, hold);
    }
    public int maxProfit(int[] prices) {

        int n= prices.length;
        int[][] dp= new int[n][2];

        for(int[]i : dp){
            Arrays.fill(i, -1);
        }
        return solve(prices, 0, 1, dp);

    }
}