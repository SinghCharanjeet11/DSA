class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThanTarget=0;
        int targetIndexes=0;
        List<Integer> result= new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]<target){
                lessThanTarget++;
            }
            else if(nums[i]==target){
                targetIndexes++;
            }
        }
        for(int i=0; i<targetIndexes; i++){
            result.add(lessThanTarget+i);
        }
        return result;
    }
}