class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++){
            int val = Math.abs(nums[i]);
            int idx = val-1;
            if(nums[idx] < 0){
                res[0] = val;
            }else{
                nums[idx] = -nums[idx];
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                res[1] = i+1;
            }
        }
        return res;
    }
}