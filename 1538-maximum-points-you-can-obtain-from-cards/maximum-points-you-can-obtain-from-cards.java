class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n= cardPoints.length;

        if(k==n){
            int sum=0;
            for(int i=0; i<n; i++){
                sum+= cardPoints[i];
            }
            return sum;
        }
        int[] leftScore= new int[k+1];
        int[] rightScore= new int[k+1];

        for(int i=1; i<=k; i++){
            leftScore[i]= leftScore[i-1]+cardPoints[i-1];
        }
        for(int i=1; i<=k; i++){
            rightScore[i]= rightScore[i-1]+ cardPoints[n-i];
        }

        int maxScore=Integer.MIN_VALUE;
        for(int i=0; i<=k; i++){
            int currScore= leftScore[i]+ rightScore[k-i];
            if(currScore>maxScore){
                maxScore=currScore;
            }
        }
        return maxScore;
        
    }
}