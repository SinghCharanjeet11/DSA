class Solution {
    private static void allComb(String digits, String[] words, int idx, StringBuilder sb, List<String> result){
        if(idx==digits.length()){
            result.add(sb.toString());
            return;
        }
        String s= words[digits.charAt(idx)-'0'];
        for(int k=0; k<s.length(); k++){
            sb.append(s.charAt(k));
            allComb(digits, words, idx+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
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