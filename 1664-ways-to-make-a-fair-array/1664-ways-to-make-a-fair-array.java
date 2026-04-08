class Solution {
    public int waysToMakeFair(int[] nums) {
        int totalEven = 0;
        int totalOdd = 0;
        for(int i=0; i<nums.length; i++){
            if(i%2 == 0)totalEven += nums[i];
            else totalOdd += nums[i];
        }
        int leftEven = 0;
        int leftOdd = 0;
        int fairCount = 0;
        for(int i=0; i<nums.length; i++){
            int rightEven = totalEven - leftEven - (i % 2 == 0 ? nums[i] : 0);
            int rightOdd = totalOdd - leftOdd - (i % 2 != 0 ? nums[i] : 0);
            int newEven = leftEven + rightOdd;
            int newOdd = leftOdd + rightEven;
            if (newEven == newOdd) {
                fairCount++;
            }
            if (i % 2 == 0) leftEven += nums[i];
            else leftOdd += nums[i];
        }
        return fairCount;
    }
}