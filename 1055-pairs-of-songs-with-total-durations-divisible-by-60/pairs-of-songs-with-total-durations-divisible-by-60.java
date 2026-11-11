class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int pairs=0;
        int n= time.length;
        HashMap<Integer, Integer> hm= new HashMap<>();
        for(int i=0; i<n; i++){
            int val= time[i]%60;
            int remaining= (60-val)%60;
            if(hm.containsKey(remaining)){
                pairs+= hm.getOrDefault(remaining,0);
            }
            hm.put(val, hm.getOrDefault(val, 0)+1);
        }

        return pairs;
        
    }
}