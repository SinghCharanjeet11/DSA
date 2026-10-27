class Solution {
    private static int decode(String s,int idx, int[] dp){
        if(idx==s.length()){
            return 1;
        }
        if(s.charAt(idx)=='0'){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ways= decode(s, idx+1, dp);

        if(idx+1< s.length()){
            int num= (s.charAt(idx)- '0') * 10 + (s.charAt(idx+1) - '0');
            if(num>=10 && num<=26){
                ways+= decode(s, idx+2, dp);
            }
        }

        return dp[idx]=ways;




    }
    public int numDecodings(String s) {
        int n= s.length();
        int[] dp =new int[n+1];
        Arrays.fill(dp,-1);
        ArrayList<String> result= new ArrayList<>();
        return decode(s, 0, dp);
        
    }
}