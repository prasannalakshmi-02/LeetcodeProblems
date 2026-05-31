class Solution {
     class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x)
                return x;

            return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {

        DSU dsu = new DSU(n);

        boolean[] result = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {

            int u = requests[i][0];
            int v = requests[i][1];

            int pu = dsu.find(u);
            int pv = dsu.find(v);

            boolean possible = true;

            for (int[] r : restrictions) {

                int x = r[0];
                int y = r[1];

                int px = dsu.find(x);
                int py = dsu.find(y);

                if ((px == pu && py == pv) ||
                    (px == pv && py == pu)) {

                    possible = false;
                    break;
                }
            }

            if (possible) {
                dsu.union(u, v);
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}