class Solution {
     public int largestComponentSize(int[] nums) {
        int n = nums.length;
        int[] parent = new int[n];
        int[] size = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            int num = nums[i];
            for(int f=2; f*f<=num; f++) {
                if(num % f == 0) {
                    if(map.containsKey(f)) {
                        union(i, map.get(f), parent, size);
                    }
                    else {
                        map.put(f, i);
                    }
                    while(num % f == 0) {
                        num /= f;
                    }
                }
            }
            if(num > 1) {
                if(map.containsKey(num)) {
                    union(i, map.get(num), parent, size);
                }
                else {
                    map.put(num, i);
                }
            }
        }
        int max = 0;
        for(int i=0; i<n; i++) {
            int p = find(i, parent);
            max = Math.max(max, size[p]);
        }
        return max;
    }
    public int find(int x, int[] parent) {
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x], parent);
    }
    public void union(int a, int b,
                      int[] parent,
                      int[] size) {

        int pa = find(a, parent);
        int pb = find(b, parent);

        if(pa == pb)
            return;

        if(size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        }
        else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }
}