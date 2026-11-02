class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        int mid=nums[n/2];
        int count=0;
        for(int i=0; i<n; i++){
            if(nums[i]>mid){
                count+= (nums[i]-mid);
            }
            else{
                count+= (mid-nums[i]);
            }
        }
        return count;
        
    }
}