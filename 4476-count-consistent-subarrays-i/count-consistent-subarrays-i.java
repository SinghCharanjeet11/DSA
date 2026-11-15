class Solution {
    public int countConsistent(int[] nums) {

        int n= nums.length;
        int maxCount=0;
        for(int i=0; i<n; i++){
                int mini=Integer.MAX_VALUE;
                int xor=nums[i];
            for(int j=i; j<n; j++){
                    mini=Math.min(mini, nums[j]);
                    xor = xor & nums[j];
                if(xor==mini){
                    maxCount++;
                }
            }
        }
        return maxCount;
        
    }
}