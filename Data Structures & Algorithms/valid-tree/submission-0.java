class Solution {

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        int[] parent = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int[] e : edges) {

            int p1 = find(parent, e[0]);
            int p2 = find(parent, e[1]);

            if (p1 == p2)
                return false;

            parent[p1] = p2;
        }

        return true;
    }

    int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);

        return parent[x];
    }
}