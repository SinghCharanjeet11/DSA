class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        
        int n= items.length;
        int[] free= new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && items[j][0]%items[i][0]==0){
                    free[i]++;
                }
            }
        }
        int minPrice=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            minPrice= Math.min(minPrice, items[i][1]);
        }


        int[] dp= new int[budget+1];

        for(int i=0; i<n; i++){
            int price= items[i][1];
            int reward= 1 + free[i];
            for(int j=budget; j>=price; j--){
                dp[j]= Math.max(dp[j], dp[j-price]+reward);
            }
        }
        int result=0;
        for(int j=0; j<= budget; j++){
            int left= (budget-j)/minPrice;
            result= Math.max(result, dp[j]+left);
        }
        return result;


    }
}