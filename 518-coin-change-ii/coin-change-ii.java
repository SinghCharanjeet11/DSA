class Solution {
    private static int solve(int idx, int amount, int[] coins, int[][] dp){
        if(amount==0){
            return 1;
        }
        if(idx==0){
            return amount%coins[0]==0 ? 1: 0;
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }

        int take=0;
        int notTake= solve(idx-1, amount, coins, dp);
        if(coins[idx]<=amount){
            take=solve(idx, amount- coins[idx], coins, dp);
        }

        return dp[idx][amount]=(take+notTake);
    }
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int[][] dp= new int[n][amount+1];

        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return solve(n-1, amount, coins, dp);

    }
}