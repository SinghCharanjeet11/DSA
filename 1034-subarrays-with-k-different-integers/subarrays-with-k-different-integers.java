class Solution {
    private static int subarray(int[] nums, int k){
        int n=nums.length;
        int left=0;
        int count=0;
        HashMap<Integer, Integer> freq= new HashMap<>();
        for(int right=0; right<n; right++){
            freq.put(nums[right], freq.getOrDefault(nums[right],0)+1);
            while(freq.size()>k){
                if(freq.get(nums[left])==1){
                    freq.remove(nums[left]);
                    left++;
                }
                else{
                    freq.put(nums[left], freq.get(nums[left])-1);
                    left++;
                }
            }
            count+= (right-left+1);
        }
        return count;

    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarray(nums,k) - subarray(nums, k-1);
        
    }
}