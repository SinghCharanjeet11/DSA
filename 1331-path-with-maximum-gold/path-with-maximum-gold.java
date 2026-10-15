class Solution {
    private static int getValue(int i, int j, int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n){
            return 0;
        }
        if(grid[i][j]==0){
            return 0;
        }

        int gold= grid[i][j];
        grid[i][j]=0;

        int left= getValue(i-1, j , grid);
        int right= getValue(i+1, j , grid);
        int up= getValue(i, j-1 , grid);
        int down= getValue(i, j+1 , grid);

        grid[i][j]= gold;

        return gold+Math.max(left, Math.max(right, Math.max(up, down)));

    }
    public int getMaximumGold(int[][] grid) {
        int maxValue=0;
        int n=grid.length;
        int m= grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]!=0){
                    int value= getValue(i,j,grid);
                    maxValue= Math.max(value,maxValue);
                }
            }
        }
        return maxValue;

    }
}