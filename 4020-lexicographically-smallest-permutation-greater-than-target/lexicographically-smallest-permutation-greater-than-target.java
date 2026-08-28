class Solution {
    private static boolean canMakeGreater(int[] count, String target, int start){
        // Create the largest possible string from left characters

        StringBuilder largest=new StringBuilder();
        for(int c=25;c>=0;c--){
            while(count[c]>0){
                largest.append((char)(c+'a'));
                count[c]--;
            }
        }
        // Restoring the count of each character that is  left so that it can be used for further usecases..
        for(int i=0;i<largest.length();i++){
            count[largest.charAt(i)-'a']++;
        }
        String targetLeft= target.substring(start); //This is the left portion of the target substring

        return largest.toString().compareTo(targetLeft)>0;
    }
    public String lexGreaterPermutation(String s, String target) {
        int[] count=new int[26];
        for(char c: s.toCharArray()){
            count[c-'a']++;
        }
        StringBuilder result=new StringBuilder();
        int n=s.length();

        for(int i=0;i<n;i++){
            int targetChar=target.charAt(i)-'a';

            // Case 1-> When there is a possibility of getting the character

            if(count[targetChar]>0){
                count[targetChar]--;

                if(canMakeGreater(count, target, i+1)){
                    result.append(target.charAt(i));
                    continue;
                }
                count[targetChar]++;
            }

            // Case 2->Now we have no character , so we will create the smallest possible greater string

            for(int c=targetChar+1;c<26;c++){
                if(count[c]>0){
                    result.append((char)(c+'a'));
                    count[c]--;
                    for(int k=0;k<26;k++){
                        while(count[k]>0){
                            result.append((char)(k+'a'));
                            count[k]--;
                        }
                    }
                    return result.toString();
                }
            }
            return "";
        }
        return "";
    }
}