class Solution {
    public boolean checkString(String s) {
        int n= s.length();
        boolean foundB=false;
        for(int i=0; i<n; i++){
            if(foundB && s.charAt(i)=='a'){
                return false;
            }
            if(s.charAt(i)=='b'){
                foundB=true;
            }
        }
        return true;   
    }
}