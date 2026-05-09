class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end = false;

        public void add(String s) {
            TrieNode node = this;
            for(char c: s.toCharArray()) {
                int i = c - 'a';
                if(node.children[i] == null) {
                    node.children[i] = new TrieNode();
                }
                node = node.children[i];
            }
            node.end = true;
        }
    }
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = new TrieNode();
        int n = s.length();

        for(String st: dictionary) root.add(st);

        int[] dp = new int[n + 1];
        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--) {
            //skip
            dp[i] = 1 + dp[i + 1];

            //take
            TrieNode temp = root;

            for(int j = i; j < n; j++) {
                char c = s.charAt(j);
                if(temp.children[c - 'a'] == null) break;
                temp = temp.children[c - 'a'];
                if(temp.end == true) dp[i] = Math.min(dp[i], dp[j + 1]);
            }
        }

        return dp[0];
    }
}