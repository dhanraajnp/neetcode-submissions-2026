class Solution {

    public boolean canFinish(int n, int[][] pre) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[n];

        for (int[] p : pre) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.offer(i);

        int count = 0;

        while (!q.isEmpty()) {

            int curr = q.poll();
            count++;

            for (int nei : graph.get(curr)) {

                indegree[nei]--;

                if (indegree[nei] == 0)
                    q.offer(nei);
            }
        }

        return count == n;
    }
}