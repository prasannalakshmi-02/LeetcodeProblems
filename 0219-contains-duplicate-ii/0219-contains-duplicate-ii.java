class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       HashSet<Integer> activeWindow = new HashSet<>();
       for(int i=0; i<nums.length; i++){
          int num = nums[i];
          if(activeWindow.contains(num)){
              return true;
          }
          activeWindow.add(nums[i]);
          if (activeWindow.size() > k) {
              activeWindow.remove(nums[i - k]);
          }
       }
       return false;
    }
}