class Solution {
    class DSU {
        int[] parent;
        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]); 
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }
    public int largestComponentSize(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        DSU dsu = new DSU(maxVal + 1);
        for (int num : nums) {
            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {
                    dsu.union(num, factor);         
                    dsu.union(num, num / factor);    
                }
            }
        }
        int[] componentSizes = new int[maxVal + 1];
        int maxComponentSize = 0;
        for (int num : nums) {
            int root = dsu.find(num);
            componentSizes[root]++;
            maxComponentSize = Math.max(maxComponentSize, componentSizes[root]);
        }
        return maxComponentSize;
    }
}