class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for(int num : nums)totalSum += num;
        int rem = (int)(totalSum%p);
        if(rem == 0)return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0;
        int minLen = nums.length;
        for(int i=0; i<nums.length; i++){
            currSum = (currSum + nums[i]) % p;
            int needed = (currSum - rem + p) % p;
            if(map.containsKey(needed)){
                int currentLength = i - map.get(needed);
                minLen = Math.min(minLen, currentLength);
            }
            map.put(currSum, i);
        }
        return minLen == nums.length ? -1 : minLen;
    }
}