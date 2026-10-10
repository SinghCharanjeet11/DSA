class Solution {
    // private static boolean checkParanthesis(String s, int idx, int count){
    //     if(idx==s.length()){
    //         if(count==0){
    //             return true;
    //         }
    //         return false;
    //     }
    //     if(count<0){
    //         return false;
    //     }

    //     if(s.charAt(idx)=='('){
    //         return checkParanthesis(s, idx+1, count+1);
    //     }
    //     else if(s.charAt(idx)==')'){
    //         return checkParanthesis(s, idx+1, count-1);
    //     }
    //     else{
    //         return checkParanthesis(s, idx+1, count+1) || checkParanthesis(s, idx+1, count-1) || checkParanthesis(s, idx+1, count);
    //     }

    // }
    public boolean checkValidString(String s) {
        // return checkParanthesis(s, 0, 0);

        int min=0;
        int max=0;
        for(char c: s.toCharArray()){
            if(c=='('){
                min+=1;
                max+=1;
            }
            else if(c==')'){
                min=min-1;
                max=max-1;
            }
            else{
                min=min-1;
                max+=1;
            }
            if(min<0){
                min=0;
            }
            // For ")()"
            if(max<0){
                return false;
            }
        }
        return min==0;
        
    }
}