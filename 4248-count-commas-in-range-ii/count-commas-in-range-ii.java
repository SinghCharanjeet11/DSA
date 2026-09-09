class Solution {
    public long countCommas(long n) {
        if(n<1000){
            return 0;
        }
        long ans=0;
        long start=1000;
        int comma=1;
        while (start <= n) {
            long end = start * 1000 - 1;
            if (end > n) {
                end = n;
            }
            ans += (end - start + 1) * comma;
            start *= 1000;
            comma++;
        }
        return ans;
    }
}