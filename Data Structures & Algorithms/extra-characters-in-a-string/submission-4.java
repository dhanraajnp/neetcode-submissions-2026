class Solution {
    /*
    Plain DP was inefficient because it had to brute-force every possible prefix combination
    Within each function call, O(n^2) * n calls = O(n^3)
    So use a prefix tree to remove this overhead
    Inside the loop, Instead of building a substring and looking that up in a set, this only
    checks char by char in constant time (no non-constant operations)
    So O(n^2) [i.e. potentially O(2*n^2)]
    */

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private String s;
    private Integer[] dp;
    private TrieNode root = new TrieNode();

    private void insertDictionary(String[] words) {
        for (String s: words) {
            TrieNode node = root;

            for (char c: s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }

                node = node.children[c - 'a'];
            }

            node.isEnd = true;
        }
    }

    private int dfs(int index) {
        /*
        Decision tree => recursive dfs
        2 choices for every char (minimised across every calc):
        1. Skip this char (pay 1) and continue scanning from the next
        2. Consider this char as the start of a dictionary word and scan every possible prefix
        starting from this char (including the char) to the end of string
        To avoid recomputing cost already computed for an index, use memoization
        */

        if (dp[index] != null) {
            // Already computed cost for this index, no need to recompute
            return dp[index];
        }

        int cost = 1 + dfs(index + 1); // Skip (pay 1) and continue scanning from next char
        TrieNode node = root;

        for (int j = index; j < s.length(); j++) {
            /*
            For every single character, we want to know if this character is in the children
            of the node (it may be root or whatever the current node is)
            If the character is not present in the node's children, then that word wasn't added
            So break early
            If it is present, then traverse the node to check the next character
            */
            if (node.children[s.charAt(j) - 'a'] == null) {
                break;
            }

            node = node.children[s.charAt(j) - 'a'];

            if (node.isEnd) {
                // Is a dictionary word, compare costs

                // Min across all prefix costs  + skip cost
                cost = Math.min(cost, dfs(j + 1));
            }
        }

        if (dp[index] == null) {
            dp[index] = cost;
        }

        return cost;
    }

    public int minExtraChar(String s, String[] dictionary) {        
        this.s = s;
        this.dp = new Integer[s.length() + 1]; // +1 to handle base case (end of string) elegantly

        // Base case: reached end of string, no more chars left to calc/skip, so no extra chars left
        dp[s.length()] = 0;

        // Insert dictionary first
        insertDictionary(dictionary);

        return dfs(0); // Start scanning from beginning
    }
}