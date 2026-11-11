class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int pairs=0;
        int n= time.length;
        int[] freq= new int[60];
        for(int i=0; i<n; i++){
            int val= time[i]%60;
            int req= (60-val)%60;

            pairs+= freq[req];
            freq[val]++;
        }
        return pairs;
        
    }
}