public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> charSet = new HashSet<>();
        // for (int i = 0; i < s.length(); i++) {
        //     Set<Character> charSet = new HashSet<>();
        //     for (int j = i; j < s.length(); j++) {
        //         if (charSet.contains(s.charAt(j))) {
        //             break;
        //         }
        //         charSet.add(s.charAt(j));
        //     }
        //     res = Math.max(res, charSet.size());
        // }
        int l = 0;
        int r = 0;
        int len = s.length();
        int max =0;

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