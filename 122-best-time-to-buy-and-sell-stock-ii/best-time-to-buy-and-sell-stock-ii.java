class Solution {
    private static int solve(int[] prices, int[][] dp, int day, int canBuy){
        int n= prices.length;

        if(day==n){
            return 0;
        }
        if(dp[day][canBuy]!=-1){
            return dp[day][canBuy];
        }
        int bestProfit=0;
        if(canBuy==1){
            int buy= -prices[day] + solve(prices, dp, day+1, 0);
            int skip= solve(prices, dp, day+1, 1);
            bestProfit= Math.max(buy, skip);
        }
        else{
            int sell= prices[day] + solve(prices, dp, day+1, 1);
            int hold= solve(prices, dp, day+1, 0);
            bestProfit= Math.max(sell, hold);
        }

        return dp[day][canBuy]= bestProfit;
    }
    public int maxProfit(int[] prices) {
        
        int n= prices.length;
        int[][] dp= new int[n][2];

        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return solve(prices, dp, 0, 1);
        
        
    }
}