class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for(int i=0; i<nums.length; i++){
            count[nums[i]]++;
        }
        int totalSum = 0;
        for(int i=0; i<count.length; i++){
           int currentFreq = count[i];
            count[i] = totalSum; 
            totalSum += currentFreq;
        }
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            res[i] = count[nums[i]];
        }
        return res;
    }
}