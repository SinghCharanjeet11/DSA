class Solution {
    private static void allComb(String digits, String[]words, int idx, String curr, List<String> result){
        if(idx==digits.length()){
            result.add(curr);
            return;
        }
        String s=words[digits.charAt(idx)-'0'];
        for(int i=0;i<s.length();i++){
            allComb(digits, words, idx+1, curr+s.charAt(i), result);
        }


    }
    public List<String> letterCombinations(String digits) {
        String[] words= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result= new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        allComb(digits, words, 0, "", result);
        return result;
    }
}