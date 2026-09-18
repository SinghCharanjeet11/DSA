class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n=heights.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        for(int i=0 ; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                leftMax[i]=-1;
            }
            else{
                leftMax[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rightMax[i]=n;
            }
            else{
                rightMax[i]=st.peek();
            }
            st.push(i);
        }
        int maxArea=0;
        for(int i=0; i<n; i++){
            int ht= heights[i];
            int width= rightMax[i]- leftMax[i]-1;
            int area=ht*width;
            maxArea= Math.max(maxArea, area);
        }
        return maxArea;       
    }
}