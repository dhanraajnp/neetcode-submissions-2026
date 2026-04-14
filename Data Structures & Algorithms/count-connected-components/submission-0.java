class Solution {

    public int countComponents(int n, int[][] edges) {

        int[] parent = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        int count = n;

        for (int[] e : edges) {

            int p1 = find(parent, e[0]);
            int p2 = find(parent, e[1]);

            if (p1 != p2) {
                parent[p1] = p2;
                count--;
            }
        }

        return count;
    }

    int find(int[] p, int x) {
        if (p[x] != x)
            p[x] = find(p, p[x]);
        return p[x];
    }
}