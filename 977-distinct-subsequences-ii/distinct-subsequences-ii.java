class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1_000_000_007;
        long total = 1; 
        long[] last = new long[26];

        for (char ch : s.toCharArray()) {
            int c = ch - 'a';
            long newTotal = (2 * total - last[c] + MOD) % MOD;
            last[c] = total;
            total = newTotal;
        }
        return (int) ((total - 1 + MOD) % MOD);
    }
}