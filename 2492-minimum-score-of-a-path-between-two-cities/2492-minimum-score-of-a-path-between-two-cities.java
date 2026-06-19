class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int distance = road[2];
            graph[a].add(new int[]{b, distance});
            graph[b].add(new int[]{a, distance});
        }
        boolean[] visited = new boolean[n + 1];
        return dfs(1, graph, visited, Integer.MAX_VALUE);
    }
    private int dfs(int city, List<int[]>[] graph, boolean[] visited, int answer) {
        visited[city] = true;
        for (int[] road : graph[city]) {
            int nextCity = road[0];
            int distance = road[1];
            answer = Math.min(answer, distance);
            if (!visited[nextCity]) {
                answer = dfs(nextCity, graph, visited, answer);
            }
        }
        return answer;
    }
}