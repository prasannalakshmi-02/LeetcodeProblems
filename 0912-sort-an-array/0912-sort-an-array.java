class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
        return nums;
    }
    private void heapify(int[] nums, int heapSize, int rootIndex) {
        int largest = rootIndex; 
        int leftChild = 2 * rootIndex + 1; 
        int rightChild = 2 * rootIndex + 2; 
        if (leftChild < heapSize && nums[leftChild] > nums[largest]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && nums[rightChild] > nums[largest]) {
            largest = rightChild;
        }
        if (largest != rootIndex) {
            swap(nums, rootIndex, largest);
            heapify(nums, heapSize, largest);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}