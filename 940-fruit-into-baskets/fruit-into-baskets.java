class Solution {
    public int totalFruit(int[] fruits) {
        // Overall we have to find the subarray where distinct elements are only two and the the size of that subarray is the answer
        int n=fruits.length;
        int left=0;
        int maxLen=Integer.MIN_VALUE;
        HashMap<Integer,Integer>freq= new HashMap<>();
        for(int right=0; right<n; right++){
            freq.put(fruits[right], freq.getOrDefault(fruits[right],0)+1);
            while(freq.size()>2){
                if(freq.get(fruits[left])==1){
                    freq.remove(fruits[left]);
                    left++;
                }
                else{
                    freq.put(fruits[left], freq.get(fruits[left])-1);
                    left++;
                }
            }
            maxLen=Math.max(maxLen, right-left+1);
        }
        return maxLen;
        
    }
}