class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] red = new ArrayList[n];
        List<Integer>[] blue = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            red[i] = new ArrayList<>();
            blue[i] = new ArrayList<>();
        }
        for(int[] edge : redEdges) {
            red[edge[0]].add(edge[1]);
        }
        for(int[] edge : blueEdges) {
            blue[edge[0]].add(edge[1]);
        }
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        answer[0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        queue.offer(new int[]{0,1});
        boolean[][] visited = new boolean[n][2];
        visited[0][0] = true;
        visited[0][1] = true;
        int distance = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] current = queue.poll();
                int node = current[0];
                int color = current[1];
                List<Integer>[] nextGraph;
                if(color == 0) {
                    nextGraph = blue;
                } else {
                    nextGraph = red;
                }
                for(int next : nextGraph[node]) {
                    int nextColor = 1 - color;
                    if(!visited[next][nextColor]) {
                        visited[next][nextColor] = true;
                        queue.offer(
                            new int[]{next,nextColor}
                        );
                        if(answer[next] == -1) {
                            answer[next] = distance + 1;
                        }
                    }
                }
            }
            distance++;
        }
        return answer;
    }
}