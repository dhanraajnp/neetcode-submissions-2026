public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int res =0, l = 0, r = 0;
        int len = s.length();

        if(len ==1){
            return 1;
        }
        
        while (r< len) {
            while (charSet.contains(s.charAt(r)) ) {
                charSet.remove(s.charAt(l));
                l++;
            }
            
            charSet.add(s.charAt(r));
            res = Math.max(res, r - l +1);
            r++;
        }
        return res;
    }
}