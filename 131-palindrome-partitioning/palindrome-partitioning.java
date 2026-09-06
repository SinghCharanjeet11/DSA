class Solution {
    private static void allPalindromePartition(String s, int idx, List<List<String>> result, List<String> curr){
        // Reached till last, that means this is the possible parition where the parts are palindrome..
        if(idx== s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }

        // We will do loo[ing and check whether the part is palindrom and if yes then do the parts inside it else not..
        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s, idx, i)){
                //This part is palindromic
                curr.add(s.substring(idx, i+1));
                // Now go for the next one
                allPalindromePartition(s, i+1, result, curr);
                // Remove the last one to check all possibility
                curr.remove(curr.size()-1);
            }
        }  
    }
    private static boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result =new ArrayList<>();
        List<String> curr= new ArrayList<>();

        allPalindromePartition(s, 0, result, curr);
        return result;
        
    }
}