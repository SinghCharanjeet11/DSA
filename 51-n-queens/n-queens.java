class Solution {
    private static void solve(int col, char[][] board, int n, int[] leftRow, int[]lowerDiagonal, int[]upperDiagonal, List<List<String>>result){
        if(col==n){
            List<String> temp =new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            result.add(temp);
            return;
        }

        for(int row=0; row<n; row++){
            if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[n-1+col-row]==0){
                board[row][col]='Q';
                // Recursive part
                leftRow[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[n-1+col-row]=1;

                solve(col+1, board, n, leftRow, lowerDiagonal, upperDiagonal, result);

                // Backtrack
                board[row][col]='.';
                // Recursive part
                leftRow[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[n-1+col-row]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board= new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i],'.');
        }
        int[] leftRow= new int[n];
        int[] lowerDiagonal= new int[2*n-1];
        int[] upperDiagonal= new int[2*n-1];
        solve(0, board, n, leftRow, lowerDiagonal, upperDiagonal, result);
        return result;
        
    }
}