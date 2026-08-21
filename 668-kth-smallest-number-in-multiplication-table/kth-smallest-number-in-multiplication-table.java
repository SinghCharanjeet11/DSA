class Solution {
    private static int count(int mid,int n,int m){
        int cnt=0;
        for(int i=1;i<=n;i++){
            cnt += Math.min(mid/i,m);
        }
        return cnt;
    }
    public int findKthNumber(int m, int n, int k) {
        int low=1;
        int high=n*m;

        while(low<high){
            int mid= low+(high-low)/2;
            if(count(mid,n,m)<k){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
        
    }
}