class Solution {
    public int missingMultiple(int[] nums, int k) {
        int[] idx=new int[101];
        for(int i=0;i<nums.length;i++){
            if(nums[i]%k==0){
                idx[nums[i]/k]=1;
            }
        }
        for(int i=1;i<idx.length;i++){
            if(idx[i]==0){
                return i*k;
            }
        }
        return k*101;
        
    }
}