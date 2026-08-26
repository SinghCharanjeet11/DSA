class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left=0;
        int n=s.length();
        int count=0;
        String sb="";
        for(int right=0; right<n;right++){

            if(s.charAt(right)=='1'){
                count++;
            }
            while (count > k) {
                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }

            //Shorten the size 
            while (count == k && s.charAt(left) == '0') {
                left++;
            }
        // Here we will check for the lexographical position of '1';
            if(count==k){
                String curr=s.substring(left,right+1);
                if(sb.equals("")|| curr.length()<sb.length() || 
                // Agar length barabar hui toh compare to to determine the order
                (curr.length()==sb.length() && sb.compareTo(curr)>0)){
                    sb=curr;
                }
            }
        }
        return sb;
        
    }
}