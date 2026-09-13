class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        for (int i = 0; i < n; i++) {
            int shift = rowShift[i] % n;
            int[] temp = new int[n];

            for (int j = 0; j < n; j++) {
                temp[(j - shift +n) % n] = grid[i][j];
            }

            grid[i] = temp;
        }
        for (int j = 0; j < n; j++) {
            int shift = colShift[j]%n;
            int[] temp= new int[n];
            for (int i = 0; i < n; i++) {
                temp[(i - shift +n) % n] = grid[i][j];
            }

            for(int i=0; i<n; i++){
                grid[i][j]=temp[i];
            }
        }
        return grid;
    }
}
