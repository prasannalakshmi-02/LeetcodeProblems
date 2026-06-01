class Solution {
     public boolean isPossible(int n, List<List<Integer>> edges) {

        int[] degree = new int[n + 1];
        Set<String> edgeSet = new HashSet<>();

        // Calculate degrees and store existing edges
        for (List<Integer> edge : edges) {

            int u = edge.get(0);
            int v = edge.get(1);

            degree[u]++;
            degree[v]++;

            edgeSet.add(getKey(u, v));
        }

        // Find all odd degree nodes
        List<Integer> odd = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 1) {
                odd.add(i);
            }
        }

        // Case 1: Already all even
        if (odd.size() == 0) {
            return true;
        }

        // Case 2: Exactly 2 odd nodes
        if (odd.size() == 2) {

            int a = odd.get(0);
            int b = odd.get(1);

            // Try connecting them directly
            if (!hasEdge(a, b, edgeSet)) {
                return true;
            }

            // Try using a third node
            for (int x = 1; x <= n; x++) {

                if (x == a || x == b) {
                    continue;
                }

                if (!hasEdge(a, x, edgeSet) &&
                    !hasEdge(b, x, edgeSet)) {
                    return true;
                }
            }

            return false;
        }

        // Case 3: Exactly 4 odd nodes
        if (odd.size() == 4) {

            int a = odd.get(0);
            int b = odd.get(1);
            int c = odd.get(2);
            int d = odd.get(3);

            // Pairing 1: (a,b) and (c,d)
            if (!hasEdge(a, b, edgeSet) &&
                !hasEdge(c, d, edgeSet)) {
                return true;
            }

            // Pairing 2: (a,c) and (b,d)
            if (!hasEdge(a, c, edgeSet) &&
                !hasEdge(b, d, edgeSet)) {
                return true;
            }

            // Pairing 3: (a,d) and (b,c)
            if (!hasEdge(a, d, edgeSet) &&
                !hasEdge(b, c, edgeSet)) {
                return true;
            }

            return false;
        }

        // Case 4: More than 4 odd nodes
        return false;
    }

    private boolean hasEdge(int u, int v, Set<String> edgeSet) {
        return edgeSet.contains(getKey(u, v));
    }

    private String getKey(int u, int v) {
        return Math.min(u, v) + "#" + Math.max(u, v);
    }
}