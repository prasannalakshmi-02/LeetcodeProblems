class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                int[] result = dfs(i, graph, visited);
                int nodes = result[0];
                int edgesCount = result[1];
                if(edgesCount == nodes * (nodes - 1)) {
                    answer++;
                }
            }
        }
        return answer;
    }
    private int[] dfs(int node, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        int nodes = 1;
        int edges = graph[node].size();
        for(int next : graph[node]) {
            if(!visited[next]) {
                int[] result = dfs(next, graph, visited);
                nodes += result[0];
                edges += result[1];
            }
        }
        return new int[]{nodes, edges};
    }
}