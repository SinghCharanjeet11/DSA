class Solution {
    private static boolean solve(char[][] board, int i, int j, String word, int idx){
        int n=board.length;
        int m=board[0].length;
        if (idx == word.length()) {
            return true;
        }
        if(i<0 || i>=n || j<0 || j>=m || board[i][j]!= word.charAt(idx)){
            return false;
        }
        char temp= board[i][j];
        board[i][j]='#';

        boolean found= solve(board, i+1, j, word, idx+1) || solve(board, i-1, j, word, idx+1) || 
        solve(board, i, j-1, word, idx+1) || solve(board, i, j+1, word, idx+1);

        board[i][j]=temp;

        return found;


    }
    public boolean exist(char[][] board, String word) {

        int m= board.length;
        int n=board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(solve(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
}