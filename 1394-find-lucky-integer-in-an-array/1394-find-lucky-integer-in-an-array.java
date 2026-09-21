class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int nums : arr){
            map.put(nums, map.getOrDefault(nums, 0)+1);
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (num == freq) {
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }
}