class Solution {
    private int distinctPaths(int[][] obstacleGrid, int i, int j, int[][] dp){
        if(i<0 || j<0 || obstacleGrid[i][j]==1){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down= distinctPaths(obstacleGrid, i-1, j, dp);
        int right= distinctPaths(obstacleGrid, i, j-1, dp);

        return dp[i][j]=down + right;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n= obstacleGrid[0].length;
        int[][] dp =new int[m][n];

        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        return distinctPaths(obstacleGrid, m-1, n-1, dp);
    }
}