class Solution {
    public int countStaircase(int[] nums) {
        int n=nums.length;
        int result=0;
        for(int i=0; i<n; i++){
            HashMap<Integer, Integer> freq= new HashMap<>();
            HashMap<Integer, Integer> target= new HashMap<>();
            int dis=0;
            int matched=0;
            for(int j=i; j<n; j++){
                int x= nums[j];
                if(!freq.containsKey(x)){
                    dis++;
                    freq.put(x,1);
                    target.put(x,dis);
                    if(dis==1){
                        matched++;
                    }
                }
                else{
                    int oldFreq= freq.get(x);
                    int req= target.get(x);
                    if(oldFreq==req){
                        // Now the olDfreq will be greater than the required, so mactched decreases
                        matched--;
                    }
                    int newFreq= oldFreq+1;
                    freq.put(x, newFreq);
                    if(newFreq==req){
                        matched++;
                    }
                }
                if(dis==matched){
                    result++;
                }
            }

        }
        return result;
    }
}