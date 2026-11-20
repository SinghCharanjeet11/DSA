class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n= nums.length;
         int[] dp =new int[n];
         int[] count= new int[n];
         Arrays.fill(dp, 1);
         Arrays.fill(count, 1);
        int maxi=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[j]< nums[i]){
                    // Now we have 2 option
                    // The new sequence is greater in length than the previous one
                    if(dp[j]+1> dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                    else if(dp[j]+1==dp[i]){
                        count[i]+= count[j];
                    }
                }
            }
            maxi= Math.max(maxi, dp[i]);
        }

        int result=0;
        for(int i=0; i<n; i++){
            if(dp[i]==maxi){
                result+= count[i];
            }
        }
        return result;
    }
}