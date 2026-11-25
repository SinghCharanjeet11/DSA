class Solution {
    private static int solve(String s, int left, int right, int[][]dp){
        if(left>right){
            return 0;
        }
        if(left==right){
            return 1;
        }
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        if(s.charAt(left)== s.charAt(right)){
            return 2+ solve(s, left+1, right-1, dp);
        }

        int incLeft= solve(s, left+1, right, dp);
        int incRight= solve(s, left, right-1, dp);
        return dp[left][right]=Math.max(incLeft, incRight);
    }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, 0, n-1, dp);
    }
}