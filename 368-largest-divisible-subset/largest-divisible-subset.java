class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        // So overall the queestion is same as the LIS question but a but change in the if condition
        int[] dp= new int[n];
        Arrays.fill(dp, 1);
        int[] hash= new int[n];
        // if(n == 0) return new ArrayList<>();
        int maxi=1;
        int lastIdx=0;
        for(int i=0; i<n; i++){
            hash[i]=i;
            for(int j=0; j<i; j++){
                if(nums[i]%nums[j]==0 && dp[i] < 1+ dp[j]){
                    dp[i]= 1+ dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>maxi){
                maxi= dp[i];
                lastIdx=i;
            }
        }
        List<Integer> result= new ArrayList<>();
        while(hash[lastIdx]!=lastIdx){
            result.add(nums[lastIdx]);
            lastIdx= hash[lastIdx];
        }
        result.add(nums[lastIdx]);
        return result;
    }
}