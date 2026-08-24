class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int resIdx = right;
        while(left <= right){
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                res[resIdx] = nums[right]*nums[right];
                right--;
            }else{
                res[resIdx] = nums[left]*nums[left];
                left++;
            }
            resIdx--;
        }
        return res;
    }
}