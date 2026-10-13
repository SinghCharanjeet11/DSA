class Solution {
    private static int maxRect(int[] heights){
        Stack<Integer> st= new Stack<>();
        int maxArea=0;
        int n= heights.length;
        for(int i=0; i<=n; i++){
            int currHt= i==n ? 0 : heights[i];
            while(!st.isEmpty() && heights[st.peek()]>currHt){
                int h= heights[st.pop()];
                int wt= st.isEmpty() ? i : i- st.peek()-1;
                maxArea= Math.max(maxArea, h * wt);
            }
            st.push(i);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows= matrix.length;
        int cols= matrix[0].length;
        int[] heights= new int[cols];
        int maxArea=0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }
                else{
                    heights[j]=0;
                }
            }
            maxArea= Math.max(maxArea, maxRect(heights));
        }
        return maxArea;
    }
}