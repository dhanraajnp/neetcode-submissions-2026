class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length, n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pac, i, 0, 0);
            dfs(heights, atl, i, n - 1, 0);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pac, 0, j, 0);
            dfs(heights, atl, m - 1, j, 0);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    void dfs(int[][] h, boolean[][] ocean, int r, int c, int prev) {

        if (r < 0 || c < 0 || r == h.length || c == h[0].length)
            return;

        if (ocean[r][c] || h[r][c] < prev)
            return;

        ocean[r][c] = true;

        dfs(h, ocean, r + 1, c, h[r][c]);
        dfs(h, ocean, r - 1, c, h[r][c]);
        dfs(h, ocean, r, c + 1, h[r][c]);
        dfs(h, ocean, r, c - 1, h[r][c]);
    }
}