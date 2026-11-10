class Solution {
    private static int solve(int row, int col, int[][] matrix,int[][] dp){
        int n= matrix.length;
        if(col<0 || col>=n){
            return (int)1e9;
        }
        if(row==n-1){
            return matrix[row][col];
        }
        if(dp[row][col]!=Integer.MIN_VALUE){
            return dp[row][col];
        }

        int downleft= solve(row+1, col-1, matrix, dp);
        int down= solve(row+1, col, matrix, dp);
        int downright= solve(row+1, col+1, matrix, dp);
        int mini= Math.min(downleft, Math.min(down, downright));

        return dp[row][col]= matrix[row][col] + mini;

    }
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;
        int result= Integer.MAX_VALUE;
        int[][] dp =new int[n][n];
        for(int[] i: dp){
            Arrays.fill(i, Integer.MIN_VALUE);
        }
// Each element in hte row is a possible part of the solution
        for(int col=0; col<n; col++){
            int sum= solve(0, col, matrix, dp);
            result= Math.min(result, sum);
        }

        return result;
    }
}