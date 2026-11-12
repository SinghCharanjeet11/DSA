class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxCount=1;
        int inc=1;
        int dec=1;
        int n= nums.length;

        for(int i=1; i<n; i++){
            inc=  nums[i-1]<nums[i]? inc+1: 1;
            dec= nums[i-1] > nums[i] ? dec +1: 1;
            maxCount= Math.max(maxCount, Math.max(inc, dec));
        }
        return maxCount;
        
    }
}