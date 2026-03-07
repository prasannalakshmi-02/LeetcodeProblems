class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int value = Math.abs(nums[i]);
            int idx = value-1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            } 
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }
}