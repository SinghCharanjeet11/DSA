class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort the array to get the prescribed result so that the intervals are on their desired position
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

        List<int[]> result= new ArrayList<>();
        int n= intervals.length;
        
        for(int i=0; i<n; i++){
            if(result.isEmpty() || (intervals[i][0] > result.get(result.size()-1)[1])){
                result.add(intervals[i]);
            }
            else{
                result.get(result.size()-1)[1]= Math.max(intervals[i][1], result.get(result.size()-1)[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}