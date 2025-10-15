class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int writeIdx = 2;
        for(int i=2; i<n; i++){
            if(nums[i] != nums[writeIdx-2]){
                nums[writeIdx] = nums[i];
                writeIdx++;
            }
        }
        return writeIdx;
    }
}