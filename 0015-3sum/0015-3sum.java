class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<n-2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) 
                continue;
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
            if(sum == 0){
                res.add(Arrays.asList(nums[left], nums[right], nums[i]));
                while(left<right && nums[left] == nums[left+1]) left++;
                while(left<right && nums[right] == nums[right-1]) right--;
                left++;
                right--;
            }else if(sum < 0){
                left++;
            }else{
                right--;
            }
          } 
        }
        return res;
    }
}