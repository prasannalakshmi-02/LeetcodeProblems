class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPosition = findFirst(nums, target);
        int lastPosition = findLast(nums, target);
        return new int[]{firstPosition, lastPosition};
    }
    int findFirst(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int res = -1;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target){
                res = mid;
                end = mid-1;
            }else if(nums[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
    int findLast(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int res = -1;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target){
                res = mid;
                start = mid+1;
            }else if(nums[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
}