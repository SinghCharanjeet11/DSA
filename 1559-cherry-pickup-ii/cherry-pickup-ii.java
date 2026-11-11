class Solution {
    private static int solve(int row, int col1, int col2, int[][] grid, int[][][] dp){
        int n= grid.length;
        int m= grid[0].length;
        if(col1<0 || col2<0 || col1>=m || col2>=m){
            return (int)-1e9;
        }
         if(row == n-1) {
            if(col1 == col2) {
                return grid[row][col1];
            }
            return grid[row][col1] + grid[row][col2];
        }
        if(dp[row][col1][col2]!=-1){
            return dp[row][col1][col2];
        }
        int cherries = grid[row][col1];

        if(col1 != col2) {
            cherries += grid[row][col2];
        }

        int maxi = Integer.MIN_VALUE;
        // i is for robot1 and j is for robot2
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                int ans= solve(row+1, col1+i, col2+j, grid, dp);
                maxi= Math.max(maxi, ans);
            }
        }
        return dp[row][col1][col2]= cherries+maxi;
    }
    public int cherryPickup(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        // We will initailize that poioisition to 0 and the variable will take that and then recursively will store that value if that possible is not taken
        int[][][] dp = new int[n][m][m];

        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        int result= solve(0, 0, m-1, grid, dp);
        return result;
    }
}