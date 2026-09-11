// class Solution {
//     private static int solve(int[] digits, boolean[] used, int idx, int number){
//         if(idx==3){
//             if(number%2==0){
//                 return 1;
//             }
//             return 0;
//         }
//         int count=0;

//         for(int i=0; i<digits.length; i++){
//             if(used[i]){
//                 continue;
//             }
//             if(digits[i]==0 && idx==0){
//                 continue;
//             }
//             if(digits[i]%2!=0 && idx==2){
//                 continue;
//             }
//             used[i]=true;
//             count+= solve(digits, used, idx+1, number*10 + digits[i]);
//             used[i]=false;
//         }
//         return count;
//     }
//     public int totalNumbers(int[] digits) {
//         boolean[] used= new boolean[1000];
//         return solve(digits, used, 0, 0);
//     }
// }

class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer>ans =new HashSet<>();
        int n=digits.length;
        for(int i=0; i<n; i++){
            if(digits[i]==0){
                continue;
            }
            for(int j=0; j<n; j++){
                if(j==i){
                    continue;
                }
                for(int k=0; k<n; k++){
                    if(k==i || k==j){
                        continue;
                    }
                    if(digits[k]%2==0){
                        int num= digits[i]*100 + digits[j]*10 + digits[k];
                        ans.add(num);
                    }
                }
            }
        }
        return ans.size();
    }
}