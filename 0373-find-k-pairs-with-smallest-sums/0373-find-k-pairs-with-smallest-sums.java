class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> (a[0]+a[1]) - (b[0]+b[1]));
        for(int i=0; i<nums1.length && i<k; i++){
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while(k>0 && !minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            res.add(Arrays.asList(curr[0], curr[1]));
            int index = curr[2];
            if(index+1 < nums2.length){
                minHeap.offer(new int[]{curr[0], nums2[index+1], index+1});
            }
            k--;
        }
        return res;
    }
}