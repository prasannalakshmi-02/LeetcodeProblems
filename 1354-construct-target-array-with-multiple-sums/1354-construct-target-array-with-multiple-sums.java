class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) return target[0] == 1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long totalSum = 0;
        for(int nums : target){
            maxHeap.add(nums);
            totalSum += nums;
        }
        while(maxHeap.peek() > 1){
            int max = maxHeap.poll();
            long restSum = totalSum - max;
            if(restSum == 1)return true;
            if (restSum == 0 || max <= restSum || max % restSum == 0) return false;
            int oldValue = (int)(max % restSum);
            maxHeap.add(oldValue);
            totalSum = totalSum-max+oldValue;
        }
        return true;
    }
}