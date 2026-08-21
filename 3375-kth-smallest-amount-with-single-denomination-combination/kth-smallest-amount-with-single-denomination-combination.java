class Solution {
    // in inclusion - exclusion, we will use LCM so that let suppose in (2,3) , so 6 does not get count twice..
    private static long gcd(long a, long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    private static long lcm(long a, long b){
        return a/ gcd(a,b) * b;
    }

    private static long count(long mid, int[] coins){
        int n = coins.length;
        long cnt = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            long multiple = 1;
            int bits = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;
                    multiple = lcm(multiple, coins[i]);

                    // No multiple of this LCM can be <= mid
                    if (multiple > mid) {
                        break;
                    }
                }
            }
            if(multiple>mid) {
                continue;
            }
            long curr= mid/multiple;
            // Odd number of elements -> ADD
            if (bits % 2 == 1) {
                cnt += curr;
            }
            // Even number of elements -> SUBTRACT
            else {
                cnt -= curr;
            }
        }
        return cnt;
    }
    public long findKthSmallest(int[] coins, int k) {
        long low=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            low=Math.min(low,coins[i]);
        }
        long high=low* (long)k;
        while(low<high){
            long mid=low+(high-low)/2;
            if(count(mid,coins)<k){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
        
    }
}