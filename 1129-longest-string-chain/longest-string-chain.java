class Solution {
    private static boolean isPredecessor(String prev, String curr){
        if(prev.length()+1!=curr.length()){
            return false;
        }
        int i=0;
        int j=0;
        while(i<prev.length() && j<curr.length()){
            if(prev.charAt(i)==curr.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return i==prev.length();
    }
    public int longestStrChain(String[] words) {

        int n= words.length;
        Arrays.sort(words, (a,b)-> a.length()- b.length());

        int[] dp= new int[n];
        Arrays.fill(dp, 1);
        int maxi=1;

        for(int curr=0; curr<n; curr++){
            for(int prev=0; prev<curr; prev++){
                if(isPredecessor(words[prev], words[curr])){
                    dp[curr]= Math.max(dp[curr], 1 + dp[prev]);
                }
            }
            maxi= Math.max(maxi, dp[curr]);
        }
        return maxi;

        
    }
}