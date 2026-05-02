class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0]+nums[1]+nums[2];
        for(int i=0; i<nums.length-2; i++){
            int start = i+1;
            int end=nums.length-1;
            while(start < end){
                int currentSum = nums[i]+nums[start]+nums[end];
                if (currentSum == target) {
                    return currentSum;
                }
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }
                if (currentSum > target) {
                    end--;
                } else {
                    start++;
                }
            }    
        }
        return closestSum;
    }
}