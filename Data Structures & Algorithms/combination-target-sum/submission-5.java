class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int i, int[] c, int target, List<Integer> curr, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (i == c.length || target < 0) return;

        curr.add(c[i]);
        dfs(i, c, target - c[i], curr, res);

        curr.remove(curr.size() - 1);
        dfs(i + 1, c, target, curr, res);
    }
}