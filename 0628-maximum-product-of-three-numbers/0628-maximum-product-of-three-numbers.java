class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int prod1 = nums[0]*nums[1]*nums[n-1];
        int prod2 = nums[n-1]*nums[n-2]*nums[n-3];
        return prod1 > prod2 ? prod1 : prod2;
    }
}