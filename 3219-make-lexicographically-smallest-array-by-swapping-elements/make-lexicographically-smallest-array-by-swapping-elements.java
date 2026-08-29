class Solution {
    static class Pair{
        int val;
        int idx;
        Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        ArrayList<Pair>al=new ArrayList<>();
        // Store the pair valuse and their indexes..
        for(int i=0;i<nums.length;i++){
            al.add(new Pair(nums[i],i));
        }

        // Sort on the basis of values
        Collections.sort(al,(a,b)->Integer.compare(a.val,b.val));

        // Now we will create the grp

        int i=0;
        while(i<al.size()){
            int j=i;
            while(j+1<al.size() && al.get(j+1).val - al.get(j).val <= limit){
                j++;
            }
            // Now we will store the indexes of the grp
            ArrayList<Integer>grp=new ArrayList<>();
            for(int k=i;k<=j;k++){
                grp.add(al.get(k).idx);
            }
            Collections.sort(grp);
            // Now we will store teh smallest value first
            for(int k=0;k<grp.size();k++){
                nums[grp.get(k)]=al.get(i+k).val;
            }
            i=j+1;
        }
        return nums;

    }
}