class WordDictionary {

    class Node {
        Node[] children = new Node[26];
        boolean word;
    }

    Node root = new Node();

    public void addWord(String word) {
        Node node = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a';

            if (node.children[i] == null)
                node.children[i] = new Node();

            node = node.children[i];
        }

        node.word = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, Node node) {

        if (node == null) return false;

        if (i == word.length()) return node.word;

        char c = word.charAt(i);

        if (c == '.') {
            for (Node child : node.children) {
                if (dfs(word, i + 1, child))
                    return true;
            }
            return false;
        }

        return dfs(word, i + 1, node.children[c - 'a']);
    }
}