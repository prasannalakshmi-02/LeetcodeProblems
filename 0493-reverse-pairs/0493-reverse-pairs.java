class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0; 
        int mid = low + (high - low) / 2;
        int count = 0;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }
    private int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int rightPointer = mid + 1;
        for (int leftPointer = low; leftPointer <= mid; leftPointer++) {
            while (rightPointer <= high && nums[leftPointer] > 2L * nums[rightPointer]) {
                rightPointer++;
            }
            count += (rightPointer - (mid + 1));
        }
        return count;
    }
    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, index = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }
        while (left <= mid) temp[index++] = nums[left++];
        while (right <= high) temp[index++] = nums[right++];
        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }
}