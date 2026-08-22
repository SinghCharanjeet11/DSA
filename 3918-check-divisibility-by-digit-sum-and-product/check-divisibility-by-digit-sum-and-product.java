class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int product=1;
        int x=n;
        while(n>0){
            int rem= n%10;
            sum+= rem;
            product *= rem;
            n/=10;
        }
        if(x%(sum+product)==0){
            return true;
        }
        return false;
    }
}