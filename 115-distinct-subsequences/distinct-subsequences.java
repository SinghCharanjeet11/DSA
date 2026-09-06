class Solution {
    public int numDistinct(String s, String t) {
        char[] sChar= s.toCharArray();
        char[] tChar= t.toCharArray();
        int slen= sChar.length;
        int tlen= tChar.length;

        int[] dp =new int[tlen+1];
        dp[0]=1;
        for(int i=1;i<=slen;i++){
            for(int j=tlen;j>=1;j--){
                int take= 0;
                if(sChar[i-1]==tChar[j-1]){
                    take=dp[j-1];
                }
                int skip=dp[j];
                dp[j]=take+skip;
            }
        }
        return dp[tlen];
    }
}