class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer>al1=new ArrayList<>();
        ArrayList<Integer>al2=new ArrayList<>();

        int n=nums.length;
        al1.add(nums[0]);
        al2.add(nums[1]);


        for(int i=2;i<n;i++){
            if(al1.get(al1.size()-1)>al2.get(al2.size()-1)){
                al1.add(nums[i]);
            }
            else{
                al2.add(nums[i]);
            }
        }
        al1.addAll(al2);
        for(int i=0;i<n;i++){
            nums[i]=al1.get(i);
        }
        return nums;
    }
}