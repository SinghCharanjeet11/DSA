class Solution {
    public int countPartitions(int[] nums) {
        int total=0;
        int n= nums.length;
        
        for(int i=0; i<n; i++){
            total+=nums[i];
        }
        if((total&1)==1){
            return 0;
        }
        return n-1;
        
    }
}