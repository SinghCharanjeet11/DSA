class Solution {
    private static int solve(int[] nums, int idx, int actualTarget){
        int n= nums.length;
        if(idx==0){
            if(actualTarget==0 &&nums[0]==0){
                return 2;
            }
            if(actualTarget==0 || nums[0]== actualTarget){
                return 1;
            }
            return 0;
        }
        int take=0;
        int notTake= solve(nums,idx-1, actualTarget);
        if(nums[idx]<= actualTarget){
            take= solve(nums, idx -1, actualTarget- nums[idx]);
        }
        return take+ notTake;
    }
    public int findTargetSumWays(int[] nums, int target) {
        // There are two possibilities i.e. either + or - like either to add it or to subtract it just like take or not take
        int n= nums.length;

        // Overall target= (totalSum+target )/2;
        int total=0;
        for(int i=0; i<n; i++){
            total+= nums[i];
        }
        if((total+target)%2!=0  ||  total < Math.abs(target)){
            return 0;
        }

        int actualTarget= (total+ target)/2;
        return solve(nums, n-1, actualTarget);

    }
}