class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]> result= new ArrayList<>();

// Initially we will find all the intervals that are lesser than the newInnterval starting point as they are of no need to merge them with the new interval
        int i=0;
        while(i<n && intervals[i][1]< newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
// Now is the interval that has the potential toentirely merge inside or partially so we will spectate it and store the min for the starting point and max for the ending point to get the desired result..
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0]= Math.min(newInterval[0], intervals[i][0]);
            newInterval[1]= Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

// These are the rest of them after the merges ones...
        while(i<n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);

        
    }
}