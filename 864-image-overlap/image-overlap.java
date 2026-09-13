class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int[][] shifts= new int[2*n][2*n];
        int overlap=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(img1[i][j]!=1){
                    continue;
                }
                for(int r2=0; r2<n; r2++){
                    for(int c2=0; c2<n; c2++){
                        if(img2[r2][c2]!=1){
                            continue;
                        }
                        int rShift= n + i -r2;
                        int cShift= n + j-c2;
                        shifts[rShift][cShift]++;
                        overlap = Math.max(overlap, shifts[rShift][cShift]);
                    }
                }
            }
        }
        return overlap;
    }
}