class Solution {
    public int longestOnes(int[] nums, int k) {
        int n= nums.length;
        int zeroes=0;
        int maxLen= Integer.MIN_VALUE;
        int start=0;

        for(int right=0; right<n; right++){
            if(nums[right]==0){
                zeroes++;
            }
            while(zeroes>k){
                if(nums[start]==0){
                    zeroes--;
                }
                start++;
            }
            maxLen= Math.max(maxLen, right-start+1);
        }
        return maxLen;
    }
}