class Solution {
    private static int solve(List<List<Integer>> triangle, int row, int col, int[][] dp){
        int n= triangle.size();
        if(row==n-1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col]!= Integer.MAX_VALUE){
            return dp[row][col];
        }
        int down= solve(triangle, row+1, col, dp);
        int downRight= solve(triangle, row+1, col+1, dp);

        return dp[row][col]=triangle.get(row).get(col) + Math.min(down,downRight);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        int[][] dp= new int[n][n];
        for(int[] i : dp){
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        return solve(triangle, 0, 0, dp);
        
    }
}