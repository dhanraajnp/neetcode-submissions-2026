class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int bestStart = 0;
        int bestLen = 1;

        for (int i = 0; i < s.length(); i++) {
            int oddLen = expandAroundCenter(s, i, i);       // center at i
            int evenLen = expandAroundCenter(s, i, i + 1);  // center between i and i+1

            int currLen = Math.max(oddLen, evenLen);

            if (currLen > bestLen) {
                bestLen = currLen;
                bestStart = i - (currLen - 1) / 2;
            }
        }

        return s.substring(bestStart, bestStart + bestLen);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}