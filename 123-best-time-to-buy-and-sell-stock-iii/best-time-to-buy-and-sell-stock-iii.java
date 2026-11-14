class Solution {
    private static int solve(int[] prices, int[][][] dp, int idx, int canBuy, int transactionsLeft){
        int n= prices.length;
        if(idx==n || transactionsLeft==0){
            return 0;
        }
        if(dp[idx][canBuy][transactionsLeft]!=-1){
            return dp[idx][canBuy][transactionsLeft];
        }
        if(canBuy==1){
            int buy= -prices[idx] + solve(prices, dp, idx+1, 0, transactionsLeft);
            int skip= solve(prices, dp, idx+1, 1, transactionsLeft);
            return dp[idx][canBuy][transactionsLeft]= Math.max(buy, skip);
        }

        int sell= prices[idx] + solve(prices, dp, idx+1, 1, transactionsLeft-1);
        int hold= solve(prices, dp, idx+1, 0, transactionsLeft);
        return dp[idx][canBuy][transactionsLeft]= Math.max(sell, hold);

    }
    public int maxProfit(int[] prices) {

        int n= prices.length;
        int[][][] dp= new  int[n][2][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(prices, dp, 0, 1, 2);

    }
}