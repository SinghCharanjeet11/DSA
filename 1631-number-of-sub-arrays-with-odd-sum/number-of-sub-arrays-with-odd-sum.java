class Solution {
    public int numOfSubarrays(int[] arr) {

        int n= arr.length;
        long count=0;
        int mod=1_000_000_007;
// Because initially we have even prefic as 0 , so count is 1,
        long even=1;
        long odd=0;
        int sum=0;

        for(int i=0; i<n; i++){
            sum+= arr[i];
                if(sum%2 == 0){
                    count+=odd;
                    even++;
                }
                else{
                    count+= even;
                    odd++;
                }
                count= count%mod;
        }
        return (int)count;
        
    }
}