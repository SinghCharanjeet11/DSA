class Solution {
    public boolean canAliceWin(int n) {
        int removed=10;
        if(n<10){
            return false;
        }
        boolean alice=true;
        while(n>=removed){
            n= n-removed;
            removed--;
            alice= !alice;


        }
        return !alice;
        
    }
}