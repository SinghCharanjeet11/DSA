class Solution {
    private static int solve(int[][] grid, int row, int col, int[][] dp){
        int n= grid.length;
        if(col<0 || col>=n){
            return (int)1e9;
        }

        if(row==n-1){
            return grid[row][col];
        }
        if(dp[row][col]!= Integer.MAX_VALUE){
            return dp[row][col];
        }
        int mini= Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(i!=col){
                mini= Math.min(mini,solve(grid, row+1, i, dp));
            }
        }

        return dp[row][col]= mini+ grid[row][col];

    }
    public int minFallingPathSum(int[][] grid) {
        int n= grid.length;
        int result= Integer.MAX_VALUE;
        int[][] dp= new int[n][n];

        for(int[] i: dp){
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        for(int col=0; col<n; col++){
            int sum= solve(grid, 0, col, dp);
            result= Math.min(result, sum);
        }
        return result;
    }
}