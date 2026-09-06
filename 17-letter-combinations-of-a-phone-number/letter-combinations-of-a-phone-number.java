class Solution {
    private static void allComb(String digits, String[]words, int idx, StringBuilder curr, List<String> result){
        if(idx==digits.length()){
            result.add(curr.toString());
            return;
        }
        String s=words[digits.charAt(idx)-'0'];
        for(int i=0;i<s.length();i++){
            curr.append(s.charAt(i));
            allComb(digits, words, idx+1, curr, result);
            curr.deleteCharAt(curr.length()-1);
        }

    }
    public List<String> letterCombinations(String digits) {
        String[] words= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result= new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        StringBuilder sb= new StringBuilder();
        allComb(digits, words, 0, sb, result);
        return result;
    }
}