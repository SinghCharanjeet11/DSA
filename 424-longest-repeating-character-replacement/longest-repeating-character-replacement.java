class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        char[] ch = s.toCharArray();

        HashMap<Character, Integer> freq = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        int maxFreq = 0;

        for (int right = 0; right < n; right++) {
            freq.put(ch[right], freq.getOrDefault(ch[right], 0) + 1);

            maxFreq = Math.max(maxFreq, freq.get(ch[right]));

            while ((right - left + 1) - maxFreq > k) {
                freq.put(ch[left], freq.get(ch[left]) - 1);

                if (freq.get(ch[left]) == 0) {
                    freq.remove(ch[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}