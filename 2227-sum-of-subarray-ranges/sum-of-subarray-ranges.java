class Solution {
    private static void solve(int[] nums, int idx, List<Integer> result){
        int n= nums.length;
        
        if(idx==nums.length){
            return;
        }
        int minValue= Integer.MAX_VALUE;
        int maxValue= Integer.MIN_VALUE;
        for(int i=idx; i<n; i++){
            minValue= Math.min(minValue, nums[i]);
            maxValue= Math.max(maxValue, nums[i]);
            result.add(maxValue-minValue);
        }
        solve(nums, idx+1, result);
    }
    public long subArrayRanges(int[] nums) {
        List<Integer> result = new ArrayList<>();
        solve(nums, 0, result);

        long sum=0;
        for(int i: result){
            sum+= (long)i;
        }
        return sum;
    }
}