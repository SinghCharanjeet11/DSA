class Solution {
    private static int countSubarray(int[] nums, int goal){
        if(goal<0){
            return 0;
        }
        int n=nums.length;
        int left=0;
        int count=0;
        int sum=0;
        int right=0;

        while(right<n){
            sum+= nums[right];
            while(sum>goal){
                sum-= nums[left];
                left++;
            }
            count+= (right-left+1);
            right++;
        }
        return count;

    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSubarray(nums,goal)-countSubarray(nums, goal-1);
        
    }
}