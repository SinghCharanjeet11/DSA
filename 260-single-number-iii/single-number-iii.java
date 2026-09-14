class Solution {
    public int[] singleNumber(int[] nums) {
        // First we will find the XOR of the two elements that has frequency=1
        int x=0;
        for(int i=0;i<nums.length; i++){
            x^= nums[i];
        }
        int count=x & -x;
        // X is the XOR of the two numbers
        // Now split the array on the basis of the two right most set bit 
        int XOR1=0;
        int XOR2=0;
        for(int i=0; i<nums.length; i++){
            if((nums[i] & count) !=0){
                XOR1^=nums[i];
            }
            else{
                XOR2^= nums[i];
            }
        }
        if( XOR1<= XOR2){
            return new int[]{XOR1,XOR2};
        }
        return new int[]{XOR2, XOR1};
    }

}