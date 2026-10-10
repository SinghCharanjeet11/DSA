class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort the array to get the prescribed result so that the intervals are on their desired position
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

        List<int[]> result= new ArrayList<>();
        int n= intervals.length;
        
        for(int i=0; i<n; i++){
            if(!result.isEmpty() && (intervals[i][1] <= result.get(result.size()-1)[1])){
                continue;
            }
            int start= intervals[i][0];
            int end= intervals[i][1];
            
            for(int j= i+1; j<n; j++){
                if(intervals[j][0]<=end){
                    end= Math.max(end, intervals[j][1]);
                }
                else{
                    break;
                }
            }
            result.add(new int[]{start,end});
        }
        return result.toArray(new int[result.size()][]);
    }
}