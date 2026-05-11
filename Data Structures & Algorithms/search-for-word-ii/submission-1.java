class Solution {

    class Node {
        Node[] children = new Node[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {

        Node root = new Node();

        for (String w : words) {
            Node node = root;

            for (char c : w.toCharArray()) {
                int i = c - 'a';

                if (node.children[i] == null)
                    node.children[i] = new Node();

                node = node.children[i];
            }

            node.word = w;
        }

        List<String> res = new ArrayList<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int r, int c, Node node, List<String> res) {

        if (r < 0 || c < 0 || r == board.length || c == board[0].length)
            return;

        char ch = board[r][c];

        if (ch == '#' || node.children[ch - 'a'] == null)
            return;

        node = node.children[ch - 'a'];

        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, node, res);
        dfs(board, r - 1, c, node, res);
        dfs(board, r, c + 1, node, res);
        dfs(board, r, c - 1, node, res);

        board[r][c] = ch;
    }
}