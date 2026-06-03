class Solution {
    int maxQuality = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
          int n = values.length;

        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int time = edge[2];

            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        int[] visitCount = new int[n];

        visitCount[0] = 1;

        dfs(0,
            0,
            values[0],
            values,
            graph,
            visitCount,
            maxTime);

        return maxQuality;
    }

    private void dfs(int node,
                     int timeUsed,
                     int quality,
                     int[] values,
                     List<List<int[]>> graph,
                     int[] visitCount,
                     int maxTime) {

        if(node == 0) {
            maxQuality = Math.max(maxQuality, quality);
        }

        for(int[] neighbour : graph.get(node)) {

            int nextNode = neighbour[0];
            int cost = neighbour[1];

            if(timeUsed + cost > maxTime) {
                continue;
            }

            boolean firstVisit = visitCount[nextNode] == 0;

            visitCount[nextNode]++;

            dfs(
                nextNode,
                timeUsed + cost,
                firstVisit ? quality + values[nextNode] : quality,
                values,
                graph,
                visitCount,
                maxTime
            );

            visitCount[nextNode]--;
        }
    }
}