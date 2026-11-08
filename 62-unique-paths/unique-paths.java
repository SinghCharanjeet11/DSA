class Solution {
    private int totalPath(int i, int j, int m, int n, int[][] dp){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int down= totalPath(i+1, j, m, n, dp);
        int right= totalPath(i, j+1, m, n, dp);

        dp[i][j]= down + right;

        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp= new int[m][n];

        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return totalPath(0, 0, m, n, dp);
    }
}