class Solution {
    public int findKthLargest(int[] nums, int k) {
        int targetIndex = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == targetIndex) {
                return nums[pivotIndex];
            } 
            else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            } 
            else {
                right = pivotIndex - 1;
            }
        }
        return -1;
    }
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right]; 
        int p = left; 
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, p);
                p++; 
            }
        }
        swap(nums, p, right);
        return p; 
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}