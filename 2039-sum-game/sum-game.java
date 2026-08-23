class Solution {
    private static double getExpected(char c){
        return c=='?' ? 4.5 : c-'0';
    }
    public boolean sumGame(String num) {
        int n=num.length();
        double ans=0.0;

        // Left Side
        for(int i=0;i<n/2;++i){
            ans+= getExpected(num.charAt(i));
        }

        // Right Side
        for(int i=n/2;i<n;++i){
            ans-= getExpected(num.charAt(i));
        }
        return ans != 0.0;
    }
}