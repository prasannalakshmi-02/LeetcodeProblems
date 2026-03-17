class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) ->b-a);
        for(int i : stones){
            maxHeap.add(i);
        }
        while(maxHeap.size() > 1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if(stone1 != stone2){
                maxHeap.add(stone1-stone2);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}