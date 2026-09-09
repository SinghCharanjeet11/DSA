class Solution {
    private static void dfs(String nums, int target, int start, long currValue, long lastOperand, String expression, List<String> result){
        if(start==nums.length()){
            if(currValue==target){
                result.add(expression);
            }
            return;
        }

        for(int i=start; i<nums.length(); i++){
            // We dont want leading zeroes so remove them
            if(i>start && nums.charAt(start)=='0'){
                return;
            }
            String currNum= nums.substring(start, i+1);
            long currNumValue = Long.parseLong(currNum);

            if(start==0){
                dfs(nums, target, i+1, currNumValue, currNumValue, currNum, result);
            }
            else{
                // First lets go with "+" sign
                dfs(nums, target, i+1, currValue + currNumValue, currNumValue, expression + "+" + currNum, result);
                // Now for the "-" sign
                dfs(nums, target, i+1, currValue - currNumValue, -currNumValue, expression + "-" + currNum, result);
                // At last with the "*" sign... We have to look for sign also in this so look closely into the calling function
                dfs(nums, target, i+1, currValue - lastOperand + lastOperand*currNumValue, currNumValue*lastOperand, expression + "*" + currNum, result);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String> result= new ArrayList<>();
        dfs(num, target, 0, 0, 0, "", result);
        return result;
        
    }
}