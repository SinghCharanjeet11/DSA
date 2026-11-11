class Solution {
    // private static int solve(int row, int col, int[][] matrix, int[][] dp){
    //     int m= matrix.length;
    //     int n= matrix[0].length;
    //     if(row<0 || row>=m || col<0 || col>=n){
    //         return 0;
    //     }
    //     if(matrix[row][col]==0){
    //         return 0;
    //     }
    //     if(dp[row][col]!=-1){
    //         return dp[row][col];
    //     }
    //     int topLeft= solve(row-1, col-1, matrix, dp);
    //     int top= solve(row-1, col, matrix, dp);
    //     int left= solve(row, col-1, matrix, dp);

    //     int mini= Math.min(top, Math.min(topLeft, left));

    //     return dp[row][col]= mini + 1;

    // }
    public int countSquares(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;

        int result = 0;
        int[][] dp= new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j]==1){
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    }
                    else{
                        dp[i][j]= 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    }
                }
                result+= dp[i][j];
            }
        }
        return result;
    }
}