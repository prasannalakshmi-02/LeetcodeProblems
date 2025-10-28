class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int curMax = 0, maxSum = nums[0];
        int curMin = 0, minSum = nums[0];
        for(int num : nums){
            curMax = Math.max(curMax+num, num);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin+num, num);
            minSum = Math.min(minSum, curMin);

            total += num;
        }
        if(maxSum < 0){
            return maxSum;
        }
        return Math.max(maxSum, total-minSum);
    }
}