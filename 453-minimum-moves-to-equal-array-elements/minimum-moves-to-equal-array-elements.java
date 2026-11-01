class Solution {
    public int minMoves(int[] nums) {
        
        int sum=0;
        int n= nums.length;
        int mini= Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            mini= Math.min(mini, nums[i]);
        }
        for(int i=0; i<n; i++){
            if(nums[i]>mini){
                sum+= (nums[i]-mini);
            }
        }
        return sum;
    }
}